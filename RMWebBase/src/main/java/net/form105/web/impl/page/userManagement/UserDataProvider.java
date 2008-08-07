package net.form105.web.impl.page.userManagement;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.form105.rm.base.model.user.User;

import org.apache.log4j.Logger;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class UserDataProvider extends SortableDataProvider {

	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(UserDataProvider.class);
	public static String myString;
	
	enum SortColumnId {
		ID,
		EMAIL,
		SIRNAME,
		SHORTNAME;
	}
	
	private List<User> input;
	
	public UserDataProvider(List<User> input) {
		this.input = input;
		SortParam sortParam = new SortParam(SortColumnId.ID.name(), true);
		sort(sortParam);
	}

	@Override
	public Iterator<User> iterator(int first, int count) {
		
		SortParam sortParam = getSort();
		if (sortParam != null) {
			sort(sortParam);
		}
		
		int toIndex = first + count;
		if (toIndex > input.size())
		{
			toIndex = input.size();
		}
		return input.subList(first, toIndex).listIterator();
	}

	@Override
	public IModel model(Object object) {
		return new Model((Serializable)object);
	}

	@Override
	public int size() {
		return input.size();
	}

	@Override
	public void detach() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Do this annoying sorting staff. Create for each SortColumn its own Comparator ....
	 * @param sortParam
	 */
	public void sort(final SortParam sortParam) {
		if (sortParam == null) {
			return;
		}
		
		SortColumnId column = SortColumnId.valueOf(sortParam.getProperty());
		
		Comparator<User> comparator;
		
		switch (column) {
		case EMAIL:
			comparator = new Comparator<User>() {
				@Override
				public int compare(User user1, User user2) {
					int result = user1.getEMail().compareTo(user2.getEMail());
					return sortParam.isAscending() ? result : -result;
				}
			};
			Collections.sort(input, comparator);
			break;

		case ID: 
			comparator = new Comparator<User>() {
				@Override
				public int compare(User user1, User user2) {
					int result = user1.getId().compareTo(user2.getId());
					return sortParam.isAscending() ? result : -result;
				}
			};
			Collections.sort(input, comparator);
			break;
			
		case SHORTNAME: 
			comparator = new Comparator<User>() {
				@Override
				public int compare(User user1, User user2) {
					int result = user1.getShortName().compareTo(user2.getShortName());
					return sortParam.isAscending() ? result : -result;
				}
			};
			Collections.sort(input, comparator);
			break;
			
		case SIRNAME: 
			comparator = new Comparator<User>() {
				@Override
				public int compare(User user1, User user2) {
					int result = user1.getSirName().compareTo(user2.getSirName());
					return sortParam.isAscending() ? result : -result;
				}
			};
			Collections.sort(input, comparator);
			break;
			
		default:
			break;
		}
	}
}

package net.form105.web.impl.page.userManagement;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.form105.rm.base.dao.XMLUserObjectDAO;
import net.form105.rm.base.model.user.User;
import net.form105.rm.base.query.FindAllDaoQuery;
import net.form105.rm.base.query.LocalQueryHandler;
import net.form105.rm.base.service.IResult;
import net.form105.web.base.model.provider.FilterDataProvider;

import org.apache.log4j.Logger;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.model.IModel;

public class UserDataProvider extends FilterDataProvider<User> {

	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(UserDataProvider.class);
	public static String myString;
	
	private List<User> input;

	public enum SortColumnId {
		ID, EMAIL, SIRNAME, SHORTNAME;
	}


	public UserDataProvider() {
		input = createInput();
		SortParam sortParam = new SortParam(SortColumnId.ID.name(), true);
		sort(sortParam);
		
	}

	@Override
	public Iterator<User> iterator(int first, int count) {
		
		input = getInput();

		SortParam sortParam = getSort();
		if (sortParam != null) {
			sort(sortParam);
		} else {
			sort(new SortParam(SortColumnId.ID.name(), true));
		}

		int toIndex = first + count;
		if (toIndex > input.size()) {
			toIndex = input.size();
		}
		return getInput().subList(first, toIndex).listIterator();
	}

	@Override
	public IModel model(Object object) {
		SelectionModel selectionModel = new SelectionModel((Serializable) object);
		return selectionModel;
	}

	@Override
	public int size() {
		return getInput().size();
	}

	/**
	 * Do this annoying sorting staff. Create for each SortColumn its own
	 * Comparator ....
	 * 
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

	public List<User> getInput() {
		return input;
	}
	
	private List<User> createInput() {
		LocalQueryHandler<User> queryHandler = new LocalQueryHandler<User>();
		FindAllDaoQuery<User> query = new FindAllDaoQuery<User>(XMLUserObjectDAO.class);
		queryHandler.executeQuery(query);
		IResult<User> result = queryHandler.getResult();
		List<User> users = result.getResultList();
		return users;
	}
	
	public class SelectionModel implements IModel, Serializable {

		private static final long serialVersionUID = 1L;
		private boolean selected;
		private Object object;
		
		public SelectionModel(Serializable object) {
			this.object = object;
		}
		

		public boolean isSelected() {
			return selected;
		}

		public void setSelected(boolean selected) {
			this.selected = selected;
		}


		@Override
		public Object getObject() {
			return object;
		}


		@Override
		public void setObject(Object object) {
			this. object = object;
			
		}


		@Override
		public void detach() {
		}
		
	}
}

package net.form105.web.impl.action;

import org.apache.wicket.model.IModel;

public class IconLabelModel implements IModel {
	
	private static final long serialVersionUID = 1L;
	private ImageLabel content;
	
	public IconLabelModel(String image, String text) {
		content = new ImageLabel(image, text);
	}

	@Override
	public Object getObject() {
		return content;
	}

	@Override
	public void setObject(Object object) {
		content = (ImageLabel) object;

	}

	@Override
	public void detach() {}
	
	public class ImageLabel {
		private String text;
		private String image;
		
		public ImageLabel(String image, String text) {
			this.image = image;
			this.text = text;
		}
		
		public String getText() {
			return text;
		}
		
		public String getImage() {
			return image;
		}
	}

}

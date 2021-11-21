package dto;

import java.io.Serializable;

public class CommonProperty implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	
	public CommonProperty() {
		this.id = "";
	}

	public CommonProperty(String id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "CommonProperty [id=" + id + "]";
	 }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	

}

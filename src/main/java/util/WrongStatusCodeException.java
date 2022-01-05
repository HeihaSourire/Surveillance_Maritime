package util;

import org.json.JSONObject;

public class WrongStatusCodeException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongStatusCodeException() {
		super("Wrong status code in HTTP request");
	}
	
	public WrongStatusCodeException(String m) {
		super(m);
	}
	
	public JSONObject getErrorJSON() {
		return new JSONObject().put("error",this.getMessage());
	}
}

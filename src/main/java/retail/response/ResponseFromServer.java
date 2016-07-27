package main.java.retail.response;

import main.java.retail.dto.Shop;

/**
 * ResponseFromServer class formats the response to send to client
 * 
 * @author Anuja
 *
 */
public class ResponseFromServer {
	private String status;
	private String message;
	private Shop shop;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public ResponseFromServer(String status, String message, Shop shop) {
		super();
		this.status = status;
		this.message = message;
		this.shop = shop;
	}

	
}

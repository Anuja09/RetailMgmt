package main.java.retail.dto;

/**
 * POJO ShopAddress(shopnumber, shopPostalCode)
 * 
 * @author Anuja
 *
 */
public class ShopAddress {
	Integer number;
	String postCode;

	public ShopAddress() {

	}

	public ShopAddress(Integer number, String postCode) {
		super();
		this.number = number;
		this.postCode = postCode;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Override
	public String toString() {
		return "ShopAddress [number=" + number + ", postCode=" + postCode + "]";
	}

}

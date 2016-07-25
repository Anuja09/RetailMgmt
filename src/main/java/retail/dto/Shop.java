package main.java.retail.dto;

public class Shop {
	String shopName;
	ShopAddress shopAddress;
	Double longitude;
	Double latitude;
	
	public Shop() {
		super();
	}
	public Shop(String shopName, ShopAddress shopAddress, Double longitude, Double latitude) {
		super();
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public ShopAddress getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(ShopAddress shopAddress) {
		this.shopAddress = shopAddress;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	@Override
	public String toString() {
		return "Shop [shopName=" + shopName + ", shopAddress=" + shopAddress + ", longitude=" + longitude
				+ ", latitude=" + latitude + "]";
	}
	
	
}

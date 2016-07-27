package main.java.retail.service.impl;

import java.util.List;

import com.google.code.geocoder.model.LatLng;

import main.java.retail.dto.Shop;
import main.java.retail.geo.Util.GeoCoderUtil;
import main.java.retail.service.RetailService;
import main.java.storage.ShopStorageInmemory;

/**
 * RetailServiceImpl provides retail manager services for Shop
 * 
 * @author Anuja
 *
 */
public class RetailServiceImpl implements RetailService {
	/**
	 * The service method adds shop to in memory storage
	 * 
	 * @param shop
	 *            to be added
	 * @return Boolean, true if shop added successfully otherwise false
	 */
	@Override
	public Boolean add(Shop shop) {
		// https://maps.googleapis.com/maps/api/geocode/json?address=Prasun%20Savoy
		String shopAddress = shop.getShopName() + "+" + shop.getShopAddress().getNumber() + "+"
				+ shop.getShopAddress().getPostCode();
		LatLng latLng = GeoCoderUtil.getLatLngByShopAddress(shopAddress);
		if (latLng == null) {
			System.out.println("The address is not valid");
			return Boolean.FALSE;
		} else {
			Double latitude = latLng.getLat().doubleValue();
			Double longitude = latLng.getLng().doubleValue();
			shop.setLongitude(longitude);
			shop.setLatitude(latitude);
			ShopStorageInmemory.getInstance().getList().add(shop);
			return Boolean.TRUE;
		}

	}

	/**
	 * The service method finds and return nearest shop to controller
	 * 
	 * @param longitude,
	 *            latitude
	 * 
	 * @return Shop, shop if found otherwise null
	 */
	@Override
	public Shop find(Double longitude, Double latitude) {
		Shop nearestShop = null;
		List<Shop> shopList = ShopStorageInmemory.getInstance().getList();
		Double difference = 0.0;
		LatLng currentAddr = new LatLng(latitude.toString(), longitude.toString());
		for (Shop shop : shopList) {
			LatLng destAddr = new LatLng(shop.getLatitude().toString(), shop.getLongitude().toString());

			if (nearestShop == null) {
				nearestShop = shop;
			} else {
				Double shopDistance = GeoCoderUtil.getDifference(currentAddr, destAddr);
				if (difference > (shopDistance)) {
					difference = shopDistance;
					nearestShop = shop;
				}
			}
			difference = GeoCoderUtil.getDifference(currentAddr, destAddr);
		}
		return nearestShop;
	}

	/**
	 * The service method returns list of available shops to controller
	 * 
	 * @return List<Shop>
	 */
	@Override
	public List<Shop> get() {
		return ShopStorageInmemory.getInstance().getList();
	}

}

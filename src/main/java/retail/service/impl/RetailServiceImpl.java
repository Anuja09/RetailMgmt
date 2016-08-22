package main.java.retail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.code.geocoder.model.LatLng;

import main.java.retail.dao.RetailDAO;
import main.java.retail.dto.Shop;
import main.java.retail.geo.Util.GeoCoderUtil;
import main.java.retail.service.RetailService;

/**
 * RetailServiceImpl provides retail manager services for Shop
 * 
 * @author Anuja
 *
 */
@Service("retailService")
public class RetailServiceImpl implements RetailService {
	/**
	 * RetailDAO object
	 */
	private RetailDAO retailDAO;
	
	public RetailDAO getRetailDAO() {
		return retailDAO;
	}

	@Autowired
	public void setRetailDAO(RetailDAO retailDAO) {
		this.retailDAO = retailDAO;
	}

	@Override
	public Boolean add(Shop shop) {
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
			retailDAO.add(shop);
			return Boolean.TRUE;
		}

	}

	@Override
	public Shop find(Double longitude, Double latitude) {
		Shop nearestShop =retailDAO.find(longitude, latitude);
		return nearestShop;
	}

	@Override
	public List<Shop> get() {
		return retailDAO.get();
	}

}

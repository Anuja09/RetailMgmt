package main.java.retail.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.code.geocoder.model.LatLng;

import main.java.retail.dao.RetailDAO;
import main.java.retail.dto.Shop;
import main.java.retail.geo.Util.GeoCoderUtil;
import main.java.storage.ShopStorageInmemory;

/**
 * RetailDAOImpl provide access to in memory array
 * 
 * @author Anuja
 *
 */
@Repository("retailDAO")
public class RetailDAOImpl implements RetailDAO {
	@Override
	public Boolean add(Shop shop) {
		return ShopStorageInmemory.getInstance().getList().add(shop);
	}

	@Override
	public List<Shop> get() {
		List<Shop> shopList = ShopStorageInmemory.getInstance().getList();
		return shopList;
	}

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

}

package main.java.retail.service.impl;

import java.io.IOException;
import java.util.List;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.LatLng;

import main.java.retail.dto.Shop;
import main.java.retail.service.RetailService;
import main.java.storage.ShopStorageInmemory;

public class RetailServiceImpl implements RetailService{
	private static double mile_calc = 3959;
	@Override
	public void add(Shop shop) {
		//https://maps.googleapis.com/maps/api/geocode/json?address=Prasun%20Savoy
		final Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(shop.getShopName() + "+"
				+ shop.getShopAddress().getNumber() + "+" + shop.getShopAddress().getPostCode()).getGeocoderRequest();
		GeocodeResponse geocoderResponse = null;
		try {
			geocoderResponse = geocoder.geocode(geocoderRequest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<GeocoderResult> results = geocoderResponse.getResults();
		Double latitude = results.get(0).getGeometry().getLocation().getLat().doubleValue();
		Double longitude = results.get(0).getGeometry().getLocation().getLng().doubleValue();
		shop.setLongitude(longitude);
		shop.setLatitude(latitude);
		ShopStorageInmemory.getInstance().getList().add(shop);
	}

	@Override
	public Shop find(Double longitude, Double latitude) {
		Shop shop = null;
		List<Shop> shopList = ShopStorageInmemory.getInstance().getList();
		Double difference = 0.0;
		LatLng obj1 = new LatLng(latitude.toString(), longitude.toString());
		for (Shop shop2 : shopList) {
			LatLng obj2 = new LatLng(shop2.getLatitude().toString(), shop2.getLongitude().toString());
			
			if(shop==null) {
				shop=shop2;
			} else {
				Double shopDistance = getDifference(obj1, obj2);
				if(difference>(shopDistance)) {
					difference = shopDistance;
					shop=shop2; 
				}
			}
			difference = getDifference(obj1,obj2);
		}
		return shop;
	}
	
	private double getDifference(LatLng from, LatLng to) {		
		
		return  mile_calc * Math.acos(Math.cos(Math.toRadians(from.getLat().doubleValue())) * Math.cos(Math.toRadians(to.getLat().doubleValue())) 
				* Math.cos(Math.toRadians(to.getLng().doubleValue()) - Math.toRadians(from.getLng().doubleValue()) ) 
				+ Math.sin(Math.toRadians(from.getLat().doubleValue()) ) * Math.sin(Math.toRadians(to.getLat().doubleValue())));		
	}

	@Override
	public List<Shop> get() {
		return ShopStorageInmemory.getInstance().getList();
	}

}

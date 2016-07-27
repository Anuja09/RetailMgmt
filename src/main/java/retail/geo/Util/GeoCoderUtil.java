package main.java.retail.geo.Util;

import java.io.IOException;
import java.util.List;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;

/**
 * This class provides the retail manager geocoder utility methods
 * 
 * @author Anuja
 *
 */
public class GeoCoderUtil {
	final static Geocoder geocoder = new Geocoder();
	final private static double mile_calc = 3959;

	/**
	 * This method calculates longitude, latitude from shop address and returns
	 * in LatLng
	 * 
	 * @param shopAddress
	 * @return LatLng
	 */
	public static LatLng getLatLngByShopAddress(String shopAddress) {
		LatLng latLng = null;
		List<GeocoderResult> results = null;
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(shopAddress).getGeocoderRequest();
		GeocodeResponse geocoderResponse = null;
		try {
			geocoderResponse = geocoder.geocode(geocoderRequest);
			System.out.println("GeoCoder Response Status : " + geocoderResponse.getStatus());
		} catch (IOException e) {
			e.printStackTrace();
		}
		geocoderResponse.getStatus();
		if (geocoderResponse != null && "OK".equals(GeocoderStatus.OK.name())) {
			results = geocoderResponse.getResults();
			if (results != null && results.size() > 0)
				latLng = results.get(0).getGeometry().getLocation();
		}
		return latLng;
	}

	/**
	 * This method calculates distance of a shop from particular location
	 * 
	 * @param from
	 *            -particular location
	 * @param to
	 *            - shop location
	 * @return double distance in miles
	 */
	public static double getDifference(LatLng from, LatLng to) {

		return mile_calc * Math.acos(Math.cos(Math.toRadians(from.getLat().doubleValue()))
				* Math.cos(Math.toRadians(to.getLat().doubleValue()))
				* Math.cos(Math.toRadians(to.getLng().doubleValue()) - Math.toRadians(from.getLng().doubleValue()))
				+ Math.sin(Math.toRadians(from.getLat().doubleValue()))
						* Math.sin(Math.toRadians(to.getLat().doubleValue())));
	}
}

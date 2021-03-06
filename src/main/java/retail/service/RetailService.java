package main.java.retail.service;

import java.util.List;

import main.java.retail.dto.Shop;

/**
 * It is a template for providing retail manager services
 * 
 * @author Anuja
 *
 */
public interface RetailService {
	/**
	 * The service method to call add of dao layer
	 * 
	 * @param shop
	 *            to be added
	 * @return Boolean, true if shop added successfully otherwise false
	 */
	public Boolean add(Shop shop);

	/**
	 * The service method finds and return nearest shop to controller
	 * 
	 * @param longitude,
	 *            latitude
	 * 
	 * @return Shop, shop if found otherwise null
	 */
	public Shop find(Double longitude, Double latitude);

	/**
	 * The service method returns list of available shops to controller
	 * 
	 * @return List<Shop>
	 */
	public List<Shop> get();
}

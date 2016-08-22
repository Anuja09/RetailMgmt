package main.java.retail.dao;

import java.util.List;

import main.java.retail.dto.Shop;

/**
 * It is a template for retail manager data access layer
 * 
 * @author Anuja
 *
 */
public interface RetailDAO {
	/**
	 * The dao method adds shop to in memory storage
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

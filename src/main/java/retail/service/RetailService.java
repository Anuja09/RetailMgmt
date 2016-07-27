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
	public Boolean add(Shop shop);

	public Shop find(Double longitude, Double latitude);

	public List<Shop> get();
}

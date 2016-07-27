package main.java.storage;

import java.util.ArrayList;
import java.util.List;

import main.java.retail.dto.Shop;

/**
 * This class serves as inmemory database
 * 
 * @author Anuja
 *
 */
public class ShopStorageInmemory {
	private List<Shop> list = null;
	private static ShopStorageInmemory shopStore = null;

	private ShopStorageInmemory() {
	}

	/**
	 * This method acts as factory and returns a singleton instance of it
	 * 
	 * @return
	 */
	public static ShopStorageInmemory getInstance() {
		if (shopStore == null) {
			shopStore = new ShopStorageInmemory();
			shopStore.list = new ArrayList<Shop>();
		}
		return shopStore;
	}

	/**
	 * This method returns list of shops available in memory
	 * 
	 * @return List<Shop> of shops present in memory
	 */
	public List<Shop> getList() {
		return shopStore.list;
	}

}

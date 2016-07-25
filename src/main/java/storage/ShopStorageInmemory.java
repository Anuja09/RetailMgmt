package main.java.storage;

import java.util.ArrayList;
import java.util.List;

import main.java.retail.dto.Shop;

public class ShopStorageInmemory {
	private  List<Shop> list = null;
	private static ShopStorageInmemory  shopStore= null;
	private ShopStorageInmemory() {
		
	}
	public static ShopStorageInmemory getInstance() {
		if(shopStore == null) {
			shopStore = new ShopStorageInmemory();
			if(shopStore.list == null) 
				shopStore.list = new ArrayList<Shop>();
		}
		return shopStore;
	}
	public List<Shop> getList() {
		return shopStore.list;
	}

}

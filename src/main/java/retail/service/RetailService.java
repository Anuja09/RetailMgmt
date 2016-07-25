package main.java.retail.service;

import java.util.List;

import main.java.retail.dto.Shop;

public interface RetailService {
		public void add(Shop shop);
		public Shop find(Double longitude, Double latitude);
		public List<Shop> get();
}

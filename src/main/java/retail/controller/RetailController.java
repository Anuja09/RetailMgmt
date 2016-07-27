package main.java.retail.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.retail.dto.Shop;
import main.java.retail.response.ResponseFromServer;
import main.java.retail.service.RetailService;
import main.java.retail.service.impl.RetailServiceImpl;

/**
 * RetailController controls communication between client and server
 * 
 * @author Anuja
 *
 */
@RestController
@RequestMapping("/shop")
public class RetailController {
	private final RetailService service = new RetailServiceImpl();

	/**
	 * Thid method accepts shop details from client, serves to service and
	 * return result from service to client
	 * 
	 * @param shop
	 * @return ResponseFromServer
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseFromServer add(@RequestBody Shop shop) {
		System.out.println("added shop" + shop.toString());
		ResponseFromServer resp = null;
		if (service.add(shop)) {
			resp = new ResponseFromServer("OK", "Shop added successfully", shop);
		} else {
			resp = new ResponseFromServer("FAILURE", "Shop address is not valid", shop);
		}
		return resp;
	}

	/**
	 * This method accepts longitude and latitude from client, serves it to
	 * service and returns back nearest shop
	 * 
	 * @param longitude
	 * @param latitude
	 * @return ResponseFromServer
	 */
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseFromServer find(@RequestParam(value = "longitude") String longitude,
			@RequestParam(value = "latitude") String latitude) {
		Shop shop = service.find(Double.parseDouble(longitude), Double.parseDouble(latitude));
		ResponseFromServer resp = null;
		if (shop != null) {
			resp = new ResponseFromServer("OK", "Nearest shop found ", shop);
		} else {
			resp = new ResponseFromServer("FAILURE", "No Nearby Shop found", new Shop());
		}
		return resp;
	}

	/**
	 * This method returns list of shops available
	 * 
	 * @return List<Shop>
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Shop> get() {
		return service.get();
	}
}

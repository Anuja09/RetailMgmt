package main.java.retail.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.retail.dto.Shop;
import main.java.retail.dto.ShopAddress;
import main.java.retail.service.RetailService;
import main.java.retail.service.impl.RetailServiceImpl;
@RestController
@RequestMapping("/shop")
public class RetailController {
    private final RetailService service = new RetailServiceImpl();
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody Shop shop) {
       System.out.println("added shop" + shop.toString());
       service.add(shop);
       return "{\"Message\":\"Shop added successfully\"}";
    }
    
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Shop find(@RequestParam(value="longitude") String longitude, @RequestParam(value="latitude") String latitude) {
       return service.find(Double.parseDouble(longitude), Double.parseDouble(latitude));
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Shop> get() {
    	return service.get();
    }
}

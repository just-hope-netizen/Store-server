package com.netizen.storeserver.controller;

import com.netizen.storeserver.model.Product;
import com.netizen.storeserver.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/")
public class StoreController {

    @Autowired
    private StoreService service;

    @GetMapping("products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    };

    @GetMapping("search")
        public List<Product> getProducts(@RequestParam String q) {
      return  service.getProducts(q);
        }


}

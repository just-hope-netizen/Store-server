package com.netizen.storeserver.service;

import com.netizen.storeserver.model.Product;
import com.netizen.storeserver.repo.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public List<Product> getProducts(String q) {
        return repo.findAllByName(q);
    }
}

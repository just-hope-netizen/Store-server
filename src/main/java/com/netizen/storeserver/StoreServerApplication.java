package com.netizen.storeserver;

import com.netizen.storeserver.model.Product;
import com.netizen.storeserver.repo.StoreRepo;
import com.netizen.storeserver.service.StoreService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class StoreServerApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(StoreServerApplication.class, args);
	}

}

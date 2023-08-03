package com.sahil.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sahil.inventoryservice.InventoryResponse;
import com.sahil.inventoryservice.repository.InventoryRepository;


@Service
public class InventoryService {
	
	@Autowired
	InventoryRepository repo;
	
	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skuCodes) {
		List<InventoryResponse> l = repo.findBySkuCodeIn(skuCodes)
				.stream()
				.map(inventory -> InventoryResponse.builder().skuCode(inventory.getSkuCode())
						.isProductInStock(inventory.getQuantity()>0)
						.build())
				.toList();
		System.out.println(l.toString());
		return l;
	
	}
}

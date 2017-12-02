package com.dy.model.services;

import model.entities.Product;

import java.util.List;

public interface ProductService extends GenericService<Product>{

    List<Product> getProductsByPrice(double first, double second);

    List<Product> getProductsByName(String name);

}

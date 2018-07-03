package com.pribas.beans;

import java.util.ArrayList;
import java.util.List;

public class ProductsList {
    private List<Product> Products = new ArrayList<>();

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }
}

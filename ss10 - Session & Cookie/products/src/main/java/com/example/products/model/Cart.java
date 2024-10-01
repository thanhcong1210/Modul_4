package com.example.products.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<Product, Integer>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer integer = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), integer);
        }
    }

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Float countTotalPayment() {
        float totalPayment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            totalPayment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return totalPayment;
    }

    public void updateProduct(Product product, int quantity){
        if (checkItemInCart(product)){
            if (quantity <= 0){
                products.remove(product);
            }else {
                products.put(product, quantity);
            }
        }
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

}

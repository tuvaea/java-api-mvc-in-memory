package com.booleanuk.api.repository;

import com.booleanuk.api.model.Product;

import java.util.ArrayList;

public class ProductRepository {
    private ArrayList<Product> products;

    public ProductRepository(){
        products = new ArrayList<>();

        products.add(new Product("Name 1", "Category 1", 100));
        products.add(new Product("Name 2", "Category 2", 200));
        products.add(new Product("Name 3", "Category 3", 300));
    }


    public ArrayList<Product> getAll(){
        return products;
    }

    public Product getOne(int id){
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public Product remove(int id){
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getId() == id){
                return products.remove(i);
            }
        }
        return null;
    }

    public Product edit(int id, Product newProduct){
        Product product = this.getOne(id);

        product.setName(newProduct.getName());
        product.setCategory(newProduct.getCategory());
        product.setPrice(newProduct.getPrice());
        return product;
    }




}

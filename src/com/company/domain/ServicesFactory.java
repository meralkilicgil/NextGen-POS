package com.company.domain;

public class ServicesFactory {

    LocalProducts localProducts = new LocalProducts();


    public LocalProducts getProductsAdapter(){
       return localProducts.create();
    }
}

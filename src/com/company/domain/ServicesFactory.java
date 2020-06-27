package com.company.domain;

public class ServicesFactory {

    LocalProducts localProducts = new LocalProducts();


    public LocalProducts getProductsAdapter(){
       //DBProductsAdapter externalService = dbProductsAdapter.create();
        //return localProducts.create(externalService);
        return localProducts.create();
    }
}

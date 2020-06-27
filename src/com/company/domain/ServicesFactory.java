package com.company.domain;

public class ServicesFactory {

    DBProductsAdapter dbProductsAdapter = new DBProductsAdapter();
    LocalProducts localProducts = new LocalProducts();


    public LocalProducts getProductsAdapter(){
        DBProductsAdapter externalService = dbProductsAdapter.create();
        return localProducts.create(externalService);
    }
}

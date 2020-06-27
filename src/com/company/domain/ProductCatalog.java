package com.company.domain;

import com.company.customTypes.Money;
import com.company.fileOperations.ProductDescriptionFileOperator;
import com.company.customTypes.ItemID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    //private Map<ItemID,ProductDescription> descriptions = new HashMap<>();
    //ProductDescriptionFileOperator pfdo = new ProductDescriptionFileOperator("..\\NextGenPOS\\ProductDescriptions.txt");
    private LocalProducts localProducts;
    public ProductCatalog(){
        //loadProdSpecs();
    }

    public ProductDescription getProductDescription(ItemID id){
        return this.localProducts.getDescription( id );
    }

    /*public void loadProdSpecs(){
        pfdo.readFromFile();
        descriptions = pfdo.getDescriptions();
    }*/

    public ArrayList<String> getProductIds() {
        ArrayList<String> ids = new ArrayList<>();
        this.localProducts.getDescriptions().forEach((key, value) -> ids.add(key.toString()));
        return ids;
    }

    public void create(){
        ServicesFactory factory = new ServicesFactory();
        this.localProducts = factory.getProductsAdapter();
    }
}

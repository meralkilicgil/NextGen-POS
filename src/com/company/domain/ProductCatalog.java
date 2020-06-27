package com.company.domain;

import com.company.customTypes.Money;
import com.company.fileOperations.ProductDescriptionFileOperator;
import com.company.customTypes.ItemID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map<ItemID,ProductDescription> descriptions = new HashMap<>();
    ProductDescriptionFileOperator pfdo = new ProductDescriptionFileOperator("..\\NextGenPOS\\ProductDescriptions.txt");
    private LocalProducts localProducts;
    public ProductCatalog(){
        loadProdSpecs();
    }

    public ProductDescription getProductDescription(ItemID id){
        return descriptions.get(id);
    }

    public void loadProdSpecs(){
        pfdo.readFromFile();
        descriptions = pfdo.getDescriptions();
    }

    public ArrayList<String> getProductIds() {
        ArrayList<String> ids = new ArrayList<>();
        descriptions.forEach((key, value) -> ids.add(key.toString()));
        return ids;
    }

    public ProductDescription getDescription(ItemID id){
        ProductDescription ps = descriptions.get(id);
        if(ps == null){
            ps = this.localProducts.getDescripton(id);
            if(ps == null){
                ps = new ProductDescription(id, new Money(), "newdesc");
                descriptions.put(id, ps);
                return  ps;
            }
            return null;
        }
        return ps;
    }

    public void create(){
        ServicesFactory factory = new ServicesFactory();
        this.localProducts = factory.getProductsAdapter();
    }
}

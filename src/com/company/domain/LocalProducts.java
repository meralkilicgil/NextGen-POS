package com.company.domain;

import com.company.customTypes.ItemID;
import com.company.customTypes.Money;
import com.company.fileOperations.ProductDescriptionFileOperator;

import java.util.HashMap;
import java.util.Map;

public class LocalProducts implements IProductAdapter{


    private LocalProducts localProducts;
    private Map<ItemID,ProductDescription> descriptions = new HashMap<>();
    ProductDescriptionFileOperator pfdo = new ProductDescriptionFileOperator("..\\NextGenPOS\\ProductDescriptions.txt");

    public LocalProducts(){

    }

    public Map<ItemID,ProductDescription> getDescriptions(){
        return descriptions;
    }

    @Override
    public ProductDescription getDescription(ItemID id){
        ProductDescription ps = descriptions.get(id);
        if(ps == null){
                ps = new ProductDescription(id, new Money(), "newdesc");
                descriptions.put(id, ps);
                return  ps;
        }
        return ps;
    }

    public LocalProducts create(){
            loadProdSpecs();
            return this;
    }

    public void loadProdSpecs(){
        pfdo.readFromFile();
        descriptions = pfdo.getDescriptions();
    }

}

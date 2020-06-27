package com.company.domain;

import com.company.customTypes.ItemID;
import com.company.customTypes.Money;

public class LocalProducts implements IProductAdapter{

    private DBProductsAdapter remoteProductsService;

    @Override
    public ProductDescription getDescripton(ItemID itemId) {
        Money money = null; String desc = null;
        ProductDescription description = new ProductDescription(itemId, money , desc);
        //blabla get description from file
        if(description == null){ //not found in the file
            description = remoteProductsService.getDescripton(itemId);
            if(description == null){
                //if not found again, put that KeyIndexedFileOfSerializedObject
            }
        }
        return description;
    }

    public LocalProducts create(DBProductsAdapter externalService){
        return new LocalProducts();
    }
}

package com.company.domain;

import com.company.customTypes.ItemID;

public class DBProductsAdapter implements IProductAdapter{
    @Override
    public ProductDescription getDescripton(ItemID itemID) {
        //how to found?
        return null;
    }

    public DBProductsAdapter create(){
        return new DBProductsAdapter();
    }
}

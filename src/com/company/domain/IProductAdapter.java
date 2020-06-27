package com.company.domain;

import com.company.customTypes.ItemID;

public interface IProductAdapter {
    ProductDescription getDescripton(ItemID itemID);
}

package com.company.domain;

import com.company.customTypes.ItemID;

public interface IProductAdapter {
    ProductDescription getDescription(ItemID itemID);
}

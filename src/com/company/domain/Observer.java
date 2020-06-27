package com.company.domain;
import com.company.customTypes.Money;


public interface Observer {
    void notify( Money total );
}

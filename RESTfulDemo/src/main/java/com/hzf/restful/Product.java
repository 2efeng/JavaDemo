package com.hzf.restful;

import lombok.Data;

import java.util.Date;

/**
 * Created by zf.huang on 2018.8.3
 */
@Data
public class Product {

    private long id;
    private String name;
    private int price;
    private Date productionDate;

    public Product() {
    }

    public Product(long id, String name, int price, Date productionDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productionDate = productionDate;
    }
}

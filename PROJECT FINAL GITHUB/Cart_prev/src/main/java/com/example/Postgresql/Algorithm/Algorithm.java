package com.example.Postgresql.Algorithm;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Algorithm {

// based on the given weightage sorting the products list
    // (1) merchant total products - 1
    // (2) products sold by a merchant- 2
    // (3) current stock by a  merchant-1
    // (4) merchant rating - 3
    // (5) product price -4
    // (6) product Rating-4

    public static List<MerchantEntity> sortingBasedOnWeightedAverage(List<MerchantEntity> merchants){
        Collections.sort(merchants,new MerchantList());
        return merchants;
    }
}
class MerchantEntity {
    int merchantId;
    int merchantTotalProducts;
    int productSold;
    int currentStock;
    int merchantRating;
    int productPrice;
    int productRating;
}

class MerchantList implements Comparator<MerchantEntity> {
    @Override
    public int compare(MerchantEntity m1, MerchantEntity m2) {
        int a= (m1.currentStock*1+m1.merchantRating*3+m1.productPrice*4+m1.merchantTotalProducts*1+m1.productSold*2+m1.productRating*4)/15;
        int b= (m2.currentStock*1+m2.merchantRating*3+m2.productPrice*4+m2.merchantTotalProducts*1+m2.productSold*2+m2.productRating*4)/15;
        return b-a;
    }
}

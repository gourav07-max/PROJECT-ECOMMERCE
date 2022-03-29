package com.example.Product.fiegn;


import com.example.Product.dto.MerchantProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value="fiegnDemo",url="http://localhost:8091")
public interface MerchantInterface {


    @GetMapping ("/merchant/deleteproduct")
    public List<Integer> deleteProduct();

    @PostMapping("/merchant/add1")
    public void add(@RequestBody MerchantProduct merchantProduct);

}
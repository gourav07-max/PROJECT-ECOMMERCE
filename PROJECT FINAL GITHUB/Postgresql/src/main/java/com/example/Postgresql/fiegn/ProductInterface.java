package com.example.Postgresql.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

    @FeignClient(value="fiegnDemo",url="http://localhost:8080/")
    public interface ProductInterface {


//        @RequestMapping(method = RequestMethod.GET,value ="/path" )
// @PostMapping("/product")
//        public void add();
//
//    }
    }



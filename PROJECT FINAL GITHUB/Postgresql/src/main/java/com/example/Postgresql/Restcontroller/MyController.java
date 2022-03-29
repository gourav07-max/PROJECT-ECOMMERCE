package com.example.Postgresql.Restcontroller;

import com.example.Postgresql.dto.Merchant;
import com.example.Postgresql.dto.MerchantProduct;
import com.example.Postgresql.response.Response;
import com.example.Postgresql.service.MerchantProductService;
import com.example.Postgresql.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/merchant")
@Valid
public class MyController {

    @Autowired
     MerchantProductService merchantProductService;

//    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping(path="/add1" ,produces = "application/json")
    public void add1(@RequestBody @Valid MerchantProduct merchantProduct){
        merchantProductService.add(merchantProduct);

    }

    @PutMapping(path="/put1" ,produces = "applicatin/json")
    public void put1(@RequestParam @Valid Integer stock, Integer mId){
        merchantProductService.update(stock,mId);
    }

    @DeleteMapping(path="/delete1" ,produces = "application/json")
    public void delete1(@RequestBody @Valid Integer id){
        merchantProductService.delete(id);
    }


    @GetMapping(path="/deleteproduct" ,produces = "application/json")
    public List<Integer> delete1(){
        return merchantProductService.deleteproduct();
    }


    @GetMapping(path="/checkstock" ,produces = "application/json")
    public boolean checkStock(@RequestParam @Valid int mid,@RequestParam int pid){
         return merchantProductService.checkStock(mid,pid);
    }


    @PostMapping(path="/stockupdate" ,produces = "application/json")
    public void stockUpdate(@RequestParam @Valid int mid,@RequestParam int pid,@RequestParam int quantity){
        merchantProductService.stockUpdate(mid,pid,quantity);

    }


}

















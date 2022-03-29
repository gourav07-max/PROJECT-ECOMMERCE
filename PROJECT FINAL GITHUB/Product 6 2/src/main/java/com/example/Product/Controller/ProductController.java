package com.example.Product.Controller;


import com.example.Product.Entity.ProductEntity;
import com.example.Product.Response.ResponseEntity;
import com.example.Product.Services.ProductService;
import com.example.Product.dto.MerchantProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@Valid
public class ProductController {


    @Autowired
    ProductService productService;


  @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/products")
    public ResponseEntity<List<MerchantProduct>> getAllProducts(){

        List<MerchantProduct> productList =  productService.getAll();
        if(productList!=null){
            return new ResponseEntity<>(productList);
        }else{
            return new ResponseEntity<>(2001 , "No products");
        }

    }



    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/productbycategory")
    ResponseEntity<List<MerchantProduct>> getCategories(@RequestParam(required = true) String category){

        List<MerchantProduct> categoryList= productService.getByCategory(category);
        if(categoryList!=null){
            return new ResponseEntity<>(categoryList);
        }
        else {
            return new ResponseEntity<>(2002,"No products under this category");
        }
    }

    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/byId")
    public ProductEntity getProductById(@RequestParam(required = true) Integer id){
        return productService.getProductById(id);
    }

    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping(produces = "application/json")
    public void add(@RequestBody @Valid MerchantProduct product){
        productService.adds(product);

    }



    @CrossOrigin(origins = "http://localhost:8080/")
    @DeleteMapping(produces = "application/json")
    public void delete(Integer id){
        productService.delete(id);
    }




}

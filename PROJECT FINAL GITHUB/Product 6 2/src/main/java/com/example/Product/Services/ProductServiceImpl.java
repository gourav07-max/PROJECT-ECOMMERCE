package com.example.Product.Services;


import com.example.Product.Entity.ProductEntity;
import com.example.Product.Repository.ProductRepository;
import com.example.Product.dto.MerchantProduct;
import com.example.Product.dto.Product;
import com.example.Product.fiegn.MerchantInterface;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService  {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    MerchantInterface merchantInterface;


    List<ProductEntity> productEntityList=new ArrayList<>();




    public List<MerchantProduct> getAll() {
        Iterable<ProductEntity> productEntities=productRepository.findAll();
        List<MerchantProduct> productList=new ArrayList<>();
        for(ProductEntity productEntity:productEntities){
            MerchantProduct product=new MerchantProduct(productEntity.getMerchantid(),productEntity.getProductid(),productEntity.getPrice(),productEntity.getStock(),productEntity.getName(),productEntity.getDescription(),productEntity.getCategory(),productEntity.getMerchantname(),productEntity.getImgurl(),productEntity.getAlgovalue());
            productList.add(product);

            }

            if(productList.size()!=0){
                return productList;

        }

        else {
            return null;
            }

    }




    public List<MerchantProduct> getByCategory(String category) {

        List<MerchantProduct> merchantProductList= productRepository.findBycategory(category);

        if(merchantProductList.size()!=0){
            return merchantProductList;
        }
        else{
            return null;
        }

    }



    public void delete(Integer id){

        productRepository.deleteByproductid(id);


      List<Integer> name =merchantInterface.deleteProduct();
      for(Integer i:name){
          productRepository.deleteByproductid(i);
      }


   }



    public void adds(MerchantProduct product) {

        List<ProductEntity> productList =productRepository.findByname(product.getName());
        ProductEntity productEntity=new ProductEntity();
        if(productList.size()==0) {
            productEntity.setProductid(product.getProductid());
            productEntity.setName(product.getName());
            productEntity.setDescription(product.getDescription());
            productEntity.setImgurl(product.getImgurl());
            productEntity.setMerchantid(product.getMerchantid());
            productEntity.setMerchantname(product.getMerchantname());
            productEntity.setCategory(product.getCategory());
            productEntity.setPrice(product.getPrice());
            productEntity.setStock(product.getStock());
            productEntity.setAlgovalue(product.getAlgovalue());
            productRepository.save(productEntity);



            MerchantProduct merchantProduct=new MerchantProduct(product.getMerchantid(),product.getProductid(),product.getPrice(),product.getStock(),product.getName(),product.getDescription(),product.getCategory(),product.getMerchantname(),product.getImgurl(),product.getAlgovalue());
            merchantInterface.add(merchantProduct);
        }

        else if(productList.size()!=0){

            for(ProductEntity i:productList){
                Integer algo=i.getAlgovalue();

                productRepository.deleteByproductid(i.getProductid());
                System.out.println();
                if(algo<product.getAlgovalue()){

                    productEntity.setProductid(product.getProductid());
                    productEntity.setName(product.getName());
                    productEntity.setDescription(product.getDescription());
                    productEntity.setImgurl(product.getImgurl());
                    productEntity.setMerchantid(product.getMerchantid());
                    productEntity.setMerchantname(product.getMerchantname());
                    productEntity.setCategory(product.getCategory());
                    productEntity.setPrice(product.getPrice());
                    productEntity.setStock(product.getStock());
                    productEntity.setAlgovalue(product.getAlgovalue());
                    productRepository.save(productEntity);





                    MerchantProduct merchantProduct=new MerchantProduct(product.getMerchantid(),product.getProductid(),product.getPrice(),product.getStock(),product.getName(),product.getDescription(),product.getCategory(),product.getMerchantname(),product.getImgurl(),product.getAlgovalue());
                    merchantInterface.add(merchantProduct);
                }

                else{

                    MerchantProduct merchantProduct=new MerchantProduct(product.getMerchantid(),product.getProductid(),product.getPrice(),product.getStock(),product.getName(),product.getDescription(),product.getCategory(),product.getMerchantname(),product.getImgurl(),product.getAlgovalue());
                    merchantInterface.add(merchantProduct);
                }

            }
        }





    }





    @Override
    public ProductEntity getProductById(Integer id)
    {
        try {
            return productRepository.findByproductid(id);
        }
        catch (Exception e){
            System.out.println("Id not present");
            return null;
        }
    }




}

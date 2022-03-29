package com.example.Postgresql.service;


import com.example.Postgresql.dto.MerchantProduct;
import com.example.Postgresql.entity.MerchantEntity;
import com.example.Postgresql.entity.MerchantProductEntity;
import com.example.Postgresql.fiegn.ProductInterface;
import com.example.Postgresql.repository.MerchantProductRepository;
import com.example.Postgresql.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MerchantProductServiceimp implements MerchantProductService{

    @Autowired
    MerchantProductRepository merchantProductRepository;

    @Autowired
    ProductInterface productInterface;

    @Autowired
    MerchantRepository merchantRepository;



    public void add(MerchantProduct merchantProduct){

         MerchantProductEntity merchantProductEntity=new MerchantProductEntity();
         if(merchantProduct.getMerchantid()==null){
             return;
         }
        Optional<MerchantEntity> byId=merchantRepository.findById(merchantProduct.getMerchantid());
        if(byId.isPresent()){
            merchantProductEntity.setMerchantEntity(byId.get());
            merchantProductEntity.setStock(merchantProduct.getStock());
            merchantProductEntity.setPrice(merchantProduct.getPrice());
            merchantProductEntity.setSoldproducts(merchantProduct.getSoldProducts());
            merchantProductEntity.setProductid(merchantProduct.getProductid());
            merchantProductEntity.setPrice(merchantProduct.getPrice());
            merchantProductEntity.setDescription(merchantProduct.getDescription());
            merchantProductEntity.setImgurl(merchantProduct.getImgurl());
            merchantProductEntity.setCategory(merchantProduct.getCategory());
            merchantProductEntity.setRating(merchantProduct.getRating());
            merchantProductEntity.setAlgovalue(merchantProduct.getAlgovalue());
            merchantProductEntity.setMerchantname(merchantProduct.getMerchantname());
            merchantProductEntity.setName(merchantProduct.getName());
            merchantProductRepository.save(merchantProductEntity);


        }

//        merchantProductRepository.save(merchantProductEntity);

        //productId from product table(other database)
    }
    @Override
    public void update(Integer stock, Integer mId) {

        for(MerchantProductEntity merchantProductEntity:merchantProductRepository.findAll()){

            //feign implementation

        }

    }

    public void delete(Integer id){
        for(MerchantProductEntity merchantProductEntity:merchantProductRepository.findAll()){
            //feign
            //if stock =0

        }
    }

    public List<Integer> deleteproduct(){
        Iterable<MerchantProductEntity> merchantProductEntities=merchantProductRepository.findAll();
        List<Integer> merchantProducts=new ArrayList<>();

        for(MerchantProductEntity merchantProductEntity:merchantProductEntities){
            Integer stock= merchantProductEntity.getStock();
            if(stock==0){
                MerchantProduct merchantProduct=new MerchantProduct(merchantProductEntity.getId(),merchantProductEntity.getProductid(),merchantProductEntity.getPrice(),merchantProductEntity.getStock(),merchantProductEntity.getSoldproducts(),merchantProductEntity.getName(),merchantProductEntity.getMerchantname(),merchantProductEntity.getDescription(),merchantProductEntity.getImgurl(),merchantProductEntity.getCategory(),merchantProductEntity.getRating(),merchantProductEntity.getAlgovalue());
                Integer productId=merchantProduct.getProductid();
                merchantProducts.add(productId);
            }
        }

         return merchantProducts;
     }
     // for cart stock update while buying
     public void stockUpdate(Integer mid,Integer pid,Integer quantity){
         Iterable<MerchantProductEntity> merchantProductEntities=merchantProductRepository.findAll();

         for(MerchantProductEntity merchantProductEntity:merchantProductEntities){
             if(merchantProductEntity!=null&&merchantProductEntity.getStock()!=null&&merchantProductEntity.getProductid()==pid&&merchantProductEntity.getMerchantEntity().getId()==mid){
//                 System.out.println(merchantProductEntity.getStock());
                 if(merchantProductEntity.getStock()-quantity<=0){
                  // throw some exception
                 }
                 else {
                     merchantProductEntity.setStock(merchantProductEntity.getStock() - quantity);
                     merchantProductEntity.setSoldproducts(merchantProductEntity.getSoldproducts()==null?quantity:merchantProductEntity.getSoldproducts()+quantity);
                     merchantProductRepository.save(merchantProductEntity);
                 }
             }
         }
     }

     // check stock
     public boolean checkStock(Integer mid , Integer pid){
         Iterable<MerchantProductEntity> merchantProductEntities=merchantProductRepository.findAll();

         for(MerchantProductEntity merchantProductEntity:merchantProductEntities){
             if(merchantProductEntity.getProductid()==pid&&merchantProductEntity.getMerchantEntity().getId()==mid){
                 if(merchantProductEntity!=null&&merchantProductEntity.getStock()>0){
                     return true;
                 }
                 else {
                     return false;
                 }
             }
         }
         return false;
     }


}

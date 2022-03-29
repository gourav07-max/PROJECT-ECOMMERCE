package com.example.Postgresql.Restcontroller;

import com.example.Postgresql.entity.CartEntity;
import com.example.Postgresql.entity.ProductRatingEntity;
import com.example.Postgresql.entity.UserHistoryEntity;
import com.example.Postgresql.repository.RatingRepository;
import com.example.Postgresql.service.CartService;
import com.example.Postgresql.service.RatingService;
import com.example.Postgresql.service.UserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
public class MyController {

    @Autowired
    CartService cartService;
    //
    @Autowired
    RatingService ratingService;

    @Autowired
    UserHistoryService userHistoryService;

    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping(path = "/cart")
    public List<CartEntity> getCartProduct(@RequestParam @Valid Integer userId) {
        return cartService.getAllCartProducts(userId);
    }


    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping(path = "/add", produces = "application/json")
    public void addToCart(@RequestParam @Valid Integer mid, @RequestParam Integer pid, @RequestParam Integer userId) {
        cartService.addToCart(mid, pid, userId);
    }
//

    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping(path = "/remove", produces = "application/json")
    public void removeFromCart(@RequestParam @Valid int productId, @RequestParam int userId) {
        cartService.removeFromCart(productId, userId);
    }
//


    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping(path = "/buy", produces = "application/json")
    public void buyFromCart(@RequestParam @Validated int userId) {
        cartService.buyFromCart(userId);
    }


    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping(path = "/removeCart", produces = "application/json")
    public void removeCart(@RequestParam Integer userId) {
        cartService.removeAllCartProducts(userId);
    }

    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping(path = "/history", produces = "application/json")
    public List<UserHistoryEntity> showUserHistory(Integer userId) {
        return userHistoryService.showHistory(userId);
    }

    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping(path = "/addRating" ,produces= "application/json")
    public void updateRating(int productId, int productRating) {
        ratingService.updateRating(productId, productRating);
    }

    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping(path ="/getRating")
    public Optional<ProductRatingEntity> getRating(@RequestParam @Valid int productId){
        return ratingService.getRating(productId);
    }

}

















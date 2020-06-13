package com.example.wishlist.api;

import com.example.wishlist.model.ShoppingWishList;
import com.example.wishlist.service.ShoppingWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/wish")
@RestController
public class ShoppingWishListController {
    private final ShoppingWishListService shoppingWishListService;

    @Autowired
    public ShoppingWishListController(ShoppingWishListService shoppingWishListService) {
        this.shoppingWishListService = shoppingWishListService;
    }

    @PostMapping()
    public int addWish(@Validated @NonNull @RequestBody ShoppingWishList shoppingWishList) {
        return shoppingWishListService.addWish(shoppingWishList);
    }


    @GetMapping
    public List<ShoppingWishList> getAllWishes(){
        return shoppingWishListService.getAllWishes();
    }

    @GetMapping(path = "{id}")
    public Optional<ShoppingWishList> getWishById(@PathVariable("id") int id) {
        return shoppingWishListService.getWishById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteWishById(@PathVariable("id") int id) {
        shoppingWishListService.deleteWishById(id);
    }

    @PutMapping(path = "{id}")
    public void updateWishById(@PathVariable("id") int id,  @Validated @NonNull @RequestBody String shopNameToUpdate) {
        shoppingWishListService.updateWishByShopName(id, shopNameToUpdate);
    }
}

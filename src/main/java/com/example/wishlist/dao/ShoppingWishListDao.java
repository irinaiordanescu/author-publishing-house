package com.example.wishlist.dao;

import com.example.wishlist.model.ShoppingWishList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShoppingWishListDao {
    int insertWish(ShoppingWishList shoppingWishList); //post

    List<ShoppingWishList> selectAllWishes(); //get

    Optional<ShoppingWishList> selectWishById(int id); //get

    int deleteWishById(int id); //delete

    int updateWishByShopName(int id, String shopName); //put

}

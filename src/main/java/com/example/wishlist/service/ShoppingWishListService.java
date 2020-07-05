package com.example.wishlist.service;

import com.example.wishlist.dao.ShoppingWishListDao;
import com.example.wishlist.model.ShoppingWishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShoppingWishListService {
    private final ShoppingWishListDao shoppingWishListDao;

    @Autowired
    public ShoppingWishListService(@Qualifier("wishlist") ShoppingWishListDao shoppingWishListDao) {
        this.shoppingWishListDao = shoppingWishListDao;
    }

    public int addWish(ShoppingWishList shoppingWishList) {
        return shoppingWishListDao.insertWish(shoppingWishList);
    }


    public List<ShoppingWishList> getAllWishes() {
        return shoppingWishListDao.selectAllWishes();
    }

    public Optional<ShoppingWishList> getWishById(int id) {
        return shoppingWishListDao.selectWishById(id);
    }

    public int deleteWishById(int id) {
        return shoppingWishListDao.deleteWishById(id);
    }

    public int updateWishByShopName(int id, String newShopName) {
        return shoppingWishListDao.updateWishByShopName(id, newShopName);
    }

}

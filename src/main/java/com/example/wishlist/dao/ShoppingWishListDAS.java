package com.example.wishlist.dao;

import com.example.wishlist.HibernateUtil;
import com.example.wishlist.model.ShoppingWishList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("wishlist")
public class ShoppingWishListDAS implements ShoppingWishListDao {
    @Override
    public int insertWish(ShoppingWishList shoppingWishList) { //post
        Transaction transaction = null;
        System.out.println("aici");
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(shoppingWishList);
            transaction.commit();
            return shoppingWishList.hashCode();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public List<ShoppingWishList> selectAllWishes() { //get
        List<ShoppingWishList> wishes = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            wishes = session.createQuery("from ShoppingWishList", ShoppingWishList.class).getResultList();
            return wishes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<ShoppingWishList> selectWishById(int id) {
        Optional<ShoppingWishList> wish = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            wish = session.createQuery("from ShoppingWishList where id = :i", ShoppingWishList.class).setParameter("i", id).uniqueResultOptional();
            return wish;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int deleteWishById(int id) {
        ShoppingWishList deleteOneWish = new ShoppingWishList();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            deleteOneWish = this.selectWishById(id).get();
            session.delete(deleteOneWish);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateWishByShopName(int id, String shopName) {
        ShoppingWishList newShopName = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            newShopName = this.selectWishById(id).get();
            newShopName.setShopName(shopName);
            session.update(newShopName);
            transaction.commit();
        } catch (Error e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

}

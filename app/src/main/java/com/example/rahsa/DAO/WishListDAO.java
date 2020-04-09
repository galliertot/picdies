package com.example.rahsa.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rahsa.entities.Clothes;
import com.example.rahsa.entities.User;
import com.example.rahsa.entities.WishList;

import java.util.List;

@Dao
public interface WishListDAO {

    @Insert
    long insertWishlist(WishList wishList);
    @Update
    void updateWishlist(WishList wishList);
    @Delete
    void deleteWishlist(WishList Wishlist);

    @Query("SELECT * FROM Wishlist WHERE _id=:id")
    List<WishList> getWishlist(int id);

    @Query("SELECT * FROM Wishlist WHERE user=:user")
    List<WishList> getWishlistFromUser(int user);


}
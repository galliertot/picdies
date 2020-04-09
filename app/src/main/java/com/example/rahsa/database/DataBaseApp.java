package com.example.rahsa.database;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.rahsa.DAO.*;
import com.example.rahsa.entities.*;

@Database(entities = {User.class, Clothes.class, WishList.class, Swap.class}, version = 5)
public abstract class DataBaseApp extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract ClothesDAO clothesDAO();
    public abstract WishListDAO wishListDAO();
    public abstract SwapDAO swapDAO();


    private static DataBaseApp instance = null;
    public static DataBaseApp getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, DataBaseApp.class, "database.sqlite")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        return instance;
    }
}
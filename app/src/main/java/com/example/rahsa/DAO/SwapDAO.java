package com.example.rahsa.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rahsa.entities.Clothes;
import com.example.rahsa.entities.Swap;

import java.util.List;

@Dao
public interface SwapDAO {

    @Insert
    long insertSwap(Swap swap);
    @Update
    void updateSwap(Swap swap);
    @Delete
    void deleteSwap(Swap swap);

    @Query("SELECT * FROM Swap WHERE _id=:id")
    Swap getSwap(int id);

    @Query("SELECT clothes FROM Swap WHERE user=:user and swap=:swap")
    List<Integer> getClothesFromUserAndSwap(int user, int swap);  //0 : close / 1 : check


}
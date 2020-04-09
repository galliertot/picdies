package com.example.rahsa.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rahsa.entities.Clothes;

import java.util.List;

@Dao
public interface ClothesDAO {

    @Insert
    long insertClothes(Clothes clothes);
    @Update
    void updateClothes(Clothes clothes);
    @Delete
    void deleteClothes(Clothes clothes);

    @Query("SELECT * FROM Clothes WHERE _id=:id")
    Clothes getClothes(int id);

    @Query("SELECT * FROM Clothes")
    List<Clothes> getAllClothes();

    @Query("SELECT * FROM Clothes WHERE nom=:nom")
    Clothes getClothesFromNom(String nom);

    @Query("SELECT * FROM Clothes WHERE categorie=:categorie")
    List<Clothes> getClothesFromCategorie(String categorie);

    @Query("SELECT * FROM Clothes WHERE genre=:genre")
    List<Clothes> getClothesFromGenre(String genre);

    @Query("SELECT * FROM Clothes WHERE _id not in (SELECT clothes from swap where user=:user)")
    List<Clothes> getClothesNotSwap(int user);
}
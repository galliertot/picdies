package com.example.rahsa.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rahsa.entities.Categorie;
import com.example.rahsa.entities.User;

import java.util.List;

@Dao
public interface CategorieDAO {

    @Insert
    long insertCategorie(Categorie categorie);
    @Update
    void updateCategorie(Categorie categorie);
    @Delete
    void deleteCategorie(Categorie categorie);

    @Query("SELECT * FROM Categorie WHERE _id=:id")
    Categorie getCategorie(int id);

    @Query("SELECT * FROM Categorie")
    List<Categorie> getAllCategorie();

    @Query("SELECT * FROM Categorie WHERE nom=:nom")
    Categorie getCategorieFromNom(String nom);
}
package com.example.rahsa.entities;

import android.graphics.Bitmap;
import android.media.Image;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Clothes")
public class Clothes {

    @ColumnInfo(name="nom")
    private String nom;

    @ColumnInfo(name = "prix")
    private int prix;

    @ColumnInfo(name = "photo")
    private String photo;

    @ColumnInfo(name = "categorie")
    private int categorie;

    @ColumnInfo(name = "link")
    private String link;

    @ColumnInfo(name = "genre")
    private String genre;

    @ColumnInfo(name="_id")
    @PrimaryKey(autoGenerate = true)
    public long _id;

    public Clothes(String nom, int prix, String photo, int categorie, String link, String genre) {
        this.nom = nom;
        this.prix = prix;
        this.photo = photo;
        this.categorie = categorie;
        this.link = link;
        this.genre = genre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


}

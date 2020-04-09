package com.example.rahsa.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {

    @ColumnInfo(name="pseudo")
    private String pseudo;

    @ColumnInfo(name="email")
    private String email;

    @ColumnInfo(name="password")
    private String password;

    @ColumnInfo(name="genre")
    private String genre;

    @ColumnInfo(name="wishlist")
    private int wishlist;

    @ColumnInfo(name="_id")
    @PrimaryKey(autoGenerate = true)
    public long _id;


    public User(String pseudo, String email, String password, String genre) {
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.genre = genre;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getWishlist() {
        return wishlist;
    }

    public void setWishlist(int wishlist) {
        this.wishlist = wishlist;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }
}

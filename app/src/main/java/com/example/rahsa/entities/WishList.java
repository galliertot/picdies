package com.example.rahsa.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "WishList")
public class WishList {

    public WishList(int clothes, int user) {
        this.clothes = clothes;
        this.user = user;
    }

    public Integer getClothes() {
        return clothes;
    }

    public void setClothes(Integer clothes) {
        this.clothes = clothes;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    @ColumnInfo(name = "clothes")
    private int clothes;

    @ColumnInfo(name = "user")
    private int user;

    @ColumnInfo(name="_id")
    @PrimaryKey(autoGenerate = true)
    public long _id;





}

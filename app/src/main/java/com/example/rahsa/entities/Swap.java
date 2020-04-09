package com.example.rahsa.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Swap")
public class Swap {

    @ColumnInfo(name="clothes")
    private int clothes;

    @ColumnInfo(name = "user")
    private int user;

    @ColumnInfo(name = "swap") // 0 : close / 1 : check
    private int swap;

    @ColumnInfo(name="_id")
    @PrimaryKey(autoGenerate = true)
    public long _id;

    public Swap(int clothes, int user, int swap) {
        this.clothes = clothes;
        this.user = user;
        this.swap = swap;
    }

    public int getClothes() {
        return clothes;
    }

    public void setClothes(int clothes) {
        this.clothes = clothes;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getSwap() {
        return swap;
    }

    public void setSwap(int swap) {
        this.swap = swap;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }
}

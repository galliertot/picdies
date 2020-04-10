package com.example.rahsa.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Categorie")
public class Categorie {

    @ColumnInfo(name="nom")
    private String nom;

    @ColumnInfo(name="_id")
    @PrimaryKey(autoGenerate = true)
    public long _id;

    private Boolean filter_on;

    public Boolean getFilter_on() {
        return filter_on;
    }

    public void setFilter_on(Boolean filter_on) {
        this.filter_on = filter_on;
    }

    public Categorie(String nom) {
        this.nom = nom;
        this.filter_on = false;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }
}

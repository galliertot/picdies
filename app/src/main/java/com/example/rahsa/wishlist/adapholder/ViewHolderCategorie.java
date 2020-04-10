package com.example.rahsa.wishlist.adapholder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahsa.GlobalVariable;
import com.example.rahsa.R;
import com.example.rahsa.database.DataBaseApp;
import com.example.rahsa.entities.Categorie;
import com.example.rahsa.entities.Clothes;
import com.example.rahsa.entities.WishList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ViewHolderCategorie extends RecyclerView.ViewHolder implements View.OnClickListener, AdaptateurWishlist.OnRecyclerListenner{
    public Button button;
    public AdaptateurCategorie.OnRecyclerListenner recyclerListener;
    private DataBaseApp db;


    public ViewHolderCategorie(View v, AdaptateurCategorie.OnRecyclerListenner recyclerListenner)
    {
        super(v);
        db = DataBaseApp.getInstance(v.getContext());
        button = v.findViewById(R.id.btnCategorie);
        this.recyclerListener = recyclerListenner;
        v.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void updateCategorie(final Categorie categorie, Context context)
    {
        this.button.setText(categorie.getNom());
        this.button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("categorie", categorie.getNom());
                Navigation.findNavController(v).navigate(R.id.wishlist_to_filterwishlist, bundle);
            }
        } );

        if(categorie.getFilter_on())
        {
            this.button.setBackground(ContextCompat.getDrawable(context, R.drawable.border_button_wishlist_actif));
            this.button.setTextColor(Color.WHITE);
        }

    }

    @Override
    public void onClick(View v) {
        recyclerListener.onRecyclerClick(getAdapterPosition());
    }

    @Override
    public void onRecyclerClick(int position) {

    }
}
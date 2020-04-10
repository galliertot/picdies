package com.example.rahsa.wishlist.adapholder;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahsa.R;
import com.example.rahsa.database.DataBaseApp;
import com.example.rahsa.entities.Categorie;
import com.example.rahsa.entities.Clothes;
import com.example.rahsa.entities.WishList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;



public class ViewHolderWishlist extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView photo;
    public TextView likeClothes;
    public TextView link;
    public FloatingActionButton shareButton;
    public AdaptateurWishlist.OnRecyclerListenner recyclerListener;
    private DataBaseApp db;


    public ViewHolderWishlist(View v, AdaptateurWishlist.OnRecyclerListenner recyclerListenner)
    {
        super(v);
        db = DataBaseApp.getInstance(v.getContext());
        photo = (ImageView) v.findViewById(R.id.photo);
        likeClothes = v.findViewById(R.id.clothesLike);
        link = (TextView) v.findViewById(R.id.link);
        shareButton = (FloatingActionButton) v.findViewById(R.id.shareButton);
        this.recyclerListener = recyclerListenner;
        v.setOnClickListener(this);
    }

    public void updateWishlist(WishList wishList)
    {

        final Clothes clothes = db.clothesDAO().getClothes(wishList.getClothes());

            Picasso.get().load(clothes.getPhoto()).into(photo);
            this.link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse(clothes.getLink()));
                    v.getContext().startActivity(browse);
                }
            } );

            this.shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    shareAction(v, clothes);
                }
            } );
            likeClothes.setText(" Aimé par " + db.wishListDAO().getLikeClothes((int)clothes.get_id()).toString() + " personnes");
            likeClothes.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_favorite_black_24dp, 0, 0, 0 );
    }

    @Override
    public void onClick(View v) {
        recyclerListener.onRecyclerClick(getAdapterPosition());
    }

    public void shareAction(View v, Clothes clothes)
    {
        Intent shareIntent = new Intent();
        shareIntent.setAction( Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, clothes.getLink());
        v.getContext().startActivity(Intent.createChooser(shareIntent, "Partager le vêtement"));
    }
}
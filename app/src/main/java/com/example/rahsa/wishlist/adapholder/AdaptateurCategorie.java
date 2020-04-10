package com.example.rahsa.wishlist.adapholder;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahsa.R;
import com.example.rahsa.entities.Categorie;
import com.example.rahsa.entities.WishList;

import java.util.List;

//import static model.bar.ViewHolderWishlist.makeSelectedItem;
//import static model.bar.ViewHolderWishlist.makeUnselectedItem;


public class AdaptateurCategorie extends RecyclerView.Adapter<ViewHolderCategorie> {
    // FOR DATA
    private List<Categorie> listCategorie;
    private OnRecyclerListenner recyclerListenner;
    // CONSTRUCTOR
    public AdaptateurCategorie(List<Categorie> listCategorieAdd, OnRecyclerListenner recyclerListenner) {
        this.listCategorie = listCategorieAdd;
        this.recyclerListenner = recyclerListenner;
    }
    @Override
    public ViewHolderCategorie onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list_categorie, parent, false);
        return new ViewHolderCategorie(view, recyclerListenner);
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolderCategorie viewHolder, int position) {
        viewHolder.updateCategorie(this.listCategorie.get(position), viewHolder.itemView.getContext());
    }
    // RETURN THE TOTAL COUNT OF ITEMS IN THE LIST
    @Override
    public int getItemCount() {
        return this.listCategorie.size();
    }
    public interface  OnRecyclerListenner{
        void onRecyclerClick(int position);
    }
}
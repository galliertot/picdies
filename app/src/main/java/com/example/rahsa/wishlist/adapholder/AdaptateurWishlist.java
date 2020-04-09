package com.example.rahsa.wishlist.adapholder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahsa.R;
import com.example.rahsa.entities.WishList;

import java.util.List;

//import static model.bar.ViewHolderWishlist.makeSelectedItem;
//import static model.bar.ViewHolderWishlist.makeUnselectedItem;


public class AdaptateurWishlist extends RecyclerView.Adapter<ViewHolderWishlist> {
    // FOR DATA
    private List<WishList> listWishlist;
    private OnRecyclerListenner recyclerListenner;
    // CONSTRUCTOR
    public AdaptateurWishlist(List<WishList> listWishlistAdd, OnRecyclerListenner recyclerListenner) {
        this.listWishlist = listWishlistAdd;
        this.recyclerListenner = recyclerListenner;
    }
    @Override
    public ViewHolderWishlist onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list_wishlist, parent, false);
        return new ViewHolderWishlist(view, recyclerListenner);
    }
    @Override
    public void onBindViewHolder(ViewHolderWishlist viewHolder, int position) {
        viewHolder.updateWishlist(this.listWishlist.get(position));
    }
    // RETURN THE TOTAL COUNT OF ITEMS IN THE LIST
    @Override
    public int getItemCount() {
        return this.listWishlist.size();
    }
    public interface  OnRecyclerListenner{
        void onRecyclerClick(int position );
    }
}
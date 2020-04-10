package com.example.rahsa.wishlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahsa.GlobalVariable;
import com.example.rahsa.R;
import com.example.rahsa.entities.Categorie;
import com.example.rahsa.wishlist.adapholder.AdaptateurCategorie;
import com.example.rahsa.wishlist.adapholder.AdaptateurWishlist;
import com.example.rahsa.database.DataBaseApp;
import com.example.rahsa.entities.WishList;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class WishlistFragment extends Fragment implements AdaptateurWishlist.OnRecyclerListenner, AdaptateurCategorie.OnRecyclerListenner{

    private DataBaseApp db;
    private RecyclerView mRecyclerView;
    private AdaptateurWishlist monAdapterWishlist;
    private List<WishList> wishListArrayList;
    private AdaptateurCategorie monAdapterCategorie;
    private List<Categorie> categorieArrayList;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_wishlist, container, false);

        GlobalVariable sharedData = GlobalVariable.getInstance();
        db = DataBaseApp.getInstance(root.getContext());
        mRecyclerView=(RecyclerView)root.findViewById(R.id.recycler_view_wishlist);
        wishListArrayList = new ArrayList<WishList>();
        if(getArguments() != null)
            wishListArrayList.addAll(db.wishListDAO().getWishlistFromCategorieAndFromUser((int)db.categorieDAO().getCategorieFromNom(getArguments().getString("categorie")).get_id(),(int)sharedData.getUserConnected().get_id()));
        else
            wishListArrayList.addAll(db.wishListDAO().getWishlistFromUser((int)sharedData.getUserConnected().get_id()));

        if(wishListArrayList.isEmpty() && getArguments() == null)
        {
            NavHostFragment.findNavController(this).navigate(R.id.wishlist_to_home);
        }
        monAdapterWishlist = new AdaptateurWishlist(wishListArrayList,this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(monAdapterWishlist);

        mRecyclerView=(RecyclerView)root.findViewById(R.id.recycler_view_categorie);
        categorieArrayList = new ArrayList<Categorie>();
        categorieArrayList.addAll(db.categorieDAO().getAllCategorie());
        if(getArguments() != null)
        {
            for (Categorie categorie: categorieArrayList
                 ) {
                if(categorie.getNom().equals(getArguments().getString("categorie")))
                    categorie.setFilter_on(true);
            }
        }
        monAdapterCategorie = new AdaptateurCategorie(categorieArrayList,this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setAdapter(monAdapterCategorie);



        return root;
    }

    @Override
    public void onRecyclerClick(int position) {
        //
    }
}
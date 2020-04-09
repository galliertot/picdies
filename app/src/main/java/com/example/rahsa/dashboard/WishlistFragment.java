package com.example.rahsa.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahsa.GlobalVariable;
import com.example.rahsa.R;
import com.example.rahsa.adapholder.AdaptateurWishlist;
import com.example.rahsa.database.DataBaseApp;
import com.example.rahsa.entities.WishList;

import java.util.ArrayList;
import java.util.List;

public class WishlistFragment extends Fragment implements AdaptateurWishlist.OnRecyclerListenner{

    private DataBaseApp db;
    private RecyclerView mRecyclerView;
    private AdaptateurWishlist monAdapter;
    private List<WishList> wishListArrayList;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_wishlist, container, false);

        GlobalVariable sharedData = GlobalVariable.getInstance();

        db = DataBaseApp.getInstance(root.getContext());
        mRecyclerView=(RecyclerView)root.findViewById(R.id.recycler_view_wishlist);
        wishListArrayList = new ArrayList<WishList>();
        wishListArrayList.addAll(db.wishListDAO().getWishlistFromUser((int)sharedData.getUserConnected().get_id()));
        monAdapter = new AdaptateurWishlist(wishListArrayList,this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(monAdapter);



        return root;
    }

    @Override
    public void onRecyclerClick(int position) {
        //
    }
}
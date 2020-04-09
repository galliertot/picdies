package com.example.rahsa.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.rahsa.GlobalVariable;
import com.example.rahsa.R;
import com.example.rahsa.database.DataBaseApp;
import com.example.rahsa.entities.Clothes;
import com.example.rahsa.entities.Swap;
import com.example.rahsa.entities.WishList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FloatingActionButton checkButton;
    private FloatingActionButton closeButton;
    private ImageView photo;

    private GlobalVariable sharedData = GlobalVariable.getInstance();
    private ArrayList<Clothes> clothesArrayList;
    private DataBaseApp db;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        if(sharedData.userConnected == null)
        {
            NavHostFragment.findNavController(this).navigate(R.id.home_to_connexion);
        }
        else
        {
            //declare db
            db = DataBaseApp.getInstance(root.getContext());

            //findViewById
            checkButton = (FloatingActionButton) root.findViewById(R.id.checkButton);
            closeButton = (FloatingActionButton) root.findViewById(R.id.closeButton) ;
            photo = (ImageView) root.findViewById(R.id.photoViewHome);

            //variable declare
            if(db.clothesDAO().getAllClothes().isEmpty())
            {
                db.clothesDAO().insertClothes(new Clothes("yeezy", 50, "https://cdn.shopify.com/s/files/1/2358/2817/products/Wethenew-Sneakers-France-Adidas-Yeezy-500-Stone-FW4839-2_2000x.png?v=1574090233", "chaussure", "https://wethenew.com/","homme"));
                db.clothesDAO().insertClothes(new Clothes("nike", 20, "https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/b3159d56-6d36-4275-b9c7-cb5f46276ece/chaussure-react-element-55-pour-t5fGqP.jpg", "chaussure", "https://www.nike.com/fr/t/chaussure-react-element-55-pour-t5fGqP/CU3009-101?cp=30566810280_search_%7c%7c1596765111%7c62975562160%7c%7cc%7cFR%7ccsscore%7c302633876118&ds_rl=1252249&gclid=CjwKCAjw7LX0BRBiEiwA__gNw1ErhNo6uvkVNKkjfDQV1q-Rr1Lvm8JudDNcP0VLCzlPoKFYD5fYfRoCHTcQAvD_BwE&gclsrc=aw.ds","homme"));
                db.clothesDAO().insertClothes(new Clothes("puma", 40, "https://i8.amplience.net/i/jpl/jd_336935_a?qlt=92&w=750&h=531&v=1&fmt=webp", "chaussure", "https://www.jdsports.fr/product/gris-puma-rs-x3-homme/336935_jdsportsfr/?istCompanyId=3d9b9ae8-6cf1-4208-bfe5-68522810a8b0&istFeedId=c0f5bfce-8c9b-4f27-b84d-1eee0f771ccd&istItemId=iiiiitaip&istBid=tzwm&gclid=CjwKCAjw7LX0BRBiEiwA__gNw61UZjPnvnjpkKQz79xQNwdj-CT9au4kTsXgFfjVtWCyuLHjnXcxIxoCZCMQAvD_BwE&gclsrc=aw.ds","homme"));
                db.clothesDAO().insertClothes(new Clothes("fila", 30, "https://i8.amplience.net/i/jpl/jd_356030_a?qlt=92&w=750&h=531&v=1&fmt=webp", "chaussure", "https://www.jdsports.fr/product/blanc-fila-provenance-homme/356030_jdsportsfr/?istCompanyId=3d9b9ae8-6cf1-4208-bfe5-68522810a8b0&istFeedId=c0f5bfce-8c9b-4f27-b84d-1eee0f771ccd&istItemId=iitmriplx&istBid=tzwm&gclid=CjwKCAjw7LX0BRBiEiwA__gNw0gg6SoZQUKQe1y9m2YDBDOpGgy86NK72E4V2faDhhO3blQ1ezIBIhoCMhMQAvD_BwE&gclsrc=aw.ds","homme"));
                db.clothesDAO().insertClothes(new Clothes("nike", 60, "https://c.static-nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/jioiotfls7pg0h3cvii9/chaussure-zoom-2k-pour-lqkfbZ.jpg", "chaussure", "https://www.nike.com/fr/t/chaussure-zoom-2k-pour-lqkfbZ/AO0269-101?cp=30566810280_search_%7c%7c1596765114%7c62975565040%7c%7cc%7cFR%7ccssgeneric%7c302672248273&ds_rl=1252249&gclid=CjwKCAjw7LX0BRBiEiwA__gNw_qVhef08TsCQ7UYG_eQ3J-9Ba1_UNKKe_XKSwviAUgRiIcMiMcIfBoCCn0QAvD_BwE&gclsrc=aw.ds","homme"));

            }

            clothesArrayList = new ArrayList<>();

            //recupere clothes

            clothesArrayList.addAll(db.clothesDAO().getClothesNotSwap((int)sharedData.getUserConnected().get_id()));


            changClothes(0);
        }
        return root;
    }


    public void checkAction(int id)
    {
        db.wishListDAO().insertWishlist(new WishList((int) clothesArrayList.get(id).get_id(),(int)sharedData.getUserConnected().get_id() ));
        db.swapDAO().insertSwap(new Swap((int) clothesArrayList.get(id).get_id(), (int)sharedData.getUserConnected().get_id(), 1));
        changClothes(id+1);
    }

    public void closeAction(int id)
    {
        db.swapDAO().insertSwap(new Swap((int) clothesArrayList.get(id).get_id(), (int)sharedData.getUserConnected().get_id(), 0));
        changClothes(id+1);
    }

    public void changClothes(final int positionListe)
    {
        if(positionListe + 1 <= clothesArrayList.size() )
        {
            Picasso.get().load(clothesArrayList.get(positionListe).getPhoto()).into(photo);

            checkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAction(positionListe);
                }
            } );

            closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    closeAction(positionListe);
                }
            } );
        }
        else
        {
            photo.setImageResource(R.drawable.nothingmore);
            closeButton.setVisibility(View.GONE);
            checkButton.setVisibility(View.GONE);
        }


    }
}



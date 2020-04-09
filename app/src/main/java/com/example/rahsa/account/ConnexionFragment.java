package com.example.rahsa.account;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.rahsa.GlobalVariable;
import com.example.rahsa.R;
import com.example.rahsa.database.DataBaseApp;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ConnexionFragment extends Fragment {

    private DataBaseApp db;
    private EditText connexion_pseudo;
    private EditText connexion_password;
    private TextView toInscription;
    private Button btnConnexion;
    private GlobalVariable sharedData = GlobalVariable.getInstance();




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_connexion, container, false);
        //declare db
        db = DataBaseApp.getInstance(root.getContext());

        getActivity().findViewById(R.id.nav_view).setVisibility(View.GONE);
        connexion_pseudo = root.findViewById(R.id.connexion_pseudo);
        connexion_password = root.findViewById(R.id.connexion_password);

        btnConnexion = root.findViewById(R.id.btnConnexion);
        toInscription = root.findViewById(R.id.btnToInscription);


        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getConnexion();
            }
        });

        toInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.connexion_to_inscription);
            }
        });

        return root;
    }


    public void getConnexion()
    {

        if(!TextUtils.isEmpty(connexion_pseudo.getText()) && !TextUtils.isEmpty(connexion_password.getText()))
        {
            if(db.userDAO().getConnexion(connexion_pseudo.getText().toString(), connexion_password.getText().toString()) != null)
            {
                sharedData.setUserConnected(db.userDAO().getConnexion(connexion_pseudo.getText().toString(), connexion_password.getText().toString()));
                getActivity().findViewById(R.id.nav_view).setVisibility(View.VISIBLE);
                NavHostFragment.findNavController(this).navigate(R.id.connexion_to_home);
            }
            else
            {
                Snackbar.make(getView(), "Aucun compte trouvé !", Snackbar.LENGTH_SHORT).show();
            }
        }
        else
        {
            Snackbar.make(getView(), "Pseudo ou mot de passe vide !", Snackbar.LENGTH_SHORT).show();
        }
    }


}

//db.userDAO().insertUser(new User("toto", "toto@toto.fr","aze","homme"));

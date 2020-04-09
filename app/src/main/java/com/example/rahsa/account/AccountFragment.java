package com.example.rahsa.account;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rahsa.GlobalVariable;
import com.example.rahsa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    private TextView text_pseudo;
    private EditText edit_mail;
    private EditText edit_genre;
    private EditText edit_password;
    private Button btnDeconnexion;
    private GlobalVariable sharedData = GlobalVariable.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_account, container, false);

        text_pseudo = root.findViewById(R.id.account_pseudo);
        edit_mail = root.findViewById(R.id.account_mail);
        edit_genre = root.findViewById(R.id.account_genre);
        edit_password = root.findViewById(R.id.account_password);

        text_pseudo.setText(sharedData.userConnected.getPseudo());
        edit_mail.setText(sharedData.userConnected.getEmail());
        edit_genre.setText(sharedData.userConnected.getGenre());
        edit_password.setText(sharedData.userConnected.getPassword());

        btnDeconnexion = root.findViewById(R.id.btnToDeconnexion);
        btnDeconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDeconnexion();
            }
        } );

        return root;
    }

    public void getDeconnexion()
    {
        sharedData.setUserConnected(null);
        NavHostFragment.findNavController(this).navigate(R.id.account_to_connexion);
    }
}

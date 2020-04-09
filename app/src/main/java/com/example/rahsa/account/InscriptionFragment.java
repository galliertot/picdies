package com.example.rahsa.account;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.rahsa.GlobalVariable;
import com.example.rahsa.R;
import com.example.rahsa.database.DataBaseApp;
import com.example.rahsa.entities.User;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class InscriptionFragment extends Fragment {

    private DataBaseApp db;
    private Button btnInscription;
    private EditText inscription_pseudo;
    private EditText inscription_password;
    private EditText inscription_email;
    private RadioButton radio_homme;
    private RadioButton radio_femme;
    private GlobalVariable sharedData = GlobalVariable.getInstance();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_inscription, container, false);
        db = DataBaseApp.getInstance(root.getContext());

        inscription_pseudo = root.findViewById(R.id.inscription_pseudo);
        inscription_password = root.findViewById(R.id.inscription_password);
        inscription_email = root.findViewById(R.id.inscription_email);
        radio_homme = root.findViewById(R.id.radio_homme);
        radio_femme = root.findViewById(R.id.radio_femme);

        btnInscription = root.findViewById(R.id.btnInscription);

        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInscription();
            }
        } );

        return root;
    }

    public void getInscription()
    {
        if(!TextUtils.isEmpty(inscription_pseudo.getText()) && !TextUtils.isEmpty(inscription_password.getText()) && !TextUtils.isEmpty(inscription_email.getText()) && (radio_femme.isChecked() || radio_homme.isChecked()))
        {
            if(db.userDAO().getUserFromPseudo(inscription_pseudo.getText().toString()) == null)
            {
                if(db.userDAO().getUserFromEmail(inscription_email.getText().toString()) == null)
                {
                    User user = new User(inscription_pseudo.getText().toString(), inscription_email.getText().toString(), inscription_password.getText().toString(), getGenre());
                    db.userDAO().insertUser(user);
                    Snackbar.make(getView(), "Inscription réussi !", Snackbar.LENGTH_SHORT).show();
                    NavHostFragment.findNavController(this).navigate(R.id.inscription_to_connexion);
                }
                else
                {
                    Snackbar.make(getView(), "E-mail déjà utilisé !", Snackbar.LENGTH_SHORT).show();
                }
            }
            else
            {
                Snackbar.make(getView(), "Pseudo déjà utilisé !", Snackbar.LENGTH_SHORT).show();
            }
        }
        else
        {
            Snackbar.make(getView(), "Il manque des informations !", Snackbar.LENGTH_SHORT).show();
        }
    }

    public String getGenre(){
        if(radio_femme.isChecked())
            return radio_femme.getText().toString();
        else
            return radio_homme.getText().toString();
    }


}

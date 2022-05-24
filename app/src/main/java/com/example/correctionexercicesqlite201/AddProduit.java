package com.example.correctionexercicesqlite201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddProduit extends AppCompatActivity {

    EditText e1, e2, e3, e4;
    MyDBProduit db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_produit);

        db = new MyDBProduit(this);

        e1 = findViewById(R.id.addlib);
        e2 = findViewById(R.id.addfam);
        e3 = findViewById(R.id.addpa);
        e4 = findViewById(R.id.addpv);
    }

    public void ajouterProduit(View view) {

        if(e1.getText().toString().isEmpty()){
            Toast.makeText(this, "Libelle vide", Toast.LENGTH_SHORT).show();
            e1.requestFocus();
            return;
        }
        if(e2.getText().toString().isEmpty()){
            Toast.makeText(this, "Famille vide", Toast.LENGTH_SHORT).show();
            e2.requestFocus();
            return;
        }
        if(e3.getText().toString().isEmpty()){
            Toast.makeText(this, "Prix achat vide", Toast.LENGTH_SHORT).show();
            e3.requestFocus();
            return;
        }
        if(e4.getText().toString().isEmpty()){
            Toast.makeText(this, "Prix vente vide", Toast.LENGTH_SHORT).show();
            e4.requestFocus();
            return;
        }
        Produit p = new Produit();

        p.setLibelle(e1.getText().toString());
        p.setFamille(e2.getText().toString());
        p.setPrixAchat(Double.parseDouble(e3.getText().toString()));
        p.setPrixVente(Double.parseDouble(e4.getText().toString()));

        if(MyDBProduit.insert_produit(db.getWritableDatabase(),p)==-1)
            Toast.makeText(this, "Insertion echoue", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Insertion reussie", Toast.LENGTH_SHORT).show();


    }
}
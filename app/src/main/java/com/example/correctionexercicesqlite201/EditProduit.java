package com.example.correctionexercicesqlite201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class EditProduit extends AppCompatActivity {

    Spinner sp;
    EditText elib, efam, epa, epv;
    MyDBProduit dp;
    ArrayList<Produit> prds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_produit);
    }

    public void modifier(View view) {
    }

    public void supprimer(View view) {
    }
}
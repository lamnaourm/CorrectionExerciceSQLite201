package com.example.correctionexercicesqlite201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Produit p1 = new Produit(1,"hjhj")
    }

    public void acces(View view) {
        Intent i = null;
        switch (view.getId()){
            case R.id.b1: i=new Intent(MainActivity.this, ListerProduits.class); break;
            case R.id.b2: i=new Intent(MainActivity.this, FicheProduit.class); break;
            case R.id.b3: i=new Intent(MainActivity.this, AddProduit.class); break;
            case R.id.b4: i=new Intent(MainActivity.this, EditProduit.class); break;
        }
        startActivity(i);

    }
}
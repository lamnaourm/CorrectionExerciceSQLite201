package com.example.correctionexercicesqlite201;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditProduit extends AppCompatActivity {

    Spinner sp;
    EditText elib, efam, epa, epv;
    MyDBProduit db;
    ArrayList<Produit> prds;
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_produit);

        db = new MyDBProduit(this);
        sp= findViewById(R.id.spedit);
        elib = findViewById(R.id.editlib);
        efam = findViewById(R.id.editfam);
        epa = findViewById(R.id.editpa);
        epv = findViewById(R.id.editpv);

        prds = MyDBProduit.getAllprods(db.getReadableDatabase());

        ArrayList<String> nomsProds = new ArrayList<>();
        for(Produit pp: prds)
            nomsProds.add(pp.getId() + " - " + pp.getLibelle());

        ad = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,nomsProds);
        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Produit p = prds.get(i);
                elib.setText(p.getLibelle());
                efam.setText(p.getFamille());
                epa.setText(String.format("%f",p.getPrixAchat()));
                epv.setText(String.format("%f",p.getPrixVente()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void modifier(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(EditProduit.this);
        alert.setTitle("Modifier produit");
        alert.setMessage("Voulez-vous modifier ce produit ?");
        alert.setIcon(R.drawable.updatee);

        alert.setPositiveButton("Modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Produit p = prds.get(sp.getSelectedItemPosition());

                p.setLibelle(elib.getText().toString());
                p.setFamille(efam.getText().toString());
                p.setPrixAchat(Double.valueOf(epa.getText().toString()));
                p.setPrixVente(Double.valueOf(epv.getText().toString()));

                if(MyDBProduit.update_produit(db.getWritableDatabase(),p)==-1)
                    Toast.makeText(EditProduit.this, "Modification echoue", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EditProduit.this, "Modification reussie", Toast.LENGTH_SHORT).show();

            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(EditProduit.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }

    public void supprimer(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(EditProduit.this);
        alert.setTitle("Suppression produit");
        alert.setMessage("Voulez-vous supprimer ce produit ?");
        alert.setIcon(R.drawable.deletee);

        alert.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Produit p = prds.get(sp.getSelectedItemPosition());

                if(MyDBProduit.delete_produit(db.getWritableDatabase(),p.getId())==-1)
                    Toast.makeText(EditProduit.this, "suppression echoue", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(EditProduit.this, "Suppression reussie", Toast.LENGTH_SHORT).show();
                    ad.remove(p.getId() + " - " + p.getLibelle());
                }
            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(EditProduit.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
}
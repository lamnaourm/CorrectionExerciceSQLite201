package com.example.correctionexercicesqlite201;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDBProduit extends SQLiteOpenHelper {

    public static String DB_NAME="DBProduit.db";
    public static String TABLE_NAME="PRODUIT";
    public static String COL1="ID";
    public static String COL2="LIBELLE";
    public static String COL3="FAMILLE";
    public static String COL4="PRIXACHAT";
    public static String COL5="PRIXVENTE";

    public MyDBProduit(Context c){
        super(c,DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TABLE_NAME + "("+COL1+" integer primary key autoincrement,"+COL2+" TEXT,"+COL3+" TEXT,"+COL4+" double,"+COL5+" double)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql= "DROP TABLE " + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public static long insert_produit(SQLiteDatabase sqLiteDatabase, Produit p){
        ContentValues ct = new ContentValues();
        ct.put(COL2,p.getLibelle());
        ct.put(COL3,p.getFamille());
        ct.put(COL4,p.getPrixAchat());
        ct.put(COL5,p.getPrixVente());
        return sqLiteDatabase.insert(TABLE_NAME,null,ct);
    }

    public static long update_produit(SQLiteDatabase sqLiteDatabase, Produit p){
        ContentValues ct = new ContentValues();
        ct.put(COL2,p.getLibelle());
        ct.put(COL3,p.getFamille());
        ct.put(COL4,p.getPrixAchat());
        ct.put(COL5,p.getPrixVente());
        return sqLiteDatabase.update(TABLE_NAME,ct,"id="+p.getId(),null);
    }

    public static long delete_produit(SQLiteDatabase sqLiteDatabase, int id){
        return sqLiteDatabase.delete(TABLE_NAME,"id="+id,null);
    }

    public static ArrayList<Produit> getAllprods(SQLiteDatabase sqLiteDatabase){
        ArrayList<Produit> prds = new ArrayList<>();

        Cursor cur = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME,null);

        while(cur.moveToNext()){
            Produit p = new Produit();
            p.setId(cur.getInt(0));
            p.setLibelle(cur.getString(1));
            p.setFamille(cur.getString(2));
            p.setPrixAchat(cur.getDouble(3));
            p.setPrixVente(cur.getDouble(4));
            prds.add(p);
        }

        return prds;
    }

    public static Produit getOneprod(SQLiteDatabase sqLiteDatabase, int id){
        Produit p = null;

        Cursor cur = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = " + id,null);

        if(cur.moveToNext()){
            p = new Produit();
            p.setId(cur.getInt(0));
            p.setLibelle(cur.getString(1));
            p.setFamille(cur.getString(2));
            p.setPrixAchat(cur.getDouble(3));
            p.setPrixVente(cur.getDouble(4));
        }

        return p;
    }
}

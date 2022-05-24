package com.example.correctionexercicesqlite201;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
}

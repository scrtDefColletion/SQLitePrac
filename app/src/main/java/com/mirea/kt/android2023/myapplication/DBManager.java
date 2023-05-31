package com.mirea.kt.android2023.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBManager {
    private SQLiteOpenHelper sqLiteOpenHelper;
    private static final String TAG = "DBManager";

    public DBManager(SQLiteOpenHelper sqLiteOpenHelper) {
        this.sqLiteOpenHelper = sqLiteOpenHelper;
    }
    public boolean saveTelephoneToDatabase(Telephone telephone){
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        Log.d(TAG, "saveTelephoneToDatabase: saving Telephone");
        cv.put("model", telephone.getModel());
        cv.put("serial", telephone.getSerial());
        cv.put("price", telephone.getPrice());

        long rowId = db.insert("TABLE_TELEPHONES", null, cv);
        cv.clear();
        db.close();
        Log.d(TAG, "saveTelephoneToDatabase: " + rowId);
        return rowId != -1;
    }
    public ArrayList<Telephone> loadAllTelephoneFromDatabase(){
        ArrayList<Telephone> telephones = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteOpenHelper.getReadableDatabase();
        Cursor dbCursor = db.query("TABLE_TELEPHONES", null,null,
                null,null, null,null);
        if(dbCursor.moveToFirst()){
            do {
                String model = dbCursor.getString(dbCursor.getColumnIndexOrThrow("model"));
                String serial = dbCursor.getString(dbCursor.getColumnIndexOrThrow("serial"));
                int price = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("price"));
                telephones.add(new Telephone(model, serial,price));
            }while(dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();
        return telephones;
    }
}

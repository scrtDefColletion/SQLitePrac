package com.mirea.kt.android2023.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyAppSQLiteHelper extends SQLiteOpenHelper {
    private static final String TAG = "MyAppSQLiteHelper";
    public MyAppSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table TABLE_TELEPHONES " +
                "(_id integer primary key autoincrement," +
                "model text, " +
                "serial text, " +
                "price integer);");
        Log.d(TAG, "onCreate: is created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

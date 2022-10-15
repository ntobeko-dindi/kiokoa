package com.ntobeko.kiokoa.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ntobeko.kiokoa.interfaces.IStorage;
import com.ntobeko.kiokoa.models.Credential;


public class DBHelper extends SQLiteOpenHelper implements IStorage<Credential,Cursor> {

    public DBHelper(Context context) {
        super(context, "Credentials.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Credentials(siteName TEXT primary key, userName TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Credentials");
    }

    @Override
    public boolean deleteData(Credential data) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Credentials where siteName = ?", new String[]{data.toString()});
        if(cursor.getCount()>0) {
            long result = DB.delete("Credentials", "siteName=?", new String[]{data.toString()});

            return result != -1;
        }
        else { return false; }
    }

    @Override
    public boolean writeData(Credential data) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("siteName", ((Credential)data).getSiteName());
        contentValues.put("userName", ((Credential)data).getUserName());
        contentValues.put("password", ((Credential)data).getPassword());
        long result = DB.insert("Credentials", null, contentValues);

        return result != -1;
    }

    @Override
    public Cursor getData() {
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.rawQuery("Select * from Credentials", null);
    }
}
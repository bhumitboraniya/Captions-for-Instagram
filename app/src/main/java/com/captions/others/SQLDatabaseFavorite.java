package com.captions.others;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLDatabaseFavorite {
    Context context;
    SQLiteDatabase db;

    public SQLDatabaseFavorite(Context context) {
        this.context = context;
    }

    public class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context) {
            super(context, "Bharat_Ka_itihasDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table favorite_list(favorite_id integer PRIMARY KEY AUTOINCREMENT,nameofdata text,listoffavorite text)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    public void openDB() {
        db = new OpenHelper(context).getWritableDatabase();
    }

    public void closeDB() {
        db.close();
    }

    public void insertfavorite(String nameofdata, String listoffavorite) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nameofdata", nameofdata);
        contentValues.put("listoffavorite", listoffavorite);
        db.insert("favorite_list", null, contentValues);
    }

    public void deletefavorite(int favorite_id) {
        db.delete("favorite_list", "favorite_id =" + favorite_id, null);
    }


    public void updatefavorite(int favorite_id, String nameofdata, String listoffavorite) {
        ContentValues values = new ContentValues();
        values.put("nameofdata", nameofdata);
        values.put("college_hod", listoffavorite);
        db.update("favorite_list", values, "favorite_id =" + favorite_id, null);
    }

    public ArrayList<HashMap<String, String>> getfavoritedata() {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        Cursor cursor = db.rawQuery("select * from favorite_list", null);
        while (cursor.moveToNext()) {
            int favorite_id = cursor.getInt(cursor.getColumnIndex("favorite_id"));
            String nameofdata = cursor.getString(cursor.getColumnIndex("nameofdata"));
            String listoffavorite = cursor.getString(cursor.getColumnIndex("listoffavorite"));

            HashMap<String, String> map = new HashMap<>();
            map.put("favorite_id", favorite_id + "");
            map.put("nameofdata", nameofdata);
            map.put("listoffavorite", listoffavorite);
            list.add(map);
        }
        return list;
    }

}

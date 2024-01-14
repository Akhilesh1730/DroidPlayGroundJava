package com.example.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ContactModel;

import java.util.ArrayList;
import java.util.List;

public class DBOpenHelper extends SQLiteOpenHelper {


    private static final String DB_NAME = "playDB";
    private static final String TABLE_NAME = "contacts";

    public DBOpenHelper(Context context) {
        //super(context, name, factory, version);
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table " + TABLE_NAME +
                "(" + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT," + "name" +" TEXT,"
                + "phone" + " TEXT " + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addContacts(String name, String phone_no) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone_no);
        db.insert(TABLE_NAME, null, values);
    }

    public List<ContactModel> getContacts() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * From " +TABLE_NAME, null);
        ArrayList<ContactModel> aarContacts = new ArrayList<>();

        while(cursor.moveToNext()) {
            ContactModel model = new ContactModel(cursor.getInt(0),
                                                  cursor.getString(1),
                                                  cursor.getString(2));
            aarContacts.add(model);
        }
        return aarContacts;
    }

    public void updateContacts(ContactModel model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "akhi28");
        db.update(TABLE_NAME, values, "id = " + model.getId(), null);
    }

    public void deleteContacts(ContactModel model) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id = ? ", new String[]{String.valueOf(1)});
    }
}

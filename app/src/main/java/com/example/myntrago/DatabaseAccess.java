package com.example.myntrago;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    String promocode;
 private SQLiteOpenHelper openHelper;
 private SQLiteDatabase database;
 private static DatabaseAccess instance;

 /**
      * Private constructor to aboid object creation from outside classes.
      *
      * @param context
      */
        private DatabaseAccess(Context context) {
        this.openHelper = new DataBaseOpenHelper(context);
  }

 /**
      * Return a singleton instance of DatabaseAccess.
      *
      * @param context the Context
      * @return the instance of DabaseAccess
      */
         public static DatabaseAccess getInstance(Context context) {
             if (instance == null) {
     instance = new DatabaseAccess(context);
    }
    return instance;
   }

   /**
      * Open the database connection.
      */
        public void open() {
     this.database = openHelper.getWritableDatabase();
     }

   /**
      * Close the database connection.
      */
         public void close() {
        if (database != null) {
            this.database.close();
    }
   }

   /**
      * Read all quotes from the database.
      *
      * @return a List of quotes
      */
         public List<String> getValidity() {
      List<String> list = new ArrayList<>();
      Cursor cursor = database.rawQuery("SELECT ValidTill FROM PromoDetails", null);
       cursor.moveToFirst();
       while (!cursor.isAfterLast()) {
        list.add(cursor.getString(0));
        cursor.moveToNext();
        }
       cursor.close();
      return list;
  }
    public List<String> getPromoCode() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT PromoCode FROM PromoDetails", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public List<String> getProdName() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT ProdName FROM PromoDetails", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
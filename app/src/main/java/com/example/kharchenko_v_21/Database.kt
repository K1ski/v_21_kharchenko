package com.example.kharchenko_v_21

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class Database(context: Context, databaseName: String) : SQLiteOpenHelper(context, databaseName, null, 1) {

    companion object {
        const val TABLE = "users"
        const val COLUMN_ID = "_id"
        const val COLUMN_LOGIN = "login"
        const val COLUMN_PASS = "password"
    }

    override fun onCreate(db: SQLiteDatabase) {
        try {
            db.execSQL(
                "CREATE TABLE $TABLE (" +
                        "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "$COLUMN_LOGIN TEXT, " +
                        "$COLUMN_PASS TEXT);"
            )





            db.execSQL(
                "INSERT INTO $TABLE ($COLUMN_LOGIN, $COLUMN_PASS) VALUES ('Admin', '1');"
            )
        } catch (e: Exception) {
            Log.e("DatabaseHelper", "Ошибка при создании базы данных: ${e.message}")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE")
        onCreate(db)
    }
}
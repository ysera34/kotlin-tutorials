package org.inframincer.registerusers.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        val DB_NAME = "user.db"
        val DB_VERSION = 1
    }

    val TABLE_NAME = "user"
    val ID = "_id"
    val NAME = "name"
    val AGE = "age"
    val TEL_NUMBER = "tel_number"
    val PICTURE_PATH = "picture_path"

    val TABLE_CREATE = "CREATE TABLE if not exists " + TABLE_NAME + " (" +
            "${ID} integer PRIMARY KEY, t, ${NAME} text, " +
            "${AGE} text, ${TEL_NUMBER} text, ${PICTURE_PATH} text" + ")"

    fun getUserAllWithCursor(): Cursor {
        return readableDatabase.query(TABLE_NAME, arrayOf(ID, NAME, AGE, TEL_NUMBER, PICTURE_PATH),
                null, null, null, null, null)
    }

    fun addUser(user: UserInfo) {
        var info = ContentValues()
        info.put(NAME, user.name)
        info.put(AGE, user.age)
        info.put(TEL_NUMBER, user.telNumber)
        info.put(PICTURE_PATH, user.picturePath)
        writableDatabase.insert(TABLE_NAME, null, info)
    }

    fun deleteUser(id: Long) {
        writableDatabase.execSQL("DELETE FROM ${TABLE_NAME} WHERE ${ID} = ${id};")
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}

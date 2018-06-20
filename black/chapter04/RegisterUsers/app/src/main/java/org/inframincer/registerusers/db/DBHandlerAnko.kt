package org.inframincer.registerusers.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.jetbrains.anko.db.INTEGER
import org.jetbrains.anko.db.PRIMARY_KEY
import org.jetbrains.anko.db.TEXT
import org.jetbrains.anko.db.createTable

class DBHandlerAnko(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        val DB_NAME = "user.db"
        val DB_VERSION = 1
    }

    object UserTable {
        val TABLE_NAME = "user"
        val ID = "_id"
        val NAME = "name"
        val AGE = "age"
        val TEL_NUMBER = "tel_number"
        val PICTURE_PATH = "picture_path"
    }

    fun getUserAllWithCursor(): Cursor {
        return readableDatabase.query(UserTable.TABLE_NAME,
            arrayOf(UserTable.ID, UserTable.NAME, UserTable.AGE, UserTable.TEL_NUMBER, UserTable.PICTURE_PATH),
            null, null, null, null, null)
    }

    fun addUser(user: UserInfo) {
        var info = ContentValues()
        info.put(UserTable.NAME, user.name)
        info.put(UserTable.AGE, user.age)
        info.put(UserTable.TEL_NUMBER, user.telNumber)
        info.put(UserTable.PICTURE_PATH, user.picturePath)

        writableDatabase.use {
            writableDatabase.insert(UserTable.TABLE_NAME, null, info)
        }
    }

    fun deleteUser(id: Long) {
        writableDatabase.use {
            writableDatabase.execSQL(
                "DELETE FROM ${UserTable.TABLE_NAME} WHERE ${UserTable.ID} = ${id};"
            )
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(UserTable.TABLE_NAME, true,
                Pair(UserTable.ID, INTEGER + PRIMARY_KEY),
                Pair(UserTable.NAME, TEXT),
                Pair(UserTable.AGE, TEXT),
                Pair(UserTable.TEL_NUMBER, TEXT),
                Pair(UserTable.PICTURE_PATH, TEXT))
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        
    }
}
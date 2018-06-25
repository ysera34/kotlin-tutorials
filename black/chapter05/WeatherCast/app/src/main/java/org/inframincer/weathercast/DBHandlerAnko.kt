package org.inframincer.weathercast

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.inframincer.weathercast.data.CityData
import org.jetbrains.anko.db.INTEGER
import org.jetbrains.anko.db.PRIMARY_KEY
import org.jetbrains.anko.db.TEXT
import org.jetbrains.anko.db.createTable

class DBHandlerAnko(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object CityTable {
        val DB_NAME = "user.db"
        val DB_VERSION = 1

        val TABLE_NAME = "city"
        val ID = "_id"
        val NAME = "name"
        val API_ID = "api_id"
    }

    fun getCityDataAll(): ArrayList<CityData> {
        val data = ArrayList<CityData>()
        val cursor = readableDatabase.query(CityTable.TABLE_NAME,
                arrayOf(CityTable.ID, CityTable.NAME, CityTable.API_ID),
                null, null, null, null, null)
        if (cursor.count == 0) return data
        cursor.moveToFirst()
        do {
            val city: CityData = CityData(cursor.getString(2), cursor.getString(1))
            data.add(city)
        } while (cursor.moveToNext())
        return data
    }

    fun saveCity(city: CityData) {
        writableDatabase.use {
            writableDatabase.insert(CityTable.TABLE_NAME, null, ContentValues().apply {
                put(CityTable.NAME, city.name)
                put(CityTable.API_ID, city._id)
            })
        }
    }

    fun deleteCity(id: String) {
        writableDatabase.use {
            writableDatabase.execSQL(
                    "DELETE FROM ${CityTable.TABLE_NAME} WHERE ${CityTable.API_ID} = ${id};"
            )
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(CityTable.TABLE_NAME, true,
                Pair(CityTable.ID, INTEGER + PRIMARY_KEY),
                Pair(CityTable.NAME, TEXT),
                Pair(CityTable.API_ID, TEXT))
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
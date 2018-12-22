package org.inframincer.todolist

import android.app.Application
import io.realm.Realm

/**
 * Created by ysera34 on 2018. 12. 22..
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}
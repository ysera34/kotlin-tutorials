package org.inframincer.todolist

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by ysera34 on 2018. 12. 22..
 */
open class Todo(
        @PrimaryKey var id: Long = 0,
        var title: String = "",
        var date: Long = 0
) : RealmObject() {
}
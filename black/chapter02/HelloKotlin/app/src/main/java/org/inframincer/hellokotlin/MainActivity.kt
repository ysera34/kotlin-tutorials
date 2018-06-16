package org.inframincer.hellokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var person: Person = Person("Peter")
//        var youth:Person = Person("Bill", 13)
//
//        Log.i("Person", person.toString())
//        Log.i("youth", youth.toString())

        var person: Person = Person()
        person.name = "Billy"
        person.age = 20
//        person.privateAge = 3
    }
}

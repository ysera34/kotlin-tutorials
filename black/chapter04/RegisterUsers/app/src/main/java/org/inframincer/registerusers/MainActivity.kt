package org.inframincer.registerusers

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import org.inframincer.registerusers.db.DBHandlerAnko

class MainActivity : AppCompatActivity() {
    private var mUserAdapter: UserListCursorAdapter? = null
    var mDBHandler: DBHandlerAnko = DBHandlerAnko(this)
    companion object {
        val REQUEST_ADD_USER = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val newOne = mDBHandler.getUserAllWithCursor()
        if (newOne.count != 0) {
            mUserAdapter = UserListCursorAdapter(this, newOne)
            val userRecyclerView: RecyclerView = findViewById(R.id.user_recycler_view)
            userRecyclerView.adapter = mUserAdapter
            userRecyclerView.layoutManager = LinearLayoutManager(this)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_user -> {
                Toast.makeText(this, "add_user", Toast.LENGTH_SHORT).show()
//                val intent: Intent = Intent(this.SaveUserActivity::class.java)
//                startActivityForResult(intent, REQUEST_ADD_USER)
            }
            R.id.anko -> {
//                val intent: Intent = Intent(this, AnkoDSLActivity::class.java)
//                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_ADD_USER -> {
                val newOne = mDBHandler.getUserAllWithCursor()
                if (mUserAdapter == null) {
                    mUserAdapter = UserListCursorAdapter(applicationContext, newOne)
                    val userRecyclerView: RecyclerView = findViewById(R.id.user_recycler_view)
                    userRecyclerView.adapter = mUserAdapter
                    userRecyclerView.layoutManager = LinearLayoutManager(this)
                }
                mUserAdapter?.changeCursor(newOne)
                mUserAdapter?.notifyDataSetChanged()
            }
        }
    }

    fun onClickDelete(view: View) {
        mDBHandler.deleteUser(view.tag as Long)
        val newOne = mDBHandler.getUserAllWithCursor()
        mUserAdapter?.changeCursor(newOne)
    }

    override fun onDestroy() {
        super.onDestroy()
        mUserAdapter?.cursor?.close()
        mDBHandler.close()
    }
}

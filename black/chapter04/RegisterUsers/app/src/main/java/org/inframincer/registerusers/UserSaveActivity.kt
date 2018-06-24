package org.inframincer.registerusers

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_user_save.*
import org.inframincer.registerusers.db.DBHandlerAnko
import org.inframincer.registerusers.db.UserInfo

class UserSaveActivity() : AppCompatActivity() {
    val mDBHandler = DBHandlerAnko(this)
    val PICK_IMAGE: Int = 1010
    val REQUEST_PERMISSION = 1011

    var mSelectedImageResId: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_save)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun onclickImage(view: View?) {
        val check = ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (check != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    REQUEST_PERMISSION)
        } else {
            val intent = Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        var notGranted = kotlin.arrayOfNulls<String>(permissions.size)
        when (requestCode) {
            REQUEST_PERMISSION -> {
                var index: Int = 0
                for (i in 0..permissions.size - 1) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        val rationale = ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i])
                        if (!rationale) { // Show Dialog that explain to grant permission
                            val dialogBuild = AlertDialog.Builder(this)
                                    .setTitle("Permission Settings")
                                    .setMessage("You need permission to save.")
                                    .setCancelable(true)
                                    .setPositiveButton("Setting") { dialog, which ->
                                        showSetting()
                                    }
                            dialogBuild.create().show()
                            return
                        } else {
                            notGranted[index++] = permissions[i]
                        }
                    }

                }
                if (notGranted.isNotEmpty()) {
                    ActivityCompat.requestPermissions(this, notGranted, REQUEST_PERMISSION)
                }
            }
        }
    }

    fun showSetting() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", packageName, null))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            PICK_IMAGE -> {
                val uri = data?.data
                uri ?: return

                mSelectedImageResId = getImageResId(uri)
                if (mSelectedImageResId == -1L) return
                val bitmap: Bitmap = MediaStore.Images.Thumbnails.getThumbnail(
                        contentResolver, mSelectedImageResId, MediaStore.Images.Thumbnails.MICRO_KIND, null)
                val selectImageView: ImageView = findViewById(R.id.select_image_view) as ImageView
                selectImageView.setImageBitmap(bitmap)
            }
        }
    }

    fun getImageResId(uri: Uri): Long {
        val projection = arrayOf(MediaStore.Images.Media._ID)
        val cursor = managedQuery(uri, projection, null, null, null)
        val columnIndex = cursor.getColumnIndex(MediaStore.Images.Media._ID)

        if (columnIndex == -1) return -1
        cursor.moveToFirst()
        val id = cursor.getLong(columnIndex)
        cursor.close()
        return id
    }

    fun onClickSaveButton(view: View) {
        val user: UserInfo = UserInfo(
                name_edit_text.text.toString(), age_edit_text.text.toString(),
                tel_number_edit_text.text.toString(), mSelectedImageResId.toString())
        mDBHandler.addUser(user)
        mDBHandler.close()
        finish()
    }
}
package org.inframincer.registerusers

import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.provider.MediaStore
import android.support.v4.widget.CursorAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class UserListAdapter(context: Context, cursor: Cursor?) : CursorAdapter(context, cursor, FLAG_REGISTER_CONTENT_OBSERVER) {
//    val mContext = context

    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
        var inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val mainView = inflater.inflate(R.layout.layout_list_item_user, parent, false)
        val holder: UserViewHolder = UserViewHolder(
                mainView.findViewById(R.id.profile_image_view) as ImageView,
                mainView.findViewById(R.id.name_text_view) as TextView,
                mainView.findViewById(R.id.tel_number_text_view) as TextView,
                mainView.findViewById(R.id.delete_image_button) as ImageButton)
        mainView.tag = holder
        return mainView
    }

    override fun bindView(view: View, context: Context, cursor: Cursor) {
        val holder = view.tag as UserViewHolder
        holder.nameTextView.text = String.format("%s (%d)", cursor.getString(1), cursor.getInt(2))
        holder.telNumberTextView.text = cursor.getString(3)
        val picture: Drawable = getPicture(cursor.getString(4))?:context.getDrawable(android.R.drawable.ic_menu_gallery)
        holder.pictureImageView.background = picture
        holder.deleteImageView.tag = cursor.getLong(0)
    }

    private fun getPicture(path: String): Drawable? {
        val imageResId = path.toLong()
        if (imageResId == 0L) return null

        val bitmap: Bitmap = MediaStore.Images.Thumbnails.getThumbnail(
                mContext.contentResolver, imageResId, MediaStore.Images.Thumbnails.MICRO_KIND, null)
        bitmap?:return null
        return BitmapDrawable(mContext.resources, bitmap)
    }
}

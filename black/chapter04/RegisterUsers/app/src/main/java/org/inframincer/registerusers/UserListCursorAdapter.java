package org.inframincer.registerusers;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class UserListCursorAdapter extends CursorRecyclerViewAdapter<UserListCursorAdapter.UserViewHolder>{

    public UserListCursorAdapter(Context context, Cursor cursor){
        super(context,cursor);
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView mPictureImageView;
        TextView mNameTextView;
        TextView mTelNumberTextView;
        TextView mDeleteImageView;

        UserViewHolder(View view) {
            super(view);
            mPictureImageView = view.findViewById(R.id.profile_image_view);
            mNameTextView = view.findViewById(R.id.name_text_view);
            mTelNumberTextView = view.findViewById(R.id.tel_number_text_view);
            mDeleteImageView = view.findViewById(R.id.delete_image_button);
        }

        private void bindView(Cursor cursor) {
            mNameTextView.setText(String.format("%s (%d)", cursor.getString(1), cursor.getInt(2)));
            mTelNumberTextView.setText(cursor.getString(3));
            mDeleteImageView.setTag(cursor.getLong(0));
        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_list_item_user, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder viewHolder, Cursor cursor) {
        viewHolder.bindView(cursor);
    }
}

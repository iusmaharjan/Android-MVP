package com.example.ayush.mvpcleanarchitecture.userlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ayush.mvpcleanarchitecture.R;
import com.example.ayush.mvpcleanarchitecture.model.User;

import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> implements RealmChangeListener{

    RealmResults<User> users;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(View view) {
            super(view);
            mTextView = (TextView)view.findViewById(R.id.textview_email);
        }
    }

    public UserListAdapter(RealmResults<User> results) {
        users = results;

        users.addChangeListener(this);
    }

    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserListAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(users.get(position).getEmailAddress());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public void onChange() {
        notifyDataSetChanged();
    }
}

package com.example.ayush.mvpcleanarchitecture.userlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ayush.mvpcleanarchitecture.R;
import com.example.ayush.mvpcleanarchitecture.model.User;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.Realm;

public class UserListActivity extends AppCompatActivity{

    private Realm mRealm;

    @Bind(R.id.activity_user_list_recyclerview_list)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        ButterKnife.bind(this);

        mRealm = Realm.getInstance(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new UserListAdapter(mRealm.allObjects(User.class)));

        User user;

        mRealm.beginTransaction();
        user = mRealm.createObject(User.class);
        user.setEmailAddress("ius.maharjan@gmail.com");
        user.setPassword("test123");
        mRealm.commitTransaction();

        mRealm.beginTransaction();
        user = mRealm.createObject(User.class);
        user.setEmailAddress("iusmaharjan@gmail.com");
        user.setPassword("test123");
        mRealm.commitTransaction();
    }

    @Override
    protected void onDestroy() {
        mRealm.close();
        super.onDestroy();
    }


}

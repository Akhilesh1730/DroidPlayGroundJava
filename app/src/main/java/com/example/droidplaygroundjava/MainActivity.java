package com.example.droidplaygroundjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.droidplaygroundjava.adapter.RecyclerViewAdapter;
import com.example.droidplaygroundjava.databinding.ActivityMainBinding;
import com.example.droidplaygroundjava.model.User;
import com.example.droidplaygroundjava.util.UserUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener {
    private LinearLayoutManager manager;
    private boolean isScrolling = false;
    private ArrayList<User> userList;

    private RecyclerViewAdapter adapter;
    int totalCount = 15, childCount, firstPosition = 0, startIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        manager = new LinearLayoutManager(this);
        userList = UserUtil.getUsers(0, 15);
        RecyclerView recyclerView = binding.recyclerviewUser;
        recyclerView.setLayoutManager(manager);
        adapter = new RecyclerViewAdapter(userList, this);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    //showToast("Scrolling");
                    isScrolling = true;
                }
                /*if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    showToast("Scrolling stopped");
                } else if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    showToast("Scrolling");
                }*/
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalCount = manager.getItemCount();
                childCount = manager.getChildCount();
                firstPosition = manager.findFirstVisibleItemPosition();
                Log.d("###", "onScrolled: " + childCount + " " + firstPosition + " " );
                if (isScrolling && (firstPosition + childCount >= totalCount - 1)) {
                    isScrolling = false;
                    startIndex = startIndex + 15;
                    userList.addAll(UserUtil.getUsers(startIndex, startIndex + 15));
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickItem(int position) {
        userList.remove(position);
        adapter.notifyDataSetChanged();
    }
}
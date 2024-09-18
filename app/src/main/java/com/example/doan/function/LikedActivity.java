package com.example.doan.function;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.doan.R;
import com.example.doan.view.VideoAdapter;
import com.example.doan.view.VideoDBHelper;
import com.example.doan.view.VideoList;

import java.util.ArrayList;

public class LikedActivity extends AppCompatActivity {
    RecyclerView rvLikedlist;
    VideoAdapter videoListAdapter;
    ArrayList<VideoList> lstvideoLiked;
    VideoDBHelper videoDBHelper;

    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_liked);
        rvLikedlist = findViewById(R.id.rvLikedList);
        videoDBHelper = new VideoDBHelper(LikedActivity.this);
//        lstvideoLiked = VideoDBHelper.getVideoLiked();

//        videoListAdapter = new VideoAdapter(this, lstvideoLiked);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false);

        rvLikedlist.setLayoutManager(linearLayoutManager);

        rvLikedlist.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        rvLikedlist.setAdapter(videoListAdapter);

    }
}
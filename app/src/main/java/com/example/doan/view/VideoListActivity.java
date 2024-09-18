
package com.example.doan.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.R;

import java.util.ArrayList;

public class VideoListActivity extends AppCompatActivity  {
    //implements VideoListAdapter.VideoCallBack
    RecyclerView recyclerView;
    ArrayList<VideoList> videolists;
    VideoAdapter videolistAdapter;
    VideoDBHelper videoDBHelper;

//
////    int index;
//    VideoDBHelper videoDB;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityplanlist);

        videoDBHelper = new VideoDBHelper(VideoListActivity.this);

        recyclerView = findViewById(R.id.RViewVList);
        videoDBHelper.copyDatabase();
        videolists = videoDBHelper.getVideos();


        videolistAdapter= new VideoAdapter(videolists, VideoListActivity.this);

        recyclerView.setAdapter(videolistAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

//    @Override
//    public void onItemClick(String id) {
//        Intent i = new Intent(VideoListActivity.this,VideoplayActivity.class);
//        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(i);
//    }
}
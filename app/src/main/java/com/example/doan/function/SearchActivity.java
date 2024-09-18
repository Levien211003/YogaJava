package com.example.doan.function;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan.R;
import com.example.doan.fragment.HomeFragment;
import com.example.doan.view.VideoAdapter;
import com.example.doan.view.VideoDBHelper;
import com.example.doan.view.VideoList;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
//
//    Button btnSearch;
//
//    RecyclerView rvSearch;
//
//    EditText edtSearch;
//
//    VideoDBHelper videoDBHelper;
//
//
//    ArrayList<VideoList> lstvideoSearch;
//
//    VideoAdapter videoAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//        btnSearch = findViewById(R.id.btnSearch);
//
//        rvSearch = findViewById(R.id.rcvSearch);
//
//        edtSearch = findViewById(R.id.edSearch);
//
//        videoDBHelper = new VideoDBHelper(SearchActivity.this);
//
//
//        btnSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String searchdata = edtSearch.getText().toString().toLowerCase();
//                lstvideoSearch = VideoDBHelper.getVideoWhereName(searchdata);
//                VideoAdapter videoAdapter = new VideoAdapter(lstvideoSearch, SearchActivity.this);
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this,
//                        LinearLayoutManager.VERTICAL,
//                        false);
//                rvSearch.setLayoutManager(linearLayoutManager);
//                rvSearch.addItemDecoration(new DividerItemDecoration(SearchActivity.this,DividerItemDecoration.VERTICAL));
//                rvSearch.setAdapter(videoAdapter);
//            }
//        });
//
//
//    }
//
//
//    public void btnBackHome_OnClick(View view) {
//        Intent intent = new Intent(SearchActivity.this, HomeFragment.class);
//        startActivity(intent);
//    }
}
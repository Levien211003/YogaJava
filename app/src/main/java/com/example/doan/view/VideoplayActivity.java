package com.example.doan.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doan.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class VideoplayActivity extends AppCompatActivity {
    TextView mvideoid, mvideoname, mtvdetails;
    ImageView back, favorite;
    VideoDBHelper videoDBHelper;
    ArrayList<VideoList> videolists;
    VideoList videoList;
    Button btnfont;
    int i =0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoyoutube);

        videoDBHelper = new VideoDBHelper(VideoplayActivity.this);
        videoDBHelper.copyDatabase();
        videolists = videoDBHelper.getVideos();


        //ánh xạ chi tiết của video
        mvideoid = findViewById(R.id.tvvideoid);
        mvideoname = findViewById(R.id.Video_NAME);
        mtvdetails = findViewById(R.id.tvDetails);
        mvideoname.setText(getIntent().getStringExtra("NAME@#"));
        mtvdetails.setText(getIntent().getStringExtra("Details#@"));
        // nhận intent từ VideolistActivity và gán vào ID
        String ID = getIntent().getStringExtra("VideoID@#");
        //Dùng thư viện youtubeplayerView để chạy video từ YTID đã được intent và gán ở trên
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = ID;
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        //ánh xạ các imageview cho sự kiện onclick
        back = findViewById(R.id.backIV);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(VideoplayActivity.this, VideoListActivity.class);
                startActivity(back);
            }
        });
        btnfont =(Button) findViewById(R.id.btnFont2);
        mtvdetails = (TextView) findViewById(R.id.tvDetails);
        btnfont.setOnClickListener(v -> {
            i=i+1;
            if(i>3) i = 0;
            if(i==0){
                mtvdetails.setTextSize(10);
            }else if(i == 1){
                mtvdetails.setTextSize(20);
            } else if (i == 2) {

                mtvdetails.setTextSize(30);
            } else if (i == 3) {
                mtvdetails.setTextSize(40);
            }
        });
//
//        favorite = findViewById(R.id.favoriteIV);
//        if(videoList.getFavorite()==1){
//            favorite.setBackground(getDrawable(R.drawable.baseline_favorite_24));
//        }
//        favorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(videoList.getFavorite()==1){
//                    favorite.setBackground(getDrawable(R.drawable.baseline_favorite_24));
//                    videoDBHelper.favorite(videoList.getVid());
//                }
//                else if(videoList.getFavorite()==0){
//                    favorite.setBackground(getDrawable(R.drawable.baseline_favorite_border_24));
//                    videoDBHelper.unfavorite(videoList.getVid());
//                }
//            }
//        });
    }
}
package com.example.doan.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.doan.R;
import com.example.doan.function.LikedActivity;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideolistViewHolder> {

    private ArrayList<VideoList> videolists;
//    VideoCallBack videoCallBack;
    Context context;


    public static class VideolistViewHolder extends RecyclerView.ViewHolder{
        TextView mName, mDe1 , mDe2, mvideoID;
        ImageView mIMGView;
        public VideolistViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tvName);
            mDe1 = itemView.findViewById(R.id.tvDe1);
            mDe2 = itemView.findViewById(R.id.tvDe2);
            mIMGView = itemView.findViewById(R.id.imgItemView);
            mvideoID = itemView.findViewById(R.id.videoID);
        }
    }
//    public void setCallback(VideoCallBack callback){this.videoCallBack=callback;}
    public VideoAdapter(ArrayList<VideoList> videolists, Context context) {

        this.videolists = videolists;
        this.context = context;


    }
    @NonNull
    @Override
    public VideolistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View videolistView = inflater.inflate(R.layout.videolistitemlayout, parent, false);
        VideolistViewHolder viewHolder = new VideolistViewHolder(videolistView) ;
        return viewHolder ;
    }



    //    @Override
//    public void onBindViewHolder(@NonNull  VideolistViewHolder holder,int position) {
//        VideoList mvideoList = videolists.get(position);
//        if(mvideoList  == null){
//            return;}
//        else{
//                holder.mName.setText(mvideoList.getName());
//                holder.mDe1.setText(mvideoList.getDe1());
//                holder.mDe2.setText(mvideoList.getDe2());
//
//                Glide.with(holder.mIMGView.getContext())
//                        .load(mvideoList.getImageurl())
//                        .into(holder.mIMGView);
//
//                holder.itemView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent i =new Intent(context,VideoplayActivity.class);
//                        i.putExtra("VideoID@#",videolists.get(position).getId());
//                        i.putExtra("NAME@#",videolists.get(position).getName());
//                        i.putExtra("Details#@",videolists.get(position).getDetails());
//                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        context.startActivity(i);
//                    }
//                });
//        }
//    }
    public void onBindViewHolder(@NonNull VideolistViewHolder holder, @SuppressLint("RecyclerView") int position) {
        VideoList item = videolists.get(position);
        Glide.with(this.context)
                        .load(item.getImageurl())
                                .into(holder.mIMGView);
        holder.mName.setText(item.getName());
//        holder.mDe1.setText(item.getDe1());
        holder.mDe2.setText(item.getDe2());
        //khai báo thêm vào đây --------
        //holder.itemView.setOnClickListener(view -> videoCallBack.onItemClick(item.getId()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, VideoplayActivity.class);
                i.putExtra("VideoID@#", videolists.get(position).getId());
                i.putExtra("NAME@#", videolists.get(position).getName());
                i.putExtra("Details#@", videolists.get(position).getDetails());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return videolists.size();
    }



//    public  interface VideoCallBack{
//
//        void onItemClick(String id);
//    }
}

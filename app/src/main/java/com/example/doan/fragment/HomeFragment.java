package com.example.doan.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doan.R;
import com.example.doan.view.VideoListActivity;


public class HomeFragment extends Fragment {



    public HomeFragment() {
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
////
    CardView mCVThanTren,mCVThanDuoi, mCVCoBung, mCVCoNguc, mCVCanhTay, mCVCoChan;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mCVThanTren = view.findViewById(R.id.CVThanTren);
        mCVThanTren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentThanTren = new Intent(getActivity(), VideoListActivity.class);
                startActivity(intentThanTren);

            }
        });
//
//        mCVThanDuoi = view.findViewById(R.id.CVThanDuoi);
//        mCVThanDuoi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intentThanDuoi = new Intent(getActivity(), PlanListActivity.class);
//                startActivity(intentThanDuoi);
//            }
//        });
//
//        mCVCoBung = view.findViewById(R.id.CVCoBung);
//        mCVCoBung.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intentCoBung = new Intent(getActivity(), PlanListActivity.class);
//                startActivity(intentCoBung);
//            }
//        });
//        mCVCoNguc = view.findViewById(R.id.CVCoNguc);
//        mCVCoNguc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intentCoNguc = new Intent(getActivity(), PlanListActivity.class);
//                startActivity(intentCoNguc);
//            }
//        });
//        mCVCanhTay = view.findViewById(R.id.CVCanhTay);
//        mCVCanhTay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intentCanhTay = new Intent(getActivity(), PlanListActivity.class);
//                startActivity(intentCanhTay);
//            }
//        });
//        mCVCoChan = view.findViewById(R.id.CVCoChan);
//        mCVCoBung.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intentCoChan = new Intent(getActivity(), PlanListActivity.class);
//                startActivity(intentCoChan);
//            }
//        });









    }
}
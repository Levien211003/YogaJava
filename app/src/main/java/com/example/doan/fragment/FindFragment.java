package com.example.doan.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.doan.R;
import com.example.doan.view.VideoAdapter;
import com.example.doan.view.VideoDBHelper;
import com.example.doan.view.VideoList;

import java.util.ArrayList;


public class FindFragment extends Fragment {



    public FindFragment() {

    }



    public static FindFragment newInstance(String param1, String param2) {
        FindFragment fragment = new FindFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
    Button btnSearch;
    RecyclerView rcvSearch;
    EditText edSearch;
    VideoDBHelper videoDBHelper;
    ArrayList<VideoList> lstvideoSearch;
    VideoAdapter videoAdapter;

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//
//
//    }
public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
//    (R.layout.fragment_find);


}
}
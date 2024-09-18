package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.doan.fragment.LikedFragment;
import com.example.doan.fragment.SettingFragment;
import com.example.doan.fragment.FindFragment;
import com.example.doan.fragment.HomeFragment;
import com.example.doan.view.VideoAdapter;
import com.example.doan.view.VideoListActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


import java.util.ArrayList;









public class MainActivity extends AppCompatActivity  {


    private EditText etData;
    private Button btnSend;


    //    RecyclerView rvListC;
    BottomNavigationView mnBottom;
    ArrayList<VideoListActivity> lstUser;
    VideoAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mnBottom = findViewById(R.id.navMenu);

        mnBottom.setOnItemSelectedListener(getListener());


//        LoadData();

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("Đồ Án");
//        actionBar.setDisplayHomeAsUpEnabled(true);
//

    }

    @NonNull
    private NavigationBarView.OnItemSelectedListener getListener() {
        return new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuHome:
                        loadFragment(new HomeFragment());
                        return true;
                    case R.id.menuFind:
                        Fragment FindFragment = new Fragment();
                        loadFragment(new FindFragment());
                        return true;
                    case R.id.menuLiked:
                        loadFragment(new LikedFragment());
                        return true;
                    case R.id.menuSetting:
                        loadFragment(new SettingFragment());
                        return true;
                }
                return true;
            }
        };
    }
    void loadFragment(Fragment fmNew) {
        FragmentTransaction fmTran = getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.main_fragment, fmNew);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }

    //menu trên
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInf = getMenuInflater();
        menuInf.inflate(R.menu.menuoption, menu);
        return true;
    }
}




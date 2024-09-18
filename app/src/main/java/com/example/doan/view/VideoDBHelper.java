package com.example.doan.view;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class VideoDBHelper
{
    String dbName = "data.db";
    Context context;
    static SQLiteDatabase db;


    public VideoDBHelper(Context context){
        this.context = context;
    }


    public  SQLiteDatabase openDB(){
        return  context.openOrCreateDatabase(dbName,Context.MODE_PRIVATE,null);
    }
    public int countVideo(){
        String sql = "SELECT * FROM tblVIDEO";
        db = openDB();
        Cursor cursor = db.rawQuery(sql,null);
        int count = cursor.getCount();
        return count;
    }
    public  void copyDatabase() {
        File dbFile = context.getDatabasePath(dbName);
         if (!dbFile.exists()){
            try {
                InputStream is = context.getAssets().open(dbName);
                OutputStream os = new FileOutputStream(dbFile);
                byte[] buffer = new byte[1024];
                while (is.read(buffer) > 0) {
                    os.write(buffer);
                }
                os.flush();
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public ArrayList<VideoList> getVideos() {
            ArrayList<VideoList> tmp = new ArrayList<>();
                db = openDB();
                String sql = "SELECT * FROM tblVIDEO";
                Cursor cursor = db.rawQuery(sql, null);
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(0);
                    String vname = cursor.getString(1);
                    String url = cursor.getString(4);
                    String des1 = cursor.getString(2);
                    String des2 = cursor.getString(3);
                    String ytid = cursor.getString(5);
                    String description = cursor.getString(6);
                    int favorite = cursor.getInt(7);
                    int viewed = cursor.getInt(8);
                    VideoList videoList = new VideoList(id, vname, des1, des2,url, ytid, description,favorite,viewed);
                    tmp.add(videoList);
                }
                db.close();
        return tmp;
    }
    public void favorite(int id){
        String sql = "UPDATE tblVIDEO SET Favorite = 1 WHERE vID="+ id;
        db = openDB();
        db.execSQL(sql);
        db.close();
    }
    public void unfavorite(int id){
        String sql = "UPDATE tblVIDEO SET Favorite = 0 WHERE vID="+ id;
        db = openDB();
        db.execSQL(sql);
        db.close();
    }
    public ArrayList<VideoList> getFAV() {
        ArrayList<VideoList> tmp = new ArrayList<>();

        String sql = "SELECT * FROM tblVIDEO WHERE Favorite = 1";
        db = openDB();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String vname = cursor.getString(1);
            String url = cursor.getString(4);
            String des1 = cursor.getString(2);
            String des2 = cursor.getString(3);
            String ytid = cursor.getString(5);
            String description = cursor.getString(6);
            int favorite = cursor.getInt(7);
            int viewed = cursor.getInt(8);
            VideoList videoList = new VideoList(id, vname, des1, des2,url, ytid, description,favorite,viewed);
            tmp.add(videoList);
        }
        db.close();
        return tmp;
    }

    public ArrayList<VideoList> getVideoWhereName(String text) {
        ArrayList<VideoList> tmp = new ArrayList<>();
        String sql = "SELECT * FROM tblVIDEO WHERE vNAME LIKE " + "'"+ "%" + text + "%" + "'";
        db = openDB();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String vname = cursor.getString(1);
            String url = cursor.getString(4);
            String des1 = cursor.getString(2);
            String des2 = cursor.getString(3);
            String ytid = cursor.getString(5);
            String description = cursor.getString(6);
            int favorite = cursor.getInt(7);
            int viewed = cursor.getInt(8);
            VideoList videoList = new VideoList(id, vname, des1, des2,url, ytid, description,favorite,viewed);
            tmp.add(videoList);
        }
        db.close();
        return tmp;
    }
}

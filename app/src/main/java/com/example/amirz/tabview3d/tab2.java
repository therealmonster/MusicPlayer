package com.example.amirz.tabview3d;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by amirz on 2/12/2018.
 */

public class tab2 extends Fragment {
    View b;
    private ArrayList<Album> albumList = new ArrayList<Album>();
    Context context;
    RecyclerView recyclerView;
    AlbumAdapter albumAdapter;
    MediaPlayer mediaPlayer;


    public tab2() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        b = inflater.inflate(R.layout.activity_tab2, container, false);
        recyclerView = (RecyclerView)b.findViewById(R.id.recyclerview_Album);
        albumAdapter = new AlbumAdapter(context,albumList);
        recyclerView.setAdapter(albumAdapter);
        albumAdapter = new AlbumAdapter(getContext(),albumList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        DividerItemDecoration dividerItemDecoration =new DividerItemDecoration(recyclerView.getContext(),linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        if(checkUserPermission()){
            getAlbumsLists();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 123);
        }


        return b;
    }



    private boolean checkUserPermission(){
        return ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 123:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    getAlbumsLists();

                }else{
                    Toast.makeText(getContext(), "Permission Denied", Toast.LENGTH_LONG).show();

                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        }

    }

    public void getAlbumsLists() {
        String where = null;
     //    String selection = MediaStore.Audio.Media.IS_MUSIC+"!=0";
        final Uri uri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
        final String _id = MediaStore.Audio.Albums._ID;
        final String album_name = MediaStore.Audio.Albums.ALBUM;
        final String artist = MediaStore.Audio.Albums.ARTIST;
       // final String albumart = MediaStore.Audio.Albums.ALBUM_ART;
        final String tracks = MediaStore.Audio.Albums.NUMBER_OF_SONGS;
        String[] selectionArgs = null;
        String sortOrder = MediaStore.Audio.Albums.ALBUM + " ASC";

        long value = 0;

        final String[] columns = {_id, album_name, artist, tracks};
        Cursor cursor = getContext().getContentResolver().query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, columns, where ,selectionArgs, null);


        if (cursor != null && cursor.moveToFirst()) {

            do {

                long id = cursor.getLong(cursor.getColumnIndex(_id));


               /*  if(!cursor.isNull(cursor.getColumnIndex(_id))){
                    value =cursor.getColumnIndex(_id);

                } */
                String name = cursor.getString(cursor.getColumnIndex(album_name));
                String artist2 = cursor.getString(cursor.getColumnIndex(artist));
             //   String artPath = cursor.getString(cursor.getColumnIndex(albumart));
              //  Bitmap art = BitmapFactory.decodeFile(artPath);
                int nr = Integer.parseInt(cursor.getString(cursor.getColumnIndex(tracks)));
                Album  s = new Album(id,name,artist2,nr);

                albumList.add(s);
                for(int i =0; i <albumList.size();i++){
                    Log.d("meaning",name);
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
        albumAdapter = new AlbumAdapter(getContext(),albumList);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

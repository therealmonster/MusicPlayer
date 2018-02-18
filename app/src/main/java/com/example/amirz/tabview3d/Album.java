package com.example.amirz.tabview3d;

import android.graphics.Bitmap;

/**
 * Created by amirz on 2/17/2018.
 */

public class Album {

    private long id;
    private String albumName;
    private String artistName;
    private int num_of_songs;
    //private Bitmap albumImg;

    public Album(long id, String albumName, String artistName,  int num_of_songs) {
       //  this.albumImg = albumImg;
        this.id = id;
        this.albumName = albumName;
        this.artistName = artistName;
        this.num_of_songs = num_of_songs;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
   /* public void setAlbumImg(Bitmap albumImg) {
       // this.albumImg = albumImg;
    } */
    public void setNum_of_songs(int num_of_songs) {
        this.num_of_songs = num_of_songs;
    }

    public long getID(){
        return id;
    }
    public String getAlbumName(){
        return albumName;
    }
    public String getArtistName() {
        return artistName;
    }
    /*public Bitmap getAlbumImg() {
      return albumImg;
    } */
    public int getNum_of_songs() {
        return num_of_songs;
    }

}

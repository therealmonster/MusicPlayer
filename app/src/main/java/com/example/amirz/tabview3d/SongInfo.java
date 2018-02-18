package com.example.amirz.tabview3d;

/**
 * Created by amirz on 2/13/2018.
 */

public class SongInfo {
    private String Songname;
    private String Artistname;
    private String SongUrl;
     private String AlbumName;

    public SongInfo() {
    }

    public SongInfo(String songname, String artistname,  String albumName,String songUrl) {
        Songname = songname;
        Artistname = artistname;
        SongUrl = songUrl;
        AlbumName =albumName;



    }

    public String getSongname() {
        return Songname;
    }

    public void setSongname(String songname) {
        Songname = songname;
    }

    public String getArtistname() {
        return Artistname;
    }

    public void setArtistname(String artistname) {
        Artistname = artistname;
    }

    public String getSongUrl() {
        return SongUrl;
    }

    public void setSongUrl(String songUrl) {
        SongUrl = songUrl;
    }



    public String getAlbumName(){
        return AlbumName;
    }

}

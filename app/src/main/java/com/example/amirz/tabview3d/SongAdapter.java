package com.example.amirz.tabview3d;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amirz on 2/13/2018.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {

    private ArrayList<SongInfo> _songs = new ArrayList<SongInfo>();
    private Context context;
    private OnItemClickListener mOnItemClickListener;

    public SongAdapter(Context context, ArrayList<SongInfo> songs) {
        this.context = context;
        this._songs = songs;
    }
   public SongAdapter(Context context){
        this.context =context;
   }


    public interface OnItemClickListener {
        void onItemClick(Button b , View view, SongInfo obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }


    @Override
    public SongHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View myView = LayoutInflater.from(context).inflate(R.layout.item_songs,viewGroup,false);
        return new SongHolder(myView);
    }

    @Override
    public void onBindViewHolder(final SongHolder songHolder, final int i) {
        final SongInfo s = _songs.get(i);
        songHolder.songName.setText(_songs.get(i).getSongname());
        songHolder.songArtist.setText(_songs.get(i).getArtistname());
        //set the text  for Album , just for trying purpose,
      //   songHolder.albumName.setText((_songs.get(i).getAlbumName()));

        songHolder.actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(songHolder.actionButton,v, s, i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return _songs.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        TextView songName, songArtist;
        Button actionButton;
        // just for Album checking
        //  TextView albumName;
        public SongHolder(View itemView) {
            super(itemView);
            songName = (TextView) itemView.findViewById(R.id.tvSongName);
            songArtist = (TextView) itemView.findViewById(R.id.tvArtistName);
            actionButton = (Button) itemView.findViewById(R.id.btnPlay);
          //    albumName =(TextView)itemView.findViewById(R.id.albumName);

        }
    }

}
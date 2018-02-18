package com.example.amirz.tabview3d;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by amirz on 2/17/2018.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {
        private ArrayList<Album> _ablums =new ArrayList<Album>();
        private Context context;

    public AlbumAdapter(Context context,ArrayList<Album> albums){
        this.context = context;
        this._ablums =albums;

    }
    public  AlbumAdapter(Context context){
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View albumView = LayoutInflater.from(context).inflate(R.layout.item_album,parent,false);
        return new MyViewHolder(albumView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
                final Album s = _ablums.get(position);
                holder.albumName.setText(_ablums.get(position).getAlbumName());
                holder.albumId.setText((int) _ablums.get(position).getID());


    }

    @Override
    public int getItemCount() {
        return _ablums.size();

    }

    public  static  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView albumId;
        TextView albumName;

        public MyViewHolder(View itemView) {
            super(itemView);
            albumId =(TextView)itemView.findViewById(R.id.albumId);
            albumName =(TextView)itemView.findViewById(R.id.albumName);

        }
    }
}

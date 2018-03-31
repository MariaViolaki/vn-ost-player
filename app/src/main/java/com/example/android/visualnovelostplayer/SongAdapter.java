package com.example.android.visualnovelostplayer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Maria on 3/24/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // The correct song from the array is selected
        Song currentSong = getItem(position);
        View listItem = convertView;
        // If there is no view to be reused, a new song list item is inflated
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView songIcon = listItem.findViewById(R.id.song_icon);
        TextView songTitle = listItem.findViewById(R.id.song_title);
        TextView songComposer = listItem.findViewById(R.id.song_composer);

        // The correct song information are added to the list item
        songIcon.setImageResource(currentSong.getImageResourceId());
        songTitle.setText(currentSong.getSongTitle());
        songComposer.setText(currentSong.getSongComposer());

        return listItem;
    }
}
package com.example.android.visualnovelostplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Change to AboutActivity when the info button is clicked
        ImageButton about = findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        // Create a playlist of Original Soundtracks
        final ArrayList<com.example.android.visualnovelostplayer.Song> songs = new ArrayList<>();
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_one), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_two), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_three), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_four), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_five), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_six), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_seven), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_eight), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_nine), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_ten), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_eleven), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_twelve), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_thirteen), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_fourteen), getString(R.string.composer_name)));
        songs.add(new Song(R.drawable.song_icon, getString(R.string.song_fifteen), getString(R.string.composer_name)));

        // Attach the custom adapter to the ListView
        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        // Change to NowPlayingActivity when any list item is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, NowPlayingActivity.class);
                startActivity(intent);
            }
        });
    }
}

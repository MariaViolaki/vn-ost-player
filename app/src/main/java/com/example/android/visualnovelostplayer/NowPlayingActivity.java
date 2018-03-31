package com.example.android.visualnovelostplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        // Change to MainActivity when the back button is clicked
        ImageButton nowPlayingBack = findViewById(R.id.now_playing_back);
        nowPlayingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NowPlayingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Find music buttons on XML
        final ImageButton shuffleButton = findViewById(R.id.shuffle_button);
        final ImageButton playButton = findViewById(R.id.play_button);
        final ImageButton repeatButton = findViewById(R.id.repeat_button);

        // Set tags to buttons to change their drawables
        shuffleButton.setTag(R.drawable.shuffle_off);
        playButton.setTag(R.drawable.play);
        repeatButton.setTag(R.drawable.repeat_off);

        // Change shuffle button drawable on click
        shuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getDrawableId(shuffleButton) == R.drawable.shuffle_off) {
                    shuffleOn();
                    // Change repeat state to on when shuffle is on
                    if (getDrawableId(repeatButton) == R.drawable.repeat_current) {
                        repeatOn();
                    }
                } else {
                    shuffleOff();
                    Toast.makeText(NowPlayingActivity.this, R.string.shuffle_off, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Change play button drawable on click
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getDrawableId(playButton) == R.drawable.play) {
                    pause();
                } else {
                    play();
                }
            }
        });

        // Change repeat button drawable on click
        repeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getDrawableId(repeatButton) == R.drawable.repeat_off) {
                    repeatOn();
                    Toast.makeText(NowPlayingActivity.this, R.string.repeat_all, Toast.LENGTH_SHORT).show();
                } else if (getDrawableId(repeatButton) == R.drawable.repeat) {
                    repeatCurrent();
                    // Change shuffle state to off when repeating current song
                    shuffleOff();
                } else {
                    repeatOff();
                }
            }
        });

    }

    // Returns the (drawable) tag of an ImageButton
    private int getDrawableId(ImageButton imageButton) {
        return (int) imageButton.getTag();
    }

    /**
     * The following functions define the behavior of the buttons in the music player
     */
    private void play() {
        ImageButton playButton = findViewById(R.id.play_button);
        playButton.setTag(R.drawable.play);
        playButton.setImageResource(R.drawable.play);
    }

    private void pause() {
        ImageButton playButton = findViewById(R.id.play_button);
        playButton.setTag(R.drawable.pause);
        playButton.setImageResource(R.drawable.pause);
    }

    private void repeatOff() {
        ImageButton playButton = findViewById(R.id.repeat_button);
        playButton.setTag(R.drawable.repeat_off);
        playButton.setImageResource(R.drawable.repeat_off);
        Toast.makeText(this, R.string.repeat_off, Toast.LENGTH_SHORT).show();
    }

    private void repeatOn() {
        ImageButton playButton = findViewById(R.id.repeat_button);
        playButton.setTag(R.drawable.repeat);
        playButton.setImageResource(R.drawable.repeat);
    }

    private void repeatCurrent() {
        ImageButton playButton = findViewById(R.id.repeat_button);
        playButton.setTag(R.drawable.repeat_current);
        playButton.setImageResource(R.drawable.repeat_current);
        Toast.makeText(this, R.string.repeat_current, Toast.LENGTH_SHORT).show();
    }

    private void shuffleOff() {
        ImageButton playButton = findViewById(R.id.shuffle_button);
        playButton.setTag(R.drawable.shuffle_off);
        playButton.setImageResource(R.drawable.shuffle_off);
    }

    private void shuffleOn() {
        ImageButton playButton = findViewById(R.id.shuffle_button);
        playButton.setTag(R.drawable.shuffle);
        playButton.setImageResource(R.drawable.shuffle);
        Toast.makeText(this, R.string.shuffle_on, Toast.LENGTH_SHORT).show();
    }
}
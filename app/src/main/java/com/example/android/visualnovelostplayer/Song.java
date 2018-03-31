package com.example.android.visualnovelostplayer;

/**
 * Created by Maria on 3/23/2018.
 */

public class Song {
    private int mImageResourceId;
    private String mTitle;
    private String mComposer;

    // Constructor for a song list item
    public Song(int imageResourceId, String songTitle, String songComposer) {
        mImageResourceId = imageResourceId;
        mTitle = songTitle;
        mComposer = songComposer;
    }

    public int getImageResourceId() {return mImageResourceId;}
    public String getSongTitle() {return mTitle;}
    public String getSongComposer() {return mComposer;}
}
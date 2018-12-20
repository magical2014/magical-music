// IMediaPlaybackService.aidl
package com.magical.music;

// Declare any non-default types here with import statements

interface IMediaPlaybackService {
    void openFile(String path);
    boolean isPlaying();
    void play();
    void pause();
    void stop();
    void next();
    void prev();
}

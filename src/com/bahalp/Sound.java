package com.bahalp;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Sound  {
    private  MediaPlayer mediaPlayer;
    private Media media;

    public Sound(String source) {

        try {
            this.media = new Media(source);
            this.mediaPlayer = new MediaPlayer(media);
            setPlayerConfig();
        } catch (Exception a) {
            a.printStackTrace();
        }

    }


    public void play(){

        mediaPlayer.play();
    }

    private void setPlayerConfig() {
        mediaPlayer.setOnReady(new Runnable(){
            public void run() {
                mediaPlayer.setStartTime(Duration.ZERO);
                mediaPlayer.setStopTime(media.getDuration().subtract(Duration.seconds(1)));
            }
        });
        mediaPlayer.setOnEndOfMedia(new Runnable(){
            public void run() {
                mediaPlayer = new MediaPlayer(media);
                setPlayerConfig();
                mediaPlayer.play();
            }
        });
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }


}

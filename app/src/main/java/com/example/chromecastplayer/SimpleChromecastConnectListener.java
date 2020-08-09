package com.example.chromecastplayer;

import android.util.Log;

import com.pierfrancescosoffritti.androidyoutubeplayer.chromecast.chromecastsender.ChromecastYouTubePlayerContext;
import com.pierfrancescosoffritti.androidyoutubeplayer.chromecast.chromecastsender.io.infrastructure.ChromecastConnectionListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;

public class SimpleChromecastConnectListener implements ChromecastConnectionListener {

    @Override
    public void onChromecastConnecting() {
        Log.d(getClass().getSimpleName(), "onChromecastConnecting");
    }

    @Override
    public void onChromecastConnected(ChromecastYouTubePlayerContext chromecastYouTubePlayerContext) {
        Log.d(getClass().getSimpleName(), "onChromecastConnected");
        initializeCastPlayer(chromecastYouTubePlayerContext);
    }

    @Override
    public void onChromecastDisconnected() {
        Log.d(getClass().getSimpleName(), "onChromecastDisconnected");
    }

    private void initializeCastPlayer(ChromecastYouTubePlayerContext chromecastYouTubePlayerContext) {
        chromecastYouTubePlayerContext.initialize(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo("", 0f);
            }
        });

    }
}

package com.example.chromecastplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.mediarouter.app.MediaRouteButton;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.pierfrancescosoffritti.androidyoutubeplayer.chromecast.chromecastsender.ChromecastYouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.chromecast.chromecastsender.ChromecastYouTubePlayerContext;
import com.pierfrancescosoffritti.androidyoutubeplayer.chromecast.chromecastsender.utils.PlayServicesUtils;

public class MainActivity extends AppCompatActivity {

    private int googlePlayServicesAvailabilityRequestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaRouteButton mediaRouteButton = findViewById(R.id.media_route_button);
        CastButtonFactory.setUpMediaRouteButton(this, mediaRouteButton);

        PlayServicesUtils.checkGooglePlayServicesAvailability(this, googlePlayServicesAvailabilityRequestCode, this::initChromecast);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == googlePlayServicesAvailabilityRequestCode) {
            PlayServicesUtils.checkGooglePlayServicesAvailability(
                    this,
                    googlePlayServicesAvailabilityRequestCode,
                    this::initChromecast
            );
        }
    }

    private void initChromecast() {
        new ChromecastYouTubePlayerContext(
                CastContext.getSharedInstance(this).getSessionManager(),
                new SimpleChromecastConnectListener()
        );
    }
}
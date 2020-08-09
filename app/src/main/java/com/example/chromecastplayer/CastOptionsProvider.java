package com.example.chromecastplayer;

import android.content.Context;

//import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.OptionsProvider;
import com.google.android.gms.cast.framework.SessionProvider;

import java.util.List;

public final class CastOptionsProvider implements OptionsProvider {
    public CastOptions getCastOptions(Context appContext) {
        String receiverId = "";

        return new CastOptions.Builder()
                .setReceiverApplicationId(receiverId)
                .build();
    }

    public List<SessionProvider> getAdditionalSessionProviders(Context context) {
        return null;
    }
}

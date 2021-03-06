package com.magical.music;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.magical.music.service.MediaPlaybackService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG= "MainActivity";
    private IMediaPlaybackService mService = null;
    private final ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mService = IMediaPlaybackService.Stub.asInterface(iBinder);
            Log.i(TAG, "onServiceConnected()");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mService = null;
            Log.i(TAG, "onServiceDisconnected()");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate()");
        bindService();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
        unbindService();
    }

    private void bindService()
    {
        Intent intent = new Intent();
        intent.setClass(this, MediaPlaybackService.class);
        startService(intent);
        bindService(intent, mConnection,0);
    }
    private void unbindService()
    {
        unbindService(mConnection);
    }
}

package com.magical.music.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.magical.music.IMediaPlaybackService;

import java.lang.ref.SoftReference;

public class MediaPlaybackService extends Service {
    private static final String TAG = "MediaPlaybackService";
    private final MediaPlaybackService.ServiceStub mService = new ServiceStub(this);
    public MediaPlaybackService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i(TAG, "onBind()");
        return mService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i(TAG, "onLowMemory()");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG, "onRebind()");
        super.onRebind(intent);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.i(TAG, "onTaskRemoved()");
        super.onTaskRemoved(rootIntent);
    }

    private void openFile(String path)
    {

    }
    private boolean isPlaying()
    {
        return  false;
    }

    private void play()
    {

    }
    private void pause()
    {

    }
    private void stop()
    {

    }
    private void next()
    {

    }
    private void prev()
    {

    }
    private static class ServiceStub extends  IMediaPlaybackService.Stub{
        private SoftReference<MediaPlaybackService> services;
        public ServiceStub(MediaPlaybackService service){
            services = new SoftReference<>(service);
        }
        @Override
        public void openFile(String path) throws RemoteException {
            services.get().openFile(path);
        }

        @Override
        public boolean isPlaying() throws RemoteException {
            return services.get().isPlaying();
        }

        @Override
        public void play() throws RemoteException {
            services.get().play();
        }

        @Override
        public void pause() throws RemoteException {
            services.get().pause();
        }

        @Override
        public void stop() throws RemoteException {
            services.get().stop();
        }

        @Override
        public void next() throws RemoteException {
            services.get().next();
        }

        @Override
        public void prev() throws RemoteException {
            services.get().prev();
        }
    }
}

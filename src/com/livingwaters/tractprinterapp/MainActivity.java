package com.livingwaters.tractprinterapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.util.Log;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;

public class MainActivity extends Activity {
	private SoundPool soundPool;
	  private int soundID;
	  boolean loaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  
     // Set the hardware buttons to control the music
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        // Load the sound
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
          @Override
          public void onLoadComplete(SoundPool soundPool, int sampleId,
              int status) {
            loaded = true;
          }
        });
        soundID = soundPool.load(this, R.raw.printer, 1);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    /** Called when the user clicks the Send button */
    public void printTract(View view) {
        // Do something in response to button
    	// Getting the user sound settings
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        float actualVolume = (float) audioManager
            .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
            .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
        // Is the sound loaded already?
        if (loaded) {
          soundPool.play(soundID, volume, volume, 1, 0, 1f);
          Log.e("Test", "Played sound");
        }
     // Get instance of Vibrator from current Context
        //Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        // Vibrate for 300 milliseconds
       // mVibrator.vibrate(300);
        // Go to 180 Tract screen
    	Intent intent = new Intent(this, PrintTractActivity.class);
    	startActivity(intent);
    }
}

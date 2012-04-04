package com.kis;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Bye extends Activity implements OnClickListener,OnLongClickListener, OnCompletionListener {
	MediaPlayer playerl,players;
	ImageView image;
	View views;
	CharSequence sclick="Love you too honey";
	CharSequence lclick="Gonna miss your kisses too";
	CharSequence mpstart="done";
	CharSequence mpstop="done";
	CharSequence started="started";
	CharSequence resumed="resumed";
	CharSequence stopped="stopped";
	CharSequence paused="paused";
	CharSequence istart="intent started";
	CharSequence istop="intent stopped";
	Button vroom;
	
    private void showMessage(CharSequence text) {
    	Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();    	
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bye);
        players = MediaPlayer.create(this, R.raw.kiss_s_1);
        playerl = MediaPlayer.create(this, R.raw.kiss_l);
        image = (ImageView)findViewById(R.id.img);
        views = (View)findViewById(R.id.img);
        image.setImageResource(R.drawable.sweet_kisses);
        views.setOnClickListener(this);
        views.setOnLongClickListener(this); 
      }
	public void onClick(View v) {
		showMessage(sclick);
		finish();	
	}	
public boolean onLongClick(View v1) {
	showMessage(lclick);
	finish();		
		return true;
	}	
	public void onCompletion(MediaPlayer mp) {		
	}
}
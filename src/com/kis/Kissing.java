package com.kis;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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

public class Kissing extends Activity implements OnClickListener,OnLongClickListener, OnCompletionListener {
	MediaPlayer playerl,players;
	ImageView image;
	View views;
	CharSequence sclick="short click";
	CharSequence lclick="long click";
	CharSequence mpstart="mpstart";
	CharSequence mpstop="mpstop";
	CharSequence started="started";
	CharSequence resumed="resumed";
	CharSequence stopped="stopped";
	CharSequence paused="paused";
	CharSequence istart="intent started";
	CharSequence istop="intent stopped";
	CharSequence defaultt="defaultt";
	
	CharSequence entry="Kiss me Honey";
	CharSequence kiss2="Oh thats good..Kiss me harder";
	CharSequence kiss1="Yeah that`s the way";
	CharSequence kiss3="A longer kiss once more honey";
	CharSequence kiss4="U rock";
	CharSequence kiss5="kiss again baby";
	//CharSequence kiss0="Go on...i know u like me";
	CharSequence kiss="i guess we may stop";
	CharSequence about="Am an app dedicated to ones who feels their device is spl.\nGo Kiss it....Give it a hug too\nIt deserves your Love\nENJOY";
	
	int i=1;	
    private void showMessage(CharSequence text) {
    	Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();    	
    }
    private void showMessagel(CharSequence text) {
    	Context context = getApplicationContext();
		int duration = Toast.LENGTH_LONG;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();    	
    }
    private void kissmsg()
    {
    		if(i==1) showMessage(kiss1);
    		if(i==3) showMessage(kiss2);
    		if(i==5) showMessage(kiss3);
    		if(i==7) showMessage(kiss4);
    		if(i==9) showMessage(kiss5);
    		i++;
    		i=i%10;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        players = MediaPlayer.create(this, R.raw.kiss_s_1);
        playerl = MediaPlayer.create(this, R.raw.kiss_l);
        image = (ImageView)findViewById(R.id.image);
        views = (View)findViewById(R.id.View01);
        showMessage(entry);
        views.setOnClickListener(this);
        views.setOnLongClickListener(this);
   }
     public void onResume() {
    	super.onResume();
    	// showMessage(resumed);
           setChoice(0);
    }
    public void onPause() {
    	super.onPause();
    	//showMessage(paused);
    	players.release();
    	players = null;
    	playerl.release();
    	playerl = null;
    }
    public void setChoice(int choice) {	
    		players.reset();
    		playerl.reset();
    	switch(choice) {
    		case R.id.exitt:
    					Intent i = new Intent(this, Bye.class);
        			startActivity(i);
        			finish();
        	    			break;
    		case R.id.Aboutme:
    			showMessagel(about);
    		default:
    			//showMessage(defaultt);
    		
    			playerl = MediaPlayer.create(this, R.raw.kiss_l);
				players = MediaPlayer.create(this, R.raw.kiss_s_1);
    			break;
    	}
    	players.setLooping(false);
    	players.setOnCompletionListener(this);
    	playerl.setLooping(false);
    	playerl.setOnCompletionListener(this);
    }
//	showMessagel(about);
	//Intent j = new Intent(this, Aboutme.class);
	//startActivity(j);
		//break;
    public boolean onCreateOptionsMenu(Menu menu) {	
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.options_menu, menu);
    	return true;
    }
	public boolean onOptionsItemSelected(MenuItem item) {
    	setChoice(item.getItemId());
    	return true;
	}
	public void onClick(View v) {	
		//showMessage(sclick);
		kissmsg();
		players.start();
		image.setImageResource(R.drawable.kiss_s_s);
		//players = MediaPlayer.create(this, R.raw.kiss_s_1);
	}
public boolean onLongClick(View v1) {
	//showMessage(lclick);
	kissmsg();
	playerl.start();
	image.setImageResource(R.drawable.im2);
	//playerl = MediaPlayer.create(this, R.raw.kiss_l);
		return true;
	}
	public void onCompletion(MediaPlayer mp) {	
		// showMessage(mpstop);
		 
		image.setImageResource(R.drawable.black);
		//mp.reset();
	}
	
}
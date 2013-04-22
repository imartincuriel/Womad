package com.example.womad;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        ImageView programa=(ImageView)findViewById(R.id.imageView2);
        programa.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent= new Intent();
				intent.setClass(getApplicationContext(), ProgramaActivity.class);
				startActivity(intent);
			}
		});
        
        ImageView callejero=(ImageView)findViewById(R.id.imageView4);
        callejero.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent= new Intent();
				intent.setClass(getApplicationContext(), CallejeroActivity.class);
				startActivity(intent);
			}
		});
        
        ImageView artistas=(ImageView)findViewById(R.id.imageView3);
        artistas.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent= new Intent();
				intent.setClass(getApplicationContext(), ArtistasActivity.class);
				startActivity(intent);
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

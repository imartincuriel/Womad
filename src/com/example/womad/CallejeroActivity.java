package com.example.womad;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class CallejeroActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_callejero);
		
		ImageView vf = (ImageView) findViewById(R.id.imageView1);
        vf.setAnimation(AnimationUtils.loadAnimation(this.getApplicationContext(), R.anim.slide_left));
	}
}

package com.example.multithreading;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Handler hand = new Handler();
	Button clickme,w,l;
	TextView timer;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		timer = (TextView) findViewById(R.id.timer);
		clickme = (Button) findViewById(R.id.clickme);
		w = (Button) findViewById(R.id.won);
		l = (Button) findViewById(R.id.lose);
		hand.postDelayed(run, 1000);
		hand.postDelayed(runn, 1000);
		
		clickme.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					
				if(Integer.parseInt(timer.getText().toString())==5){
					w.setVisibility(0);
				}
				else{
					l.setVisibility(0);
				}
			}
		});
		
		
	}

	Runnable run = new Runnable() {
		@Override
		public void run() {
			updateTime();
		}
	};

	public void updateTime() {
		timer.setText("" + (Integer.parseInt(timer.getText().toString()) - 1));
		if (Integer.parseInt(timer.getText().toString()) == 0) {
			clickme.setVisibility(0);
			visible();
		} else {
			hand.postDelayed(run, 100);
		}
	}
	
	Runnable runn = new Runnable() {
		@Override
		public void run() {
			visible();
		}

		
	};
	
	
	public void visible() {
		timer.setText("0" + (Integer.parseInt(timer.getText().toString()) + 1));
		if (Integer.parseInt(timer.getText().toString()) == 120) {
			clickme.setVisibility(0);
			updateTime();
		} else {
			hand.postDelayed(runn, 100);
			
		}
	}
	
	
}

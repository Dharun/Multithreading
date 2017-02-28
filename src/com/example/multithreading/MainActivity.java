package com.example.multithreading;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Handler hand = new Handler();
	Button clickme;
	TextView timer;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		timer = (TextView) findViewById(R.id.timer);
		clickme = (Button) findViewById(R.id.clickme);
		hand.postDelayed(run, 1000);
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
		} else {
			hand.postDelayed(run, 1000);
		}
	}
}

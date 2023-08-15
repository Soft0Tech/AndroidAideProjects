package com.mycompany.mcal;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.view.View.*;
import android.content.*;

public class MainActivity extends Activity 
{
	Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		Toast.makeText(this,"This is toast",Toast.LENGTH_LONG);

		btn = findViewById(R.id.mainButton);
		
		btn.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View v){
				Intent intr=new Intent(MainActivity.this,SecondActivity.class);
				startActivity(intr);
			}
		});
    }
	
	public void showToast(View v){
		Toast.makeText(this,"This is toast",Toast.LENGTH_LONG).show();
		
	}
	
	
	//   https://shyamkumarkc.blogspot.com/2016/11/how-to-change-android-app-icon.html?m=1
 
}

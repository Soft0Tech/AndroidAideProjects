package com.mycompany.mTools;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.view.View.*;
import android.content.*;
import android.text.format.*;

public class MainActivity extends Activity 
{
	Button btnCalculator,btnShare;
	long backPressedTime;
	Toast backToast;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		

		btnCalculator = findViewById(R.id.calculator);
		btnShare=findViewById(R.id.btnShare);
		
		btnCalculator.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View v){
				Intent intr=new Intent(MainActivity.this,CalculatorActivity.class);
				startActivity(intr);
				//finish();
			}
		});
		
		btnShare.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View v){
					onShareButtonClick(v);
				}
		});
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater men= getMenuInflater();
		men.inflate(R.layout.main_menu,menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
	  switch (item.getItemId())
	  {
		  case R.id.mainMenuHome:
		  {
			  Toast.makeText(this,"Home clicked !",100).show();
			  return true;
		  }
		  case R.id.mainMenuAbout:
		  {
			  Toast.makeText(this,"About clicked !",100).show();
			  return true;
		  }
		  case R.id.mainMenuExit:
		  {
			  finish();
			 
			  return true;
		  }
		  
	  }
	  return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed()
	{
		// TODO: Implement this method
		if(backPressedTime + 2000>System.currentTimeMillis()){
			backToast.cancel();
			super.onBackPressed();
			return;
		}else{
			backToast= Toast.makeText(getBaseContext(),"Press again to exit ",Toast.LENGTH_SHORT);
			backToast.show();
		}
		backPressedTime=System.currentTimeMillis();
	}



  public void toggle(View v)
  {
	  ActionBar ab = getActionBar();
	  if(ab.isShowing()){
		  ab.hide();
	  }else{
		  ab.show();
	  }
  }


  public void showToast(View v)
  {
	  Toast.makeText(this, "This is toast", Toast.LENGTH_LONG).show();
		
	}
	
	public void onShareButtonClick(View v)
    {
    	Intent intent=new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TEXT,"This is my text to send");
		startActivity(intent);
    }
	
	public void dialogShow(View v){
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Are you sure??");
		builder.setMessage("Close application");
		
		builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface p1, int p2)
				{
					finish();
					Toast.makeText(MainActivity.this,"You just close",Toast.LENGTH_LONG).show();;
				}
			});
		builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface d1,int d2){

				}
			});
			
		
		AlertDialog alrt=builder.create();
		
		alrt.show();
		
	}
	
	int nid;
	public void addNotification(View v){
		nid++;
		NotificationManager nm=(NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification.Builder nb=new Notification.Builder(this);
		nb.setContentTitle("my notification");
		nb.setContentText("You clicked !!");
		nb.setShowWhen(true);
		nb.setSmallIcon(R.drawable.ic_launcher);
		
		nm.notify(nid,nb.build());
		//nm.notify(25,nb.getNotification());
		Toast.makeText(this,"notification clicked !",100).show();
	
	}
	
	//   https://shyamkumarkc.blogspot.com/2016/11/how-to-change-android-app-icon.html?m=1
 
}

package com.mycompany.mTools;
import android.view.View.*;
import android.os.*;
import android.app.*;
import android.view.*;
import android.util.*;
import android.content.*;
import android.content.res.*;
import android.widget.*;

public class CalculatorActivity extends Activity
{
	private TextView textView;
	private double operand1=Double.NaN;
	private String operator="";
	

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculator);
		
		textView=findViewById(R.id.textView);
		setupButtons();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			View decorView = getWindow().getDecorView();
			int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
			decorView.setSystemUiVisibility(uiOptions);
		}
		setContentView(R.layout.calculator);
		textView=findViewById(R.id.textView);
		setupButtons();
	}
	
	private void setupButtons(){
		int[] buttonIds={R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,
			R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,R.id.btn0,
			R.id.btnadd,R.id.btnsub,R.id.btnmul,R.id.btndev,R.id.btndecimal};
		
		for(int id : buttonIds){
			Button btn=findViewById(id);
			btn.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
				  onButtonClick((Button) v);
				}
			});
		}
		Button equalbtn=findViewById(R.id.btnEqual);
		equalbtn.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					calculateResult();
				}
			});
		
	}
	
	
	private void onButtonClick(Button button) {
        String buttonText = button.getText().toString();
        
        if (isOperator(buttonText)) {
            setOperator(buttonText);
        }else{
			appendToInput(buttonText);
		}
		
    }

    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("×") || str.equals("÷");
    }

    private void appendToInput(String str) {
		
		Toast.makeText(this, textView.getText().toString(),Toast.LENGTH_LONG).show();
		
       if(textView.getText().toString().equals("0.0")){
		   textView.setText(str);
	   }else{
		   textView.setText(textView.getText().toString() + str);
	   }
		
    }

    private void setOperator(String op) {
		
        if (!Double.isNaN(operand1)) {
            calculateResult();
            operand1 = Double.parseDouble(textView.getText().toString());
            operator = op;
            textView.setText("");
        } else {
            operand1 = Double.parseDouble(textView.getText().toString());
            operator = op;
            textView.setText("");
        }
		
    }

    private void calculateResult() {
		//Toast.makeText(this, String.valueOf(operand1),Toast.LENGTH_LONG).show();
        if (!Double.isNaN(operand1)) {
            double operand2 = Double.parseDouble(textView.getText().toString());
            double result = 0.0;

            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "×":
                    result = operand1 * operand2;
                    break;
                case "÷":
                    result = operand1 / operand2;
                    break;
                default:
                    break;
            }

            textView.setText(String.valueOf(result));
            operand1 = result;
            operator = "";
        }
    }
 
}

package com.example.bmi;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bmi extends Activity {
	
	private EditText edithei,editwei;
	private Button bcal;	
	private TextView result;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        
        getview();
        bcal.setOnClickListener(calbmi);
    }


    private OnClickListener calbmi=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			double height=Double.parseDouble(edithei.getText().toString());//轉成數字
			double weight=Double.parseDouble(editwei.getText().toString());
			double resultc=weight/Math.pow(height, 2);
			result.setText(new Double(resultc).toString());//轉成string
		}
	};
    	
    
    private void getview() {
		// TODO Auto-generated method stub
		edithei=(EditText) findViewById(R.id.hIn);
		editwei=(EditText) findViewById(R.id.wIn);
		bcal=(Button) findViewById(R.id.bCal);
		result=(TextView) findViewById(R.id.result);
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bmi, menu);
        return true;
    }
    
}

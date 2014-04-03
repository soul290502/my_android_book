package com.example.bmi;

import java.text.DecimalFormat;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bmi extends Activity {
	
	private EditText edithei,editwei;
	private Button bcal;	
	private TextView result,result2;
	

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
			DecimalFormat nf=new DecimalFormat("0.0");
			double height=Double.parseDouble(edithei.getText().toString());//轉成數字
			double weight=Double.parseDouble(editwei.getText().toString());
			double resultc=weight/Math.pow(height, 2);
			result.setText(new Double(resultc).toString());//轉成string
			result2.setText("您的bmi : "+nf.format(resultc));
			
			openOptionDialog();
		}
		
	};
    	
	public void openOptionDialog(){
//		AlertDialog.Builder dialog=new AlertDialog.Builder(Bmi.this);//會佔記憶體的宣告方式
//		dialog.setTitle("關於此bmi計算程式");
//		dialog.setMessage("能算出您的bmi，很酷八!! 給個讚");
//		dialog.show();
		
		//匿名方式，做完會收回記憶體
		new AlertDialog.Builder(Bmi.this)
		.setTitle("關於此bmi計算程式")
		.setMessage("能算出您的bmi，很酷八!! 給個讚")
		.setPositiveButton("ok", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		})
		.setNegativeButton(R.string.home_label, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// go to url
				Uri uri = Uri.parse("http://google.com.tw/");
				Intent intent=new Intent(Intent.ACTION_VIEW,uri);
				startActivity(intent);
			}
		})
		.show();
		
		//use toast to show string temporally 
//		Toast popup=Toast.makeText(Bmi.this, "Bmi 計算機", Toast.LENGTH_SHORT);
		//this announce need a memory space
//		popup.show();
//		Toast.makeText(Bmi.this, "Bmi 計算機", Toast.LENGTH_SHORT).show();//anonymous announcement 
		
		}
    
    private void getview() {
		// TODO Auto-generated method stub
		edithei=(EditText) findViewById(R.id.hIn);
		editwei=(EditText) findViewById(R.id.wIn);
		bcal=(Button) findViewById(R.id.bCal);
		result=(TextView) findViewById(R.id.result);
		result2= (TextView) findViewById(R.id.result2);
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bmi, menu);
        return true;
    }
    
}

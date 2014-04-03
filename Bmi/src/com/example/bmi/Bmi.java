package com.example.bmi;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
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
			double height=Double.parseDouble(edithei.getText().toString());//�ন�Ʀr
			double weight=Double.parseDouble(editwei.getText().toString());
			double resultc=weight/Math.pow(height, 2);
			result.setText(new Double(resultc).toString());//�নstring
			result2.setText("�z��bmi : "+nf.format(resultc));
			
			openOptionDialog();
		}
		
	};
    	
	public void openOptionDialog(){
//		AlertDialog.Builder dialog=new AlertDialog.Builder(Bmi.this);//�|���O���骺�ŧi�覡
//		dialog.setTitle("����bmi�p��{��");
//		dialog.setMessage("���X�z��bmi�A�ܻŤK!! �����g");
//		dialog.show();
		
		//�ΦW�覡�A�����|���^�O����
		new AlertDialog.Builder(Bmi.this)
		.setTitle("����bmi�p��{��")
		.setMessage("���X�z��bmi�A�ܻŤK!! �����g")
		.setPositiveButton("ok", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		})
		.show();
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

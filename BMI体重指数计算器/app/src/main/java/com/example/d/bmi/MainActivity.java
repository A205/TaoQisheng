package com.example.d.bmi;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final EditText height=(EditText)findViewById(R.id.srh);
        final  Button myBtn=(Button)findViewById(R.id.btn);
        final EditText weight=(EditText)findViewById(R.id.srw);
        myBtn.setOnClickListener(new View.OnClickListener(){
            double bmi=0;
            public void onClick(View view){
                TextView show = (TextView) findViewById(R.id.show);
                try {
                    double h = new Double(height.getText().toString());

                    double w = new Double(weight.getText().toString());
                    if (h>250||w>250){
                        show.setText("您是超人⊙o⊙本软件只适用于地球人！");
                    }
                    bmi = w / (h * h / 10000);
                    if (bmi < 18.5) {
                        show.setText("体重过轻！");
                    } else if (bmi >= 18.5 && bmi < 24) {
                        show.setText("体重正常！");
                    } else if (bmi >= 24 && bmi < 27) {
                        show.setText("体重稍重！");
                    } else if (bmi >= 27 && bmi < 30) {
                        show.setText("轻度肥胖！");
                    } else if (bmi >= 30 && bmi < 35) {
                        show.setText("中度肥胖！");
                    } else if (bmi > 35) {
                        show.setText("重度肥胖！");
                    }

                }catch (Exception e){
                    show.setText("请输入身高体重！");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.advait.mycity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.pm.PackageManager;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class help extends AppCompatActivity {
    Button button1,button2,button3,button4,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        button1=(Button)findViewById(R.id.button17);
        button2=(Button)findViewById(R.id.button18);
        button3=(Button)findViewById(R.id.button19);
        button4=(Button)findViewById(R.id.button20);
        btn1 = (Button) findViewById(R.id.button16);

        //Performing action on button click
        button1.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                Toast.makeText(help.this,"call police",Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+94221102));//change the number
                startActivity(callIntent);
            }
        });

        button4.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+8802177));//change the number
                startActivity(callIntent);
            }

        });
        button2.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+8802177));//change the number
                startActivity(callIntent);
            }

        });
        button3.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+8802177));//change the number
                startActivity(callIntent);
            }

        });

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(help.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }

}

package com.example.advait.mycity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity{
    Button btn;
    Button btn1,btn7,btn2,btn6,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btn1=(Button) findViewById(R.id.button1);
         btn7=(Button) findViewById(R.id.button7);
         btn2=(Button) findViewById(R.id.button2);
        btn5=(Button) findViewById(R.id.button5);
        btn6=(Button) findViewById(R.id.button6);

        btn1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this, train.class);
                startActivity(myIntent);
            }
        });
        btn2.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this, bus.class);
                startActivity(myIntent);
            }
        });
        btn5.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this, places.class);
                startActivity(myIntent);
            }
        });
        btn6.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this, help.class);
                startActivity(myIntent);
            }
        });
        btn7.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this, maps.class);
                startActivity(myIntent);
            }
        });
         btn = (Button) findViewById(R.id.button8);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this,btn);
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        if(item.getTitle().equals("About us")){
                            Intent myIntent = new Intent(MainActivity.this,about.class);
                            startActivity(myIntent);
                        }
                        if(item.getTitle().equals("User")){
                            if(users.in){
                                Intent myIntent = new Intent(MainActivity.this,login.class);
                                startActivity(myIntent);
                            }
                            else{
                                Intent myIntent = new Intent(MainActivity.this,users.class);
                                startActivity(myIntent);
                            }
                        }
                        return true;
                    }
                });
                popup.show();
            }
        });
    }


}

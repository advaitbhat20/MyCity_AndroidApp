package com.example.advait.mycity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn=(Button)findViewById(R.id.button15);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                PopupMenu popup = new PopupMenu(login.this, btn);
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(login.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        if(item.getTitle().equals("About us")){
                            Intent myIntent = new Intent(login.this,about.class);
                            startActivity(myIntent);
                        }
                        if (item.getTitle().equals("Home")) {
                            users.in=true;
                            Intent myIntent = new Intent(login.this, MainActivity.class);
                            startActivity(myIntent);
                        }
                        return true;
                    }
                });
                popup.show();
            }



        });
    }
    public void logout(View v){
        users.in=false;
        Intent myIntent = new Intent(login.this,users.class);
        startActivity(myIntent);
    }
}

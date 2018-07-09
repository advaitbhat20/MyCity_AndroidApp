package com.example.advait.mycity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class users extends AppCompatActivity {
    static boolean in=false;
    EditText username,password;
    Button login,register;
    DBHandler db;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        password=(EditText) findViewById(R.id.edittext2);
        username=(EditText)findViewById((R.id.edittext1));
        login=(Button)findViewById(R.id.button11);
        register=(Button)findViewById(R.id.button12);
        db=new DBHandler(getApplicationContext());
        btn=(Button)findViewById(R.id.button14);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                PopupMenu popup = new PopupMenu(users.this, btn);
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(users.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        if(item.getTitle().equals("About us")){
                            Intent myIntent = new Intent(users.this,about.class);
                            startActivity(myIntent);
                        }
                        if (item.getTitle().equals("Home")) {
                            users.in=false;
                            Intent myIntent = new Intent(users.this, MainActivity.class);
                            startActivity(myIntent);
                        }
                        return true;
                    }
                });
                popup.show();
            }



        });
    }
                public void register(View v){
                    Toast.makeText(getApplicationContext(), "registering user", Toast.LENGTH_LONG).show();
                if(db.exists(username.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "user already registered", Toast.LENGTH_LONG).show();
                    username.setText("");
                    password.setText("");
                }
                else {
                    db.insertRecord(username.getText().toString(), password.getText().toString());
                    Toast.makeText(getApplicationContext(), "registered", Toast.LENGTH_LONG).show();
                    username.setText("");
                    password.setText("");
                }}

                public void login(View v) {

                    if (db.getRecords(username.getText().toString(), password.getText().toString())) {
                        in = true;
                        Intent myIntent = new Intent(users.this, login.class);
                        startActivity(myIntent);
                    } else {
                        Toast.makeText(getApplicationContext(), "invalid user", Toast.LENGTH_LONG).show();
                        username.setText("");
                        password.setText("");
                    }
                }

}

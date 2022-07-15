package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button sign;
    private  int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText username= findViewById(R.id.username);
        EditText password= findViewById(R.id.password);
        sign= (Button) findViewById(R.id.signup);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uname = username.getText().toString();
                String pass= password.getText().toString();

                if(count<2){
                    Intent intent= getIntent();
                    Bundle extras= intent.getExtras();
                    String user= extras.getString("USER");
                    String pwd= extras.getString("PASS");
                    if(uname.equals(user)==true&& pass.equals(pwd)==true){
                        Toast.makeText(Login.this, "success", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Login.this, "fail", Toast.LENGTH_SHORT).show();
                        count++;
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "attempts ecxeeded", Toast.LENGTH_SHORT).show();
                    sign.setEnabled(false);
                }
            }
        });
    }
}

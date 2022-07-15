package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
Button sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String regex= "^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?=.*[$%@&*=.!])"
                    + "(?=.\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        EditText username= findViewById(R.id.username);
        EditText password= findViewById(R.id.password);
        sign= (Button) findViewById(R.id.signup);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String pass= password.getText().toString();
                Matcher m= p.matcher(pass);
                if(uname.length()==0|| pass.length()==0){
                    Toast.makeText(MainActivity.this, "cant be empty", Toast.LENGTH_LONG).show();

                }
                else{
                    if(m.matches()== true){
                        Intent intent= new Intent(MainActivity.this, Login.class);
                        Bundle extras= new Bundle();
                        extras.putString("USER",uname);
                        extras.putString("PASS",pass);
                        intent.putExtras(extras);
                        startActivity(intent);
                    }
                    else{
                       Toast.makeText(getApplicationContext(), "cant be empty", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}

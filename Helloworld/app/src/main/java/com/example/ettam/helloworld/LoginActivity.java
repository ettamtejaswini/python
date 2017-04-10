package com.example.ettam.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ettam on 4/8/2017.
 */

public class LoginActivity extends Activity {

    private EditText inputemail;

    private  EditText pwd;
    private Button btn_reg;
    private Button btn_lgn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        inputemail = (EditText) findViewById(R.id.email);

        pwd = (EditText) findViewById(R.id.pwd);
        btn_reg = (Button) findViewById(R.id.register);
        btn_lgn = (Button) findViewById(R.id.Login);

        btn_lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputemail.getText().toString().trim();
                String password = pwd.getText().toString().trim();
                if(email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Please Enter All Details!",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Login Success "+email,Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regactivity = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(regactivity);
                finish();
            }
        });


    }
}

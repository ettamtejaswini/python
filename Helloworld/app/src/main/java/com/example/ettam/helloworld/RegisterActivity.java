package com.example.ettam.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private EditText inputname;
    private EditText inputemail;
    private EditText inputphone;
    private  EditText pwd;
    private Button btn_reg;
    private Button btn_lgn;
    List<NameValuePair> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inputname = (EditText) findViewById(R.id.name);
        inputemail = (EditText) findViewById(R.id.email);
        inputphone = (EditText) findViewById(R.id.phone);
        pwd = (EditText) findViewById(R.id.pwd);
        btn_reg = (Button) findViewById(R.id.register);
        btn_lgn = (Button) findViewById(R.id.login);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputname.getText().toString().trim();
                String email = inputemail.getText().toString().trim();
                String phone = inputphone.getText().toString().trim();
                String password = pwd.getText().toString().trim();
                if(name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Please Enter All Details!",Toast.LENGTH_LONG).show();
                }
                else{
                    params = new ArrayList<NameValuePair>();
                    params.add(new BasicNameValuePair("email", email));
                    params.add(new BasicNameValuePair("pwd", password));
                    params.add(new BasicNameValuePair("phone",phone));
                    params.add(new BasicNameValuePair("name",name));
                    ServerReq sr = new ServerReq();
                    JSONObject json = sr.getJSON("http://192.168.0.5:3000/api/mobsite/register",params);


                    if(json != null){
                        try{
                            String jsonstr = json.getString("response");

                           // Toast.makeText(getApplication(),jsonstr,Toast.LENGTH_LONG).show();
                            Toast.makeText(getApplicationContext(),"Registeration Success "+name,Toast.LENGTH_LONG).show();

                            Log.d("Hello", jsonstr);
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Registeration failure "+name,Toast.LENGTH_LONG).show();

                    }

                }

            }
        });

        btn_lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lgnactivity = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(lgnactivity);
                finish();
            }
        });

    }
}

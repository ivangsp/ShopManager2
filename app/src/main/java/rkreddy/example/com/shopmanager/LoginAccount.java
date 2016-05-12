package rkreddy.example.com.shopmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAccount extends AppCompatActivity {

    EditText userNametextField;
    EditText passwordTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_account);
        //initializing
        userNametextField=(EditText)findViewById(R.id.username);
        passwordTextField=(EditText)findViewById(R.id.password);


    }
    public  void loginAccount(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("users", Context.MODE_PRIVATE);
        String userName= sharedPreferences.getString("userName","");
        String password=sharedPreferences.getString("password","");

        String userNameString=userNametextField.getText().toString();
        String passwordstring=passwordTextField.getText().toString();
        if(userName.equals(userNameString) && password.equals(passwordstring)){

            Toast.makeText(this,"LoginSuccessfully",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Login Failed",Toast.LENGTH_LONG).show();
        }


    }
}

package rkreddy.example.com.shopmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {

    EditText userName;
    EditText password;
    EditText email;
    EditText phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);


        //initialize variables
        userName=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        email=(EditText)findViewById(R.id.email);
        phoneNo=(EditText)findViewById(R.id.mobile);

    }

    public void createAccount(View view){


        SharedPreferences sharedPreferences=getSharedPreferences("users", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("userName",userName.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.putString("email",email.getText().toString());
        editor.putString("phoneNo",phoneNo.getText().toString());

        editor.commit();
        Toast.makeText(CreateAccount.this, "Account created successfully", Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this,LoginAccount.class);
        startActivity(intent);
    }

    public void gobackToLogin(View view){

        Intent intent2=new Intent(this,LoginAccount.class);
        startActivity(intent2);
    }
}

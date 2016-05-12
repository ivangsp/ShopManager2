package rkreddy.example.com.shopmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Add_Products extends AppCompatActivity {
    ArrayList<String> productWt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__products);


        productWt=new ArrayList<String>();




    }
    public  void savedProducts(View view){


        SharedPreferences sharedPreferences=getSharedPreferences("products", Context.MODE_APPEND);
        SharedPreferences.Editor mEdit1 = sharedPreferences.edit();
       /* sKey is an array */
        mEdit1.putInt("size", productWt.size());

        for(int i=0;i<productWt.size();i++)
        {

            mEdit1.putString("prodWt" + i, productWt.get(i));
        }

        mEdit1.commit();

        Intent intent=new Intent(this,LoadProducts.class);
        startActivity(intent);
        Toast.makeText(this,"Data saved successfully",Toast.LENGTH_LONG).show();
    }

}

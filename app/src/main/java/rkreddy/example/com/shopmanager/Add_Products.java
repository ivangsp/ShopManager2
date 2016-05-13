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
    ArrayList<String> products;
    ArrayList<String> productPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__products);


        productWt=new ArrayList<String>();


        productWt=new ArrayList<String>();
        products=new ArrayList<String>();
        productPrice=new ArrayList<String>();

        productWt.add("30");
        productWt.add("130");
        productWt.add("100");
        productWt.add("600");


        productPrice.add("2000");
        productPrice.add("3000");
        productPrice.add("1000");
        productPrice.add("10000");

        products.add("Beans");
        products.add("sugar");
        products.add("Salt");
        products.add("coffee");


    }
    public  void savedProducts(View view){


        SharedPreferences sharedPreferences=getSharedPreferences("Items", Context.MODE_APPEND);
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

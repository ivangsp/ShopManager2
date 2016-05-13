package rkreddy.example.com.shopmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LoadProducts extends AppCompatActivity {

    ArrayList<String> items;
    ListView list;
    ArrayAdapter adapter;

    ArrayList<String> items1;
    ListView list1;
    ArrayAdapter adapter1;

    ArrayList<String> items2;
    ListView list2;
    ArrayAdapter adapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_products);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initializing variables

        items=new ArrayList<String>();
        list=(ListView)findViewById(R.id.listView);

        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,items);
        list.setAdapter(adapter);

        items1=new ArrayList<String>();
        list1=(ListView)findViewById(R.id.listView1);
        adapter1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,items1);
        list1.setAdapter(adapter1);

        items2=new ArrayList<String>();
        list2=(ListView)findViewById(R.id.listView2);

        adapter2=new ArrayAdapter(this,android.R.layout.simple_list_item_1,items2);
        list2.setAdapter(adapter2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        SharedPreferences sharedPreferences=getSharedPreferences("Items", Context.MODE_APPEND);
        int prodSize=sharedPreferences.getInt("NoOfProducts",0);

        items.clear();
        for(int i=0;i<prodSize;i++){
            items.add(sharedPreferences.getString("prodId"+i,null));

        }
        adapter.notifyDataSetChanged();

//displaying prices for commodities

        SharedPreferences sharedPreferences1=getSharedPreferences("Items", Context.MODE_APPEND);
        int prodSize1=sharedPreferences1.getInt("priceId",0);

        items1.clear();
        for(int i=0;i<prodSize1;i++){
            items1.add(sharedPreferences.getString("price"+i,null));

        }
        adapter1.notifyDataSetChanged();

        //displaying weights of products

        SharedPreferences sharedPreferences2=getSharedPreferences("Items", Context.MODE_APPEND);
        int prodSize2=sharedPreferences1.getInt("size",0);

        items2.clear();
        for(int i=0;i<prodSize2;i++){
            items2.add(sharedPreferences.getString("prodWt"+i,null)+"kg");

        }
        adapter2.notifyDataSetChanged();



    }

}

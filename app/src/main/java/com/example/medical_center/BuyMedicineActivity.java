package com.example.medical_center;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Paracetamol","","","","20"},
            {"Maxpro 20 ","","","","50"},
            {"Napa extra","","","","45"},
            {"Seclo 20","","","","30"},
            {"Alatrol 10","","","","40"},
            {"Metro","","","","20"},
            {"Vitamin d","","","","40"},
            {"Vitamin c","","","","35"},
            {"Calcium tablets","","","","55"}
    };
    private String[] package_details ={
            "Paracetamol is a commonly used medicine that can help treat pain and reduce a high temperature (fever).",
            "Maxpro Tablet is used for the short-term treatment and maintenance of inflammation of the food pipe",
            "Napa extra is a commonly used medicine that can help treat pain and reduce a high temperature (fever).",
            "Seclo 20is used for the short-term treatment and maintenance of inflammation of the food pipe",
            "Alatrol 10 is also used to relieve allergic symptoms present throughout the year",
            "Metro Tablet is used for the short-term treatment and maintenance of inflammation of the food pipe",
            "Vitamin D is used for vitamin a deficiency disorders, vitamin d deficiency and other conditions",
            "Vitamin C Tablet is used for scurvy, vitamin deficiency, bacterial infections and other conditions",
            "Calcium Tablet is used for acid indigestion, heartburn, sour stomach and other conditions"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list= new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1",packages[i][0]);
            item.put( "line2",packages[i][1]);
            item.put( "line3",packages[i][2]);
            item.put( "line4",packages[i][3]);
            item.put( "line5","Total Cost: "+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it= new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}
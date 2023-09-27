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

public class EmergencyServicesActivity extends AppCompatActivity {

    private String[][] emergency_services={
            {"Ambulance Services","","","",""},
            {"Oxygen Services","","","",""},
            {"Home care of COVID-19","","","",""},
            {"Hospitals location in\n Rajshahi ","","","",""},
            {"Emergency Telephone \nNumber and Help Line","","","",""}
    };
    private int[] images ={
            R.drawable.emergency_ambulance,
            R.drawable.oxygen,
            R.drawable.covid,
            R.drawable.hospitals_in_rajshahi,
            R.drawable.helpline
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnBack;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_services);

         lst= findViewById(R.id.listViewES);
         btnBack =findViewById(R.id.buttonESBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmergencyServicesActivity.this,HomeActivity.class));
            }
        });

        list= new ArrayList();
        for(int i=0;i<emergency_services.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1",emergency_services[i][0]);
            item.put( "line2",emergency_services[i][1]);
            item.put( "line3",emergency_services[i][2]);
            item.put( "line4",emergency_services[i][3]);
            item.put( "line5",emergency_services[i][4]);
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
                Intent it= new Intent(EmergencyServicesActivity.this,EmergencyServicesDetailsActivity.class);
                it.putExtra("text1",emergency_services[i][0]);
                it.putExtra("text2",images[i]);
                startActivity(it);
            }
        });

    }
}
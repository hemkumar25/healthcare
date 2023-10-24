package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 = {
            {"Doctor Name : Dr. John Doe", "Hospital Address : 123 Main St, Cityville", "Exp : 10 years", "Mobile No : 555-555-5555"},
            {"Doctor Name : Dr. Jane Smith", "Hospital Address : 456 Oak Ave, Townville", "Exp : 8 years", "Mobile No : 555-123-4567"},
            {"Doctor Name : Dr. James Brown", "Hospital Address : 789 Pine Rd, Villagetown", "Exp : 15 years", "Mobile No : 555-789-0123"},
            {"Doctor Name : Dr. Emily Davis", "Hospital Address : 101 Elm Blvd, Grovetown", "Exp : 12 years", "Mobile No : 555-555-1234"},
            {"Doctor Name : Dr. Michael Johnson", "Hospital Address : 202 Maple Dr, Hilltop", "Exp : 20 years", "Mobile No : 555-123-7890"}
    };
    private String[][] doctor_details2 = {
            {"Doctor Name : Dr. Mark Johnson", "Hospital Address : 789 Oak St, Cityville", "Exp : 10 years", "Mobile No : 555-555-5555"},
            {"Doctor Name : Dr. Laura Davis", "Hospital Address : 101 Pine Ave, Townville", "Exp : 8 years", "Mobile No : 555-123-4567"},
            {"Doctor Name : Dr. Emily Smith", "Hospital Address : 202 Maple Dr, Villageton", "Exp : 12 years", "Mobile No : 555-789-0123"},
            {"Doctor Name : Dr. James Wilson", "Hospital Address : 555 Elm Rd, Grovetown", "Exp : 15 years", "Mobile No : 555-555-1234"},
            {"Doctor Name : Dr. Sarah Adams", "Hospital Address : 123 Main Blvd, Hilltop", "Exp : 18 years", "Mobile No : 555-123-7890"}
    };

    private String[][] doctor_details_3 = {
            {"Doctor Name : Dr. John Smith", "Hospital Address : 789 Oak Ave, Cityville", "Exp : 8 years", "Mobile No : 555-555-5555"},
            {"Doctor Name : Dr. Laura Johnson", "Hospital Address : 202 Pine Dr, Villageton", "Exp : 12 years", "Mobile No : 555-123-4567"},
            {"Doctor Name : Dr. Michael Davis", "Hospital Address : 555 Maple Blvd, Hilltop", "Exp : 15 years", "Mobile No : 555-789-0123"},
            {"Doctor Name : Dr. Emily Wilson", "Hospital Address : 101 Elm Ave, Grovetown", "Exp : 10 years", "Mobile No : 555-555-1234"},
            {"Doctor Name : Dr. Mark Brown", "Hospital Address : 123 Main St, Townville", "Exp : 20 years", "Mobile No : 555-123-7890"}
    };
    private String[][] doctor_details_4 = {
            {"Doctor Name : Dr. Jane Doe", "Hospital Address : 555 Oak Rd, Villageton", "Exp : 15 years", "Mobile No : 555-555-5555"},
            {"Doctor Name : Dr. David Smith", "Hospital Address : 101 Pine Ave, Grovetown", "Exp : 18 years", "Mobile No : 555-123-4567"},
            {"Doctor Name : Dr. Jessica Wilson", "Hospital Address : 202 Maple St, Cityville", "Exp : 10 years", "Mobile No : 555-789-0123"},
            {"Doctor Name : Dr. Michael Johnson", "Hospital Address : 123 Elm Dr, Townville", "Exp : 8 years", "Mobile No : 555-555-1234"},
            {"Doctor Name : Dr. Sarah Davis", "Hospital Address : 789 Main Blvd, Hilltop", "Exp : 12 years", "Mobile No : 555-123-7890"}
    };
    private String[][] doctor_details_5 = {
            {"Doctor Name : Dr. James Smith", "Hospital Address : 555 Oak St, Townville", "Exp : 12 years", "Mobile No : 555-555-5555"},
            {"Doctor Name : Dr. Jessica Davis", "Hospital Address : 101 Pine Ave, Villageton", "Exp : 8 years", "Mobile No : 555-123-4567"},
            {"Doctor Name : Dr. John Wilson", "Hospital Address : 202 Elm Rd, Grovetown", "Exp : 20 years", "Mobile No : 555-789-0123"},
            {"Doctor Name : Dr. Laura Brown", "Hospital Address : 789 Maple Ave, Cityville", "Exp : 15 years", "Mobile No : 555-555-1234"},
            {"Doctor Name : Dr. Mark Johnson", "Hospital Address : 123 Main Dr, Hilltop", "Exp : 18 years", "Mobile No : 555-123-7890"}
    };



    TextView tv;
    Button btn ;
    String[][] doctor_details ={};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewLTDTitle);
        btn = findViewById(R.id.buttonLabDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("family physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
                doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details_3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details_4;
        else
            doctor_details = doctor_details_5;



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FidnDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0; i<doctor_details.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
//            item.put("line5","Cons Fees:"+ doctor_details[i][4]+ "/-");
            list.add(item);

        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.textViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][2]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}
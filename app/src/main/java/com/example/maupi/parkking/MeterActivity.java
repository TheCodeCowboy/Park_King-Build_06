package com.example.maupi.parkking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MeterActivity extends AppCompatActivity {
    TextView priceTextView;
    DatabaseHelper db = new DatabaseHelper(this);
    private Button paybtn;
    private RadioGroup amtgrp;
    private RadioButton amtbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meter);

        Bundle extras = getIntent().getExtras();

        String meterID = "111111";
        if (extras != null) {
            meterID = extras.getString("ParkingMeterID");
        }

        // Log.d("FROM DB", db.getPrice(meterID));

        paybtn = (Button) findViewById(R.id.pay_for_meter_button);
        amtgrp = (RadioGroup) findViewById(R.id.radioGroup_time);

        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payMeter(view);
            }
        });

    }

    public void payMeter(View view) {
        int selectedID = amtgrp.getCheckedRadioButtonId();
        amtbtn = (RadioButton) findViewById(selectedID);
        Toast.makeText(MeterActivity.this, amtbtn.getText(), Toast.LENGTH_SHORT).show();
    }
}
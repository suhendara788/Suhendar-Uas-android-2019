package com.example.petik.uas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private EditText txtinput;
    private RequestQueue mQueue;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQueue = Volley.newRequestQueue(this);
        txtinput = findViewById(R.id.et_1);

        Button tombolJSOn = findViewById(R.id.btnJSON);
        tv1 = (TextView) findViewById(R.id.hasil_1);
        tv2 = (TextView) findViewById(R.id.hasil_2);
        tv3 = (TextView) findViewById(R.id.hasil_3);
        tv4 = (TextView) findViewById(R.id.hasil_4);
    tombolJSOn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            uraiJSON();
        }

        private void uraiJSON() {
            
        }
    });

    }
}

package com.example.petik.uas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

            int a;
            a = Integer.parseInt(String.valueOf(txtinput.getText()))-1;

            uraiJSON(a);
        }

        private void uraiJSON(final int a) {
            String url ="http://192.168.5.28/Maha.json";

            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {


                        JSONObject transaksi = response.getJSONObject(a);

                        String id = transaksi.getString("id");
                        String nama = transaksi.getString("nama");
                        String asal = transaksi.getString("asal_daerah");
                        String kamar = transaksi.getString("kamar");

                        tv1.setText(id);
                        tv2.setText(nama);
                        tv3.setText(asal);
                        tv4.setText(kamar);






                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            },new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_SHORT).show();
                }

            });
            mQueue.add(request);

        }
    });

    }
}

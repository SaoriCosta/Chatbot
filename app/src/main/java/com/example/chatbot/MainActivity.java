package com.example.chatbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {


    EditText editTextBot;
    Button buttonBot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBot = findViewById(R.id.editTextBot);
        buttonBot = findViewById(R.id.buttonBot);


       buttonBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               final String msgBot = editTextBot.getText().toString();

               // Toast.makeText(getApplicationContext(), msgBot, Toast.LENGTH_LONG).show();


                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://192.168.1.15:5000/bot/"+msgBot;


                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                              //  msgBot.setText("Response is: "+ response.substring(0,500));
                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //msgBot.setText("That didn't work!");
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                });


                queue.add(stringRequest);



            }
        });
    }
}

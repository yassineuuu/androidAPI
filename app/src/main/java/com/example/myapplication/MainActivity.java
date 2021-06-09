package com.example.myapplication;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView products;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String url = "http://192.168.8.102:8761/api/allProducts";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = this;

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("Rest Response", response.toString());
                        System.out.println(response);
                        products = findViewById(R.id.namesList);


                        ArrayList<JSONObject> list = new ArrayList<>();
                        JSONArray jsonArray = response;
                        if (jsonArray != null) {
                            int len = jsonArray.length();
                            for (int i=0;i<len;i++){
                                try {
                                    list.add((JSONObject) jsonArray.get(i));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            ArrayList<String> productsName = new ArrayList<>();

                            for (int i=0;i<len;i++){
                                try {
                                    productsName.add(String.valueOf(list.get(i).getString("nom")));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println(productsName);
                            ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, productsName);
                            products.setAdapter(arrayAdapter);
                        }



                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response",error.toString());

                    }
                }
        );

        requestQueue.add(jsonArrayRequest);
    }
}
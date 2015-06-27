package com.crapp.volleytest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends Activity {

    String TAG = "tag_json_object";
    String URL = "http://quesdesk.hostzi.com/create_user.php";

    TextView receivedJSON;
    String text;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receivedJSON = (TextView)findViewById(R.id.received_json);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        Map<String, String> params = new HashMap<>();
        params.put("name", "prateek1");
        params.put("email", "prateek1@gmail.com");


        /*CustomObjectRequest jsonObjectRequest = new CustomObjectRequest(Request.Method.POST, URL, params, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject jsonObject) {
                try{
                    text = jsonObject.toString(2);
                    receivedJSON.setText(text);
                }catch (JSONException e){
                    receivedJSON.setText("JSON Error");
                }

                progressDialog.hide();
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                receivedJSON.setText("Error");
                progressDialog.hide();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);*/

        CustomArrayRequest jsonArrayRequest = new CustomArrayRequest(Request.Method.POST, URL, params, new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray jsonArray) {
                text = jsonArray.toString();
                receivedJSON.setText(text);
                progressDialog.hide();
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                receivedJSON.setText("Error");
                progressDialog.hide();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }

}

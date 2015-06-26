package com.crapp.volleytest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends Activity {

    String TAG = "tag_json_object";
    String URL = "http://quesdesk.hostzi.com/create_user.php";

    TextView receivedJSON;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receivedJSON = (TextView)findViewById(R.id.received_json);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "prateek1");
        params.put("email","prateek1@gmail.com");


        CustomRequest jsonObjectRequest = new CustomRequest(Request.Method.POST, URL, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                receivedJSON.setText(jsonObject.toString());
                progressDialog.hide();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
                receivedJSON.setText("Error");
                progressDialog.hide();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }

}

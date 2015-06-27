package com.crapp.volleytest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;


public class MainActivity extends Activity {

    String TAG = "tag_json_object";
    String URL = "http://quesdesk.hostzi.com/create_user.php";

    TextView receivedJSON;
    ImageView imageView;
    NetworkImageView networkImageView;
    String text;

    ProgressDialog progressDialog;

    String imageURL1 = "http://quesdesk.hostzi.com/Sunset.jpg";
    String imageURL2 = "http://quesdesk.hostzi.com/abc.bmp";

    ImageLoader imageLoader;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receivedJSON = (TextView) findViewById(R.id.received_json);
        imageView = (ImageView) findViewById(R.id.image);
        networkImageView = (NetworkImageView) findViewById(R.id.image_network);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        /*Map<String, String> params = new HashMap<>();
        params.put("name", "prateek1");
        params.put("email", "prateek1@gmail.com");*/


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

        /*CustomArrayRequest jsonArrayRequest = new CustomArrayRequest(Request.Method.POST, URL, params, new Response.Listener<JSONArray>(){
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
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);*/

        /*ImageRequest imageRequest = new ImageRequest(imageURL1, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
                progressDialog.dismiss();
            }
        }, 0, 0, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        receivedJSON.setText("Error");
                        progressDialog.dismiss();
                    }
                });
        AppController.getInstance().addToRequestQueue(imageRequest);*/

        /*imageLoader = AppController.getInstance().getImageLoader();
        imageLoader.get(imageURL1,ImageLoader.getImageListener(imageView,R.drawable.def_image,R.drawable.err_image));

        progressDialog.dismiss();*/

        /*imageLoader = AppController.getInstance().getImageLoader();
        networkImageView.setImageUrl(imageURL1, imageLoader);
        progressDialog.dismiss();*/


    }

}

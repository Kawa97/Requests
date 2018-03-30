package com.example.corsista.requests;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText= (EditText) findViewById(R.id.editText);
        editText.setText("https://cdn-images-1.medium.com/max/2000/1*BR2RiTRoYor9xSrzEgxLWQ.jpeg");
        final ImageView imageView= (ImageView) findViewById(R.id.ImageView);
        final TextView textView = (TextView) findViewById(R.id.text);
        final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("Loading..");
        dialog.show();
        String url = "https://androidtutorialpoint.com/api/volleyJsonObject";
        JsonObjectRequest jsonObjectReq = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast toast = Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT);
                        toast.show();
                        textView.setText(response.toString());
                        dialog.hide();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast = Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG);
                toast.show();
                textView.setText(error.getMessage());
                dialog.hide();
            }
        });
        context= getApplicationContext();

        ServiceQueueSingleton.getInstance(this).addToRequestQueue(jsonObjectReq);

        GsonRequest jsonObjectReq2 = new GsonRequest(url, Telefono.class, null,
                new Response.Listener<Telefono>() {
                    @Override
                    public void onResponse(Telefono response) {
                        textView.setText("Screensize: " + response.getScreenSize());

                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        ServiceQueueSingleton.getInstance(this).addToRequestQueue(jsonObjectReq2);

        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageUrl=editText.getText().toString();
                ImageRequest imageRequest= new ImageRequest(imageUrl,
                        new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap response) {
                            imageView.setImageBitmap(response);
                                Toast toast= Toast.makeText(getApplicationContext(),"Funzeca",Toast.LENGTH_LONG);
                                toast.show();
                            }
                        }, 0, 0, ImageView.ScaleType.CENTER_CROP, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast toast= Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
                ServiceQueueSingleton.getInstance(getApplicationContext()).addToRequestQueue(imageRequest);
            }
        });
    }
/*
    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "");
            return d;
        } catch (Exception e) {
            Toast toast= Toast.makeText(context,"nope",Toast.LENGTH_LONG);
            toast.show();
            return null;
        }
    }*/
}
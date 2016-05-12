package com.example.raghavendra.college;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TimeTable extends AppCompatActivity implements View.OnClickListener {
    private EditText sect;
    private Button buttonGetImage;
    private ImageView imageView;
    String id;

    private RequestHandler requestHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        sect = (EditText) findViewById(R.id.section);
        buttonGetImage = (Button) findViewById(R.id.buttonGetImage);
        imageView = (ImageView) findViewById(R.id.imageViewShow);

        requestHandler = new RequestHandler();

        buttonGetImage.setOnClickListener(this);
    }


    private void getData() {
        id = "16CSE6";
        class GetData extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                System.out.println("check0");
                super.onPreExecute();
                // loading = ProgressDialog.show(MainActivity.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                System.out.println("check2");
                //loading.dismiss();
                showData(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandlerV2 rh = new RequestHandlerV2();
                String s = rh.sendGetRequestParam(Config.URL_GET_EMP, id);
                System.out.print("String is:"+s);
                System.out.println("check1");
                return s;
            }
        }
        GetData ge = new GetData();
        ge.execute();
    }

    private void showData(String json) {
        String sec = sect.getText().toString();

        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray result1 = jsonObj.getJSONArray(Config.TAG_JSON_ARRAY);

            for (int i = 0; i < result1.length(); i++) {
                JSONObject c = result1.getJSONObject(i);
                String tid = c.getString("tid");
                String section = c.getString("section");
                String image = c.getString("image");

                if (sec.compareTo(section) == 0) {
                    byte[] decodedString = Base64.decode(image.getBytes(), Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    imageView.setImageBitmap(decodedByte);

                    System.out.println("tid:" + tid + "\n");
                    System.out.println("section:" + section + "\n");
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        getData();
    }
}
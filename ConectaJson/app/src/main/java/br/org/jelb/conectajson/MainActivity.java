package br.org.jelb.conectajson;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class MainActivity extends AppCompatActivity {

    final String postURL = "INSIRA AQUI SUA URL DE POST";

    final String getURL = "INSIRA AQUI SUA URL DE GET";

    ProgressDialog progress;
    TextView ourTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ourTextView = (TextView) findViewById(R.id.txtTexto);
        Button btGet = (Button) findViewById(R.id.btGet);
        Button btPost = (Button) findViewById(R.id.btPost);

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncHttpClient().get(getURL, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        ourTextView.setText(new String(responseBody));
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        ourTextView.setText(statusCode+" || "+error.getMessage());
                    }
                });
            }
        });

        btPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
                JSONObject jsonParams = new JSONObject();
                try {
                    jsonParams.put("id", "675476457645");
                    jsonParams.put("nome_eq", "teste");
                    jsonParams.put("gps", "teste");
                    jsonParams.put("validade", "10/2022");
                    jsonParams.put("email_op", "email@teste");

                    StringEntity entity = new StringEntity(jsonParams.toString());
                    asyncHttpClient.post(getBaseContext(), postURL, entity, "application/json",
                            new AsyncHttpResponseHandler() {
                                @Override
                                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                                    ourTextView.setText(new String(responseBody));
                                }

                                @Override
                                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                    ourTextView.setText(statusCode+" || "+error.getMessage());
                                }
                            });
                }catch (Exception e){
                    ourTextView.setText("algo errado com o Json");
                }


            }
        });

        //txt.setText(line);

    }
}

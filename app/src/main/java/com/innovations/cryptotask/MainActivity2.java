package com.innovations.cryptotask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {
    TextView symbol, rank , name , changepercentinlast24;
    IntentData intentData;
    ProgressBar progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        symbol = findViewById(R.id.symbol);
        progressDialog = findViewById(R.id.progress_circular);

        rank = findViewById(R.id.rank);
        name = findViewById(R.id.priceusd);
        changepercentinlast24 = findViewById(R.id.changepercent);
        Intent intent = getIntent();

        intentData =intent.getParcelableExtra("intentdata");
        symbol.setText(intentData.getSymbol());
        rank.setText(intentData.getRank());
        name.setText(intentData.getName());
        changepercentinlast24.setText(intentData.getChangepercentinlast24());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.coincap.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface retrofitAPI = retrofit.create(RequestInterface.class);
        Call<HistoryGrapghMainResponse> call2 = retrofitAPI.gethistorylinechartsuccess(intentData.getId(), "d1");
        call2.enqueue(new Callback<HistoryGrapghMainResponse>() {
            @Override
            public void onResponse(Call<HistoryGrapghMainResponse> call, Response<HistoryGrapghMainResponse> response) {

                Log.e("Response", "Response not null  " + response);
                if (response.code() == 404) {
                    progressDialog.setVisibility(View.GONE);


                }

                if (response.code() == 200) {
                    progressDialog.setVisibility(View.GONE);
                    TextView textView = findViewById(R.id.text);


                    HistoryGrapghMainResponse  responseModel= response.body();
                    textView.setText(String.valueOf(response.body().data.toString()));
                    ArrayList<HistoryLinegraphResponseModel> cryptoModelArrayList = new ArrayList<>();
                    if (responseModel.getData() != null) {

                        for (int i = 0; i < responseModel.getData().length; i++) {
                            cryptoModelArrayList.add(responseModel.getData()[i]);

                        }


                        if (cryptoModelArrayList.size() > 0) {





                        } else {


                        }
                    }


                }


            }

            @Override
            public void onFailure(Call<HistoryGrapghMainResponse> call, Throwable t) {
                Toast.makeText(MainActivity2.this, "Unable to Load Data" , Toast.LENGTH_LONG).show();
                 Log.e("TAG", "Toast  " + t.toString());


            }
        });

    }
    }
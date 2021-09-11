package com.innovations.cryptotask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        progressDialog = findViewById(R.id.progress_circular);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.coincap.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface retrofitAPI = retrofit.create(RequestInterface.class);
        Call<ResponseModel> call2 = retrofitAPI.getcryptomodelsuccess();
        call2.enqueue(new Callback<ResponseModel>() {


            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                Log.e("Response", "Response not null  " + response);
                if (response.code() == 404) {
                    progressDialog.setVisibility(View.GONE);
                    //                  selectorImage.setImageResource(R.drawable.ic_circle_checked);

                }

                if (response.code() == 200) {
                    progressDialog.setVisibility(View.GONE);
//                            nodeSelector.setVisibility(View.VISIBLE);

                    ResponseModel  responseModel= response.body();
                    ArrayList<CryptoModel> cryptoModelArrayList = new ArrayList<>();
                    if (responseModel.getData() != null) {
                        for (int i = 0; i < responseModel.getData().length; i++) {
                            cryptoModelArrayList.add(responseModel.getData()[i]);

                        }

                        if (cryptoModelArrayList.size() > 0) {

                            RecyclerView recyclerView = findViewById(R.id.recycler);
                            RecyclerAdapter recyclerAdapter = new RecyclerAdapter(cryptoModelArrayList, MainActivity.this);
                            recyclerView.setAdapter(recyclerAdapter);

                        } else {


                        }
                    }


                }


            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Unable to Load Data" , Toast.LENGTH_LONG).show();
            }
        });

    }




}
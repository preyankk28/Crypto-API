package com.innovations.cryptotask;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RequestInterface {
    @GET("assets")
    Call<ResponseModel> getcryptomodelsuccess();

    @GET("assets/{id}/history")
    Call<HistoryGrapghMainResponse> gethistorylinechartsuccess(
            @Path("id") String id,
            @Query("interval") String interval);
}

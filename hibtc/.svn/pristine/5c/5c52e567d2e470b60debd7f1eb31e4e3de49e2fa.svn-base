package com.guanyou.hibtc.impl.rest;

import com.guanyou.hibtc.domain.Event.*;
import com.guanyou.hibtc.domain.bb.OrderResponse;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Hibtc's REST API URL mappings and endpoint security configuration.
 */
public interface HibtcApiService {

    @POST("bb/api/ticker")
    Call<Object> getTicker(@Query("pair") String pair);

    @POST("bb/api/depth")
    Call<Object> getOrderBook(@Query("pair") String pair, @Query("depth") int depth, @Query("prec") int prec);

    @POST("bb/api/kline")
    Call<Object> getKLine(@Query("pair") String pair, @Query("type") String type, @Query("time_start") long time_start, @Query("time_end") long time_end);

    @POST("bb/api/trades")
    Call<Object> getTrade(@Query("pair") String pair, @Query("last") int last);

    @POST("bb/api/make/order")
    Call<Object> getOrder(@Query("api_key") String api_key, @Query("auth_nonce") String auth_nonce, @Query("auth_key") String auth_key, @Query("auth_sign") String auth_sign,
                                 @Query("pair") String pair, @Query("type") String type, @Query("order_type") String order_type, @Query("price") String price,
                                 @Query("amount") String amount, @Query("money") String money, @Query("stop_price") String stop_price);

    @POST("bb/api/cancel/order")
    Call<Object> cancleOrder(@Query("api_key") String api_key, @Query("auth_nonce") String auth_nonce, @Query("auth_key") String auth_key, @Query("auth_sign") String auth_sign,
                             @Query("pair") String pair, @Query("order_id") String order_id);

    @POST("bb/api/auth/orders")
    Call<Object> getOderList(@Query("api_key") String api_key, @Query("auth_nonce") String auth_nonce, @Query("auth_key") String auth_key, @Query("auth_sign") String auth_sign);

    @POST("bb/api/query/orders")
    Call<Object> getHistoryOrders(@Query("api_key") String api_key, @Query("auth_nonce") String auth_nonce, @Query("auth_key") String auth_key, @Query("auth_sign") String auth_sign,
                                  @Query("page_size") int page_size, @Query("page_index") int page_index);

    @POST("bb/api/auth/trades")
    Call<Object> getTradeList(@Query("api_key") String api_key, @Query("auth_nonce") String auth_nonce, @Query("auth_key") String auth_key, @Query("auth_sign") String auth_sign, @Query("last") int last);

    @POST("bb/api/query/trades")
    Call<Object> getHistoryTrades(@Query("api_key") String api_key, @Query("auth_nonce") String auth_nonce, @Query("auth_key") String auth_key, @Query("auth_sign") String auth_sign,
                                  @Query("page_size") int page_size, @Query("page_index") int page_index);

    @POST("bb/api/auth/wallet")
    Call<Object> getWalletBalance(@Query("api_key") String api_key, @Query("auth_nonce") String auth_nonce, @Query("auth_key") String auth_key, @Query("auth_sign") String auth_sign);

}

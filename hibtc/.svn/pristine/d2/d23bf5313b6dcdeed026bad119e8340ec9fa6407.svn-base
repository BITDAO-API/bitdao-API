package com.guanyou.hibtc.impl.rest;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import com.guanyou.hibtc.domain.bb.OrderResponse;
import com.guanyou.hibtc.exception.HibtcApiError;
import com.guanyou.hibtc.exception.HibtcApiException;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 *
 */
public class HibtcApiServiceGenerator {
    private  Retrofit retrofit;

    public HibtcApiServiceGenerator() {
          Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(HibtcApiConstants.API_BASE_URL)
                        .addConverterFactory(JacksonConverterFactory.create());
        retrofit = builder.build();
    }

    public HibtcApiServiceGenerator(String url) {
          Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(JacksonConverterFactory.create());
        retrofit = builder.build();
    }

    public  <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public  <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();

            if (response.isSuccessful()) {
                JSONObject js = (JSONObject) JSONObject.toJSON(response.body());
                String   outChannel =js.getString(HibtcApiConstants.JSON_CHINNEL);
                if ("0".equals(js.getString("code"))) {
                    return response.body();
                }else if (HibtcApiConstants.AUTH_MAKE_ORDER.equalsIgnoreCase(outChannel)) {
                    return response.body();
                } else if (HibtcApiConstants.AUTH_CANCLE_ORDER.equalsIgnoreCase(outChannel)) {
                    return response.body();
                }else{
                    HibtcApiError apiError=new HibtcApiError();
                    apiError.setMsg("error"+response.body() );
                    throw new HibtcApiException(apiError);
                }


            } else {
                HibtcApiError apiError = getHibtcApiError(response);
                throw new HibtcApiException(apiError);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibtcApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public  HibtcApiError getHibtcApiError(Response<?> response) throws IOException, HibtcApiException {
        return (HibtcApiError) retrofit.responseBodyConverter(HibtcApiError.class, new Annotation[0])
                .convert(response.errorBody());
    }
}
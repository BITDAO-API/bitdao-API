package com.guanyou.hibtc.impl.rest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import com.guanyou.hibtc.domain.Event.*;
import com.guanyou.hibtc.domain.bb.OrderResponse;
import com.guanyou.hibtc.exception.HibtcApiError;
import com.guanyou.hibtc.exception.HibtcApiException;
import com.guanyou.hibtc.impl.build.BuildJSON;
import com.guanyou.hibtc.ws.HibtcApiCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * An adapter/wrapper which transforms a Callback from Retrofit into a HibtcApiCallback which is exposed to the client.
 */
public class HibtcApiCallbackAdapter<T> implements Callback<T> {

    private final HibtcApiCallback<T> callback;
    private BuildJSON buildJSON = new BuildJSON();

    public HibtcApiCallbackAdapter(HibtcApiCallback<T> callback) {
        this.callback = callback;
    }

    public void onResponse(Call<T> call, Response<T> response) {
        T event = null;
        ObjectMapper mapper = new ObjectMapper();
        if (response.isSuccessful()) {
            JSONObject js = null;
            String outChannel = null;
            String channel = null;
            try {
                js = (JSONObject) JSONObject.toJSON(response.body());
                outChannel = js.getString(HibtcApiConstants.JSON_CHINNEL);
                if (outChannel == null) {
                    HibtcApiError error = new HibtcApiError();
                    error.setMsg(js.getString("msg") != null ? js.getString("msg") : "");
                    error.setCode(Integer.parseInt(js.getString("Code")) == -2 ? Integer.parseInt(js.getString("Code")) : -1);
                    throw new HibtcApiException(error);
                }
                channel = (js.getString(HibtcApiConstants.JSON_CHINNEL));
            } catch (Exception e) {
                e.printStackTrace();
                throw new HibtcApiException(e);
            }
            if ("0".equals(js.getString("code"))) {
                try {
                    if (HibtcApiConstants.TICKER.equalsIgnoreCase(channel)) {
                        event = mapper.readValue(js.toJSONString(), new TypeReference<EventTicker>() {
                        });

                    } else if (HibtcApiConstants.DEPTH.equalsIgnoreCase(channel)) {

                        event = mapper.readValue(js.toJSONString(), new TypeReference<EventDepth>() {
                        });
                    } else if (HibtcApiConstants.TRADE.equalsIgnoreCase(channel)) {
                        List<String[]> dataArray = JSONObject.parseArray(js.getString(HibtcApiConstants.JSON_DATA), String[].class);
                        JSONArray jsonArra = buildJSON.buildTrade(dataArray);
                        js.put(HibtcApiConstants.JSON_DATA, jsonArra);
                        event = mapper.readValue(js.toJSONString(), new TypeReference<EventTrade>() {
                        });
                    } else if (HibtcApiConstants.KLINE.equalsIgnoreCase(channel)) {
                        List<String[]> dataArray = JSONObject.parseArray(js.getString(HibtcApiConstants.JSON_DATA), String[].class);
                        JSONArray jsonArra = buildJSON.buildKline(dataArray);
                        js.put(HibtcApiConstants.JSON_DATA, jsonArra);
                        event = mapper.readValue(js.toJSONString(), new TypeReference<EventKLine>() {
                        });
                    } else if (HibtcApiConstants.AUTH_TRADE.equalsIgnoreCase(channel)) {
                        List<String[]> dataArray = JSONObject.parseArray(js.getString(HibtcApiConstants.JSON_DATA), String[].class);
                        JSONArray jsonArra = buildJSON.buildHisTrade(dataArray);
                        js.put(HibtcApiConstants.JSON_DATA, jsonArra);
                        event = mapper.readValue(js.toJSONString(), new TypeReference<EventListTrade>() {
                        });
                    } else if (HibtcApiConstants.AUTH_ORDER.equalsIgnoreCase(channel)) {
                        List<String[]> dataArray = JSONObject.parseArray(js.getString(HibtcApiConstants.JSON_DATA), String[].class);
                        JSONArray jsonArra = buildJSON.buildOrder(dataArray);
                        js.put(HibtcApiConstants.JSON_DATA, jsonArra);
                        event = mapper.readValue(js.toJSONString(), new TypeReference<EventOrder>() {
                        });
                    } else if (HibtcApiConstants.AUTH_WALLET.equalsIgnoreCase(channel)) {

                        event = mapper.readValue(js.toJSONString(), new TypeReference<EventWallet>() {
                        });
                    } else if (HibtcApiConstants.AUTH_HIS_TRADES.equalsIgnoreCase(channel)) {
                        List<String[]> dataArray = JSONObject.parseArray(js.getString(HibtcApiConstants.JSON_DATA), String[].class);
                        JSONArray jsonArra = buildJSON.buildHisTrade(dataArray);
                        js.put(HibtcApiConstants.JSON_DATA, jsonArra);
                        event = mapper.readValue(js.toJSONString(), new TypeReference<HisListTrade>() {
                        });
                    } else if (HibtcApiConstants.AUTH_HIS_ORDERS.equalsIgnoreCase(channel)) {
                        List<String[]> dataArray = JSONObject.parseArray(js.getString(HibtcApiConstants.JSON_DATA), String[].class);
                        JSONArray jsonArra = buildJSON.buildOrder(dataArray);
                        js.put(HibtcApiConstants.JSON_DATA, jsonArra);
                        event = mapper.readValue(js.toJSONString(), new TypeReference<HisListOrder>() {
                        });
                    } else if (HibtcApiConstants.AUTH_MAKE_ORDER.equalsIgnoreCase(channel)) {

                        event = mapper.readValue(js.getString(HibtcApiConstants.JSON_DATA), new TypeReference<OrderResponse>() {
                        });
                    } else if (HibtcApiConstants.AUTH_CANCLE_ORDER.equalsIgnoreCase(channel)) {

                        event = mapper.readValue(js.getString(HibtcApiConstants.JSON_DATA), new TypeReference<CancleOrderResponse>() {
                        });
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    throw new HibtcApiException(e);
                }

            } else if (HibtcApiConstants.AUTH_MAKE_ORDER.equalsIgnoreCase(outChannel)) {
                try {
                    event = mapper.readValue(js.getString(HibtcApiConstants.JSON_DATA), new TypeReference<OrderResponse>() {
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (HibtcApiConstants.AUTH_CANCLE_ORDER.equalsIgnoreCase(outChannel)) {

                try {
                    event = mapper.readValue(js.toJSONString(), new TypeReference<CancleOrderResponse>() {
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new HibtcApiException(e);
                }
            }
            callback.onResponse(event);
        } else {
            try {
                HibtcApiError apiError = new HibtcApiError();
                apiError.setCode(-1);
                apiError.setMsg(response.errorBody().toString());
                throw new HibtcApiException(apiError);
            } catch (Exception e) {
                throw new HibtcApiException(e);
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        throw new HibtcApiException(throwable);
    }


}

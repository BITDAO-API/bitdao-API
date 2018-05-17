package com.guanyou.hibtc.impl.rest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import com.guanyou.hibtc.domain.Event.*;
import com.guanyou.hibtc.domain.bb.OrderResponse;
import com.guanyou.hibtc.impl.build.BuildJSON;
import com.guanyou.hibtc.rest.HibtcApiRestClient;
import com.guanyou.hibtc.domain.account.AuthInfo;
import com.guanyou.hibtc.until.MD5coding;

import java.util.List;




/**
 * Implementation of Hibtc's REST API using Retrofit with synchronous/blocking method calls.
 */
public class HibtcApiRestClientImpl implements HibtcApiRestClient {

    private final com.guanyou.hibtc.impl.rest.HibtcApiService HibtcApiService;
   private HibtcApiServiceGenerator service;
    public HibtcApiRestClientImpl(HibtcApiServiceGenerator hibtcApiServiceGenerator) {
        this.service= hibtcApiServiceGenerator;
        HibtcApiService = hibtcApiServiceGenerator.createService(HibtcApiService.class);
    }

    private  BuildJSON buildJSON = new BuildJSON();

    @Override
    public EventTicker getTicker(String pair) {
        JSONObject js = (JSONObject) JSONObject.toJSON(service.executeSync(HibtcApiService.getTicker(pair)));//EventTicker.class
        EventTicker eventTicker =JSONObject.parseObject(js.getString(HibtcApiConstants.JSON_DATA), EventTicker.class);
        return eventTicker;

    }
    
    @Override
    public EventDepth getOrderBook(String pair, int depth, int prec) {
        JSONObject js = (JSONObject) JSONObject.toJSON(service.executeSync(HibtcApiService.getOrderBook(pair, depth, prec)));
        EventDepth eventDepth = JSONObject.parseObject(js.getString(HibtcApiConstants.JSON_DATA), EventDepth.class);
        return eventDepth;
    }

    @Override
    public EventKLine getKLine(String pair, String type, long time_start, long time_end) {
        JSONObject js = (JSONObject) JSONObject.toJSON(service.executeSync(HibtcApiService.getKLine(pair, type, time_start, time_end)));
        JSONObject data = (JSONObject) JSONObject.toJSON(js.get(HibtcApiConstants.JSON_DATA));
        List<String[]> dataArray = JSONObject.parseArray(data.getString(HibtcApiConstants.JSON_DATA), String[].class);
        JSONArray jsonArra1 = buildJSON.buildKline(dataArray);
        data.put(HibtcApiConstants.JSON_DATA, jsonArra1);
        EventKLine eventKLine =JSONObject.parseObject(js.getString(HibtcApiConstants.JSON_DATA), EventKLine.class);
        return eventKLine;
    }



    @Override
    public EventTrade getTrade(String pair, int last) {
        JSONObject js = (JSONObject) JSONObject.toJSON(service.executeSync(HibtcApiService.getTrade(pair, last)));
        JSONObject data = (JSONObject) JSONObject.toJSON(js.get(HibtcApiConstants.JSON_DATA));
        List<String[]> dataArray = JSONObject.parseArray(data.getString(HibtcApiConstants.JSON_DATA), String[].class);
        JSONArray jsonArra1 = buildJSON.buildTrade(dataArray);
        data.put(HibtcApiConstants.JSON_DATA, jsonArra1);
        EventTrade eventTrade = JSONObject.parseObject(js.getString(HibtcApiConstants.JSON_DATA), EventTrade.class);
        return eventTrade;
    }



    @Override
    public CancleOrderResponse cancleOrder(AuthInfo authInfo, String pair, String order_id) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(auth_nonce + auth_key + apiSecret);
        JSONObject js = (JSONObject) JSONObject.toJSON(service.executeSync(HibtcApiService.cancleOrder(api_key, auth_nonce, auth_key, auth_sign, pair, order_id)));
        CancleOrderResponse orderResponse = JSONObject.parseObject(js.toJSONString(), CancleOrderResponse.class);
        return orderResponse ;

    }

    @Override
    public EventOrder getOderList(AuthInfo authInfo) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(auth_nonce + auth_key + apiSecret);
        JSONObject js = (JSONObject) JSONObject.toJSON(service.executeSync(HibtcApiService.getOderList(api_key, auth_nonce, auth_key, auth_sign)));
        JSONObject data = (JSONObject) JSONObject.toJSON(js.get(HibtcApiConstants.JSON_DATA));
        List<String[]> dataArray = JSONObject.parseArray(data.getString(HibtcApiConstants.JSON_DATA), String[].class);
        JSONArray jsonArra1 = buildJSON.buildOrder(dataArray);
        data.put(HibtcApiConstants.JSON_DATA, jsonArra1);
        EventOrder eventOrder =JSONObject.parseObject(js.getString(HibtcApiConstants.JSON_DATA), EventOrder.class);
        return eventOrder;
    }


    @Override
    public HisListOrder getHistoryOrders(AuthInfo authInfo, int page_size, int page_index) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(auth_nonce + auth_key + apiSecret);
        JSONObject js = (JSONObject) JSONObject.toJSON(service.executeSync(HibtcApiService.getHistoryOrders(api_key, auth_nonce, auth_key, auth_sign, page_size, page_index)));
        JSONObject data = (JSONObject) JSONObject.toJSON(js.get(HibtcApiConstants.JSON_DATA));
        List<String[]> dataArray = JSONObject.parseArray(data.getString(HibtcApiConstants.JSON_DATA), String[].class);
        JSONArray jsonArra1 = buildJSON.buildOrder(dataArray);
        data.put(HibtcApiConstants.JSON_DATA, jsonArra1);
        HisListOrder eventOrder = JSONObject.parseObject(js.getString(HibtcApiConstants.JSON_DATA), HisListOrder.class);
        return eventOrder;
    }

    @Override
    public EventListTrade getTradeList(AuthInfo authInfo, int last) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(auth_nonce + auth_key + apiSecret);
        JSONObject js = (JSONObject) JSONObject.toJSON(service.executeSync(HibtcApiService.getTradeList(api_key, auth_nonce, auth_key, auth_sign, last)));
        JSONObject data = (JSONObject) JSONObject.toJSON(js.get(HibtcApiConstants.JSON_DATA));
        List<String[]> dataArray = JSONObject.parseArray(data.getString(HibtcApiConstants.JSON_DATA), String[].class);
        JSONArray jsonArra1 = buildJSON.buildHisTrade(dataArray);
        data.put(HibtcApiConstants.JSON_DATA, jsonArra1);
        EventListTrade eventListTrade = JSONObject.parseObject(js.getString(HibtcApiConstants.JSON_DATA), EventListTrade.class);
        return eventListTrade;
    }

    @Override
    public HisListTrade getHistoryTrades(AuthInfo authInfo, int page_size, int page_index) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(auth_nonce + auth_key + apiSecret);
        JSONObject js = (JSONObject) JSONObject.toJSON(service.executeSync(HibtcApiService.getHistoryTrades(api_key, auth_nonce, auth_key, auth_sign, page_size, page_index)));
        JSONObject data = (JSONObject) JSONObject.toJSON(js.get(HibtcApiConstants.JSON_DATA));
        List<String[]> dataArray = JSONObject.parseArray(data.getString(HibtcApiConstants.JSON_DATA), String[].class);
        JSONArray jsonArra1 = buildJSON.buildHisTrade(dataArray);
        data.put(HibtcApiConstants.JSON_DATA, jsonArra1);
        HisListTrade eventListTrade = JSONObject.parseObject(js.getString(HibtcApiConstants.JSON_DATA), HisListTrade.class);
        return eventListTrade;
    }


    @Override
    public EventWallet getWalletBalance(AuthInfo authInfo) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(auth_nonce + auth_key + apiSecret);
        JSONObject js = (JSONObject) JSONObject.toJSON(service.executeSync(HibtcApiService.getWalletBalance(api_key, auth_nonce, auth_key, auth_sign)));
        EventWallet eventWallet = JSONObject.parseObject(js.getString(HibtcApiConstants.JSON_DATA), EventWallet.class);
        return eventWallet;
    }

    @Override
    public OrderResponse makeLimitBuyOrder(AuthInfo authInfo, String pair, String price, String amount) {

        return getOrder(authInfo, pair, "buy", "LIMIT", price, amount, "0", "0");
    }

    @Override
    public OrderResponse makeLimitSellOrder(AuthInfo authInfo, String pair, String price, String amount) {

        return getOrder(authInfo, pair, "sell", "LIMIT", price, amount, "0", "0");
    }

    @Override
    public OrderResponse makeMarketBuyOrder(AuthInfo authInfo, String pair, String money) {

        return getOrder(authInfo, pair, "buy", "MARKET", "0", "0", money, "0");
    }

    @Override
    public OrderResponse makeMarketSellOrder(AuthInfo authInfo, String pair, String money) {

        return getOrder(authInfo, pair, "sell", "MARKET", "0", "0", money, "0");
    }

    @Override
    public OrderResponse makeStopBuyOrder(AuthInfo authInfo, String pair, String price, String amount, String stop_price) {

        return getOrder(authInfo, pair, "buy", "STOP", price, amount, "0", stop_price);
    }

    @Override
    public OrderResponse makeStopSellOrder(AuthInfo authInfo, String pair, String price, String amount, String stop_price) {

        return getOrder(authInfo, pair, "sell", "STOP", price, amount, "0", stop_price);
    }

    public OrderResponse getOrder(AuthInfo authInfo, String pair, String type, String order_type, String price, String amount, String money, String stop_price) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(auth_nonce + auth_key + apiSecret);
        JSONObject js = (JSONObject) JSONObject.toJSON(service.executeSync(HibtcApiService.getOrder(api_key, auth_nonce, auth_key, auth_sign, pair, type, order_type, price, amount, money, stop_price)));
        OrderResponse orderResponse = JSONObject.parseObject(js.getString(HibtcApiConstants.JSON_DATA), OrderResponse.class);
        return orderResponse ;
    }


}

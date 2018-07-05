package com.guanyou.hibtc.impl.rest;

import com.guanyou.hibtc.domain.account.AuthInfo;
import com.guanyou.hibtc.rest.HibtcApiAsynRestClient;
import com.guanyou.hibtc.until.MD5coding;
import com.guanyou.hibtc.ws.HibtcApiCallback;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/1610:04
 * @Modified by:
 */
public class HibtcApiAsynRestClientImpl implements HibtcApiAsynRestClient {
    private final HibtcApiService HibtcApiService;

    public HibtcApiAsynRestClientImpl(HibtcApiServiceGenerator hibtcApiServiceGenerator) {

        HibtcApiService = hibtcApiServiceGenerator.createService(HibtcApiService.class);
    }


    @Override
    public void getTicker(String pair, HibtcApiCallback<Object> callback) {
        HibtcApiService.getTicker(pair).enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void getOrderBook(String pair, int depth, int prec, HibtcApiCallback<Object> callback) {
        HibtcApiService.getOrderBook(pair, depth, prec).enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void getKLine(String pair, String type, long time_start, long time_end, HibtcApiCallback<Object> callback) {
        HibtcApiService.getKLine(pair, type, time_start, time_end).enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTrade(String pair, int last, HibtcApiCallback<Object> callback) {
        HibtcApiService.getTrade(pair, last).enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancleOrder(AuthInfo authInfo, String pair, String order_id, HibtcApiCallback<Object> callback) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(auth_nonce + auth_key + apiSecret);
        HibtcApiService.cancleOrder(api_key, auth_nonce, auth_key, auth_sign, pair, order_id).enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void getOderList(AuthInfo authInfo, HibtcApiCallback<Object> callback) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(auth_nonce + auth_key + apiSecret);
        HibtcApiService.getOderList(api_key, auth_nonce, auth_key, auth_sign).enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void getHistoryOrders(AuthInfo authInfo, int page_size, int page_index, HibtcApiCallback<Object> callback) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(auth_nonce + auth_key + apiSecret);
        HibtcApiService.getHistoryOrders(api_key, auth_nonce, auth_key, auth_sign, page_size, page_index).enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void getTradeList(AuthInfo authInfo, int last, HibtcApiCallback<Object> callback) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(auth_nonce + auth_key + apiSecret);
        HibtcApiService.getTradeList(api_key, auth_nonce, auth_key, auth_sign, last).enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void getHistoryTrades(AuthInfo authInfo, int page_size, int page_index, HibtcApiCallback<Object> callback) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(auth_nonce + auth_key + apiSecret);
        HibtcApiService.getHistoryTrades(api_key, auth_nonce, auth_key, auth_sign, page_size, page_index).enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void getWalletBalance(AuthInfo authInfo, HibtcApiCallback<Object> callback) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(auth_nonce + auth_key + apiSecret);
        HibtcApiService.getWalletBalance(api_key, auth_nonce, auth_key, auth_sign).enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void makeLimitBuyOrder(AuthInfo authInfo, String pair, String price, String amount, HibtcApiCallback<Object> callback) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(amount + api_key + auth_nonce + "0" + "LIMIT" + pair + price + "0" + "buy" + apiSecret);
        HibtcApiService.getOrder(api_key, auth_nonce, auth_sign, pair, "buy", "LIMIT", price, amount, "0", "0").enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void makeLimitSellOrder(AuthInfo authInfo, String pair, String price, String amount, HibtcApiCallback<Object> callback) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(amount + api_key + auth_nonce + "0" + "LIMIT" + pair + price + "0" + "sell" + apiSecret);
        HibtcApiService.getOrder(api_key, auth_nonce, auth_sign, pair, "sell", "LIMIT", price, amount, "0", "0").enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void makeMarketBuyOrder(AuthInfo authInfo, String pair, String money, HibtcApiCallback<Object> callback) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5("0" + api_key + auth_nonce + money + "MARKET" + pair + "0" + "0" + "buy" + apiSecret);
        HibtcApiService.getOrder(api_key, auth_nonce, auth_sign, pair, "buy", "MARKET", "0", "0", money, "0").enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void makeMarketSellOrder(AuthInfo authInfo, String pair, String money, HibtcApiCallback<Object> callback) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5("0" + api_key + auth_nonce + money + "MARKET" + pair + "0" + "0" + "sell" + apiSecret);
        HibtcApiService.getOrder(api_key, auth_nonce, auth_sign, pair, "sell", "MARKET", "0", "0", money, "0").enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void makeStopBuyOrder(AuthInfo authInfo, String pair, String price, String amount, String stop_price, HibtcApiCallback<Object> callback) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String auth_key = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(amount + api_key + auth_nonce + "0" + "STOP" + pair + price + stop_price + "buy" + apiSecret);
        HibtcApiService.getOrder(api_key, auth_nonce, auth_sign, pair, "buy", "STOP", price, amount, "0", stop_price).enqueue(new HibtcApiCallbackAdapter<>(callback));
    }

    @Override
    public void makeStopSellOrder(AuthInfo authInfo, String pair, String price, String amount, String stop_price, HibtcApiCallback<Object> callback) {
        String api_key = authInfo.getApi_key();
        String auth_nonce = authInfo.getAuth_nonce();
        String apiSecret = authInfo.getApiSecret();
        String auth_sign = MD5coding.MD5(amount + api_key + auth_nonce + "0" + "STOP" + pair + price + stop_price + "sell" + apiSecret);
        HibtcApiService.getOrder(api_key, auth_nonce, auth_sign, pair, "sell", "STOP", price, amount, "0", stop_price).enqueue(new HibtcApiCallbackAdapter<>(callback));
    }
}

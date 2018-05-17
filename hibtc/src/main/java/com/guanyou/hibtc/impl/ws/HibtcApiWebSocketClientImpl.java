package com.guanyou.hibtc.impl.ws;


import com.alibaba.fastjson.JSONObject;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import com.guanyou.hibtc.domain.account.AuthInfo;
import com.guanyou.hibtc.until.MD5coding;
import com.guanyou.hibtc.ws.HibtcApiWebSocketClient;
import okhttp3.*;

/**
 * Hibtc API WebSocket client implementation using OkHttp.
 */
public class HibtcApiWebSocketClientImpl implements HibtcApiWebSocketClient {

    private OkHttpClient client;

    public HibtcApiWebSocketClientImpl() {
        Dispatcher d = new Dispatcher();
        d.setMaxRequestsPerHost(100);
        this.client = new OkHttpClient.Builder().dispatcher(d).build();
    }

    @Override
    public String onEventTicker(String pair) {
        JSONObject js = new JSONObject();
        js.put("event", "subscribe");
        js.put("channel", "ticker");
        js.put("pair", pair);
        return js.toJSONString();
    }

    @Override
    public String onEventOrderBook(String pair, int depth, int prec) {
        JSONObject js = new JSONObject();
        js.put("event", "subscribe");
        js.put("channel", "depth");
        js.put("pair", pair);
        js.put("depth", depth);
        js.put("prec", prec);
        return js.toJSONString();
    }


    @Override
    public String onEventOrderBook(String pair, int depth) {
        return onEventOrderBook(pair, depth, 0);
    }

    @Override
    public String onEventTrade(String pair, int last) {
        JSONObject js = new JSONObject();
        js.put("event", "subscribe");
        js.put("channel", "trades");
        js.put("pair", pair);
        js.put("last", last);
        return js.toJSONString();
    }

    @Override
    public String onEventKLine(String pair, String type, long time_start, long time_end) {
        JSONObject js = new JSONObject();
        js.put("event", "subscribe");
        js.put("channel", "kline");
        js.put("pair", pair);
        js.put("type", type);
        js.put("time_start", String.valueOf(time_start));
        js.put("time_end", String.valueOf(time_end));
        return js.toJSONString();
    }

    @Override
    public String onEventCancelTrades(String pair) {
        JSONObject js = new JSONObject();
        js.put("event", "cancel_subscribe");
        js.put("channel", "trades");
        js.put("pair", pair);
        return js.toJSONString();
    }

    @Override
    public String onEventCancelOrdereBook(String pair) {
        JSONObject js = new JSONObject();
        js.put("event", "cancel_subscribe");
        js.put("channel", "depth");
        js.put("pair", pair);
        return js.toJSONString();
    }

    @Override
    public String onEventCancelALL(String pair) {
        JSONObject js = new JSONObject();
        js.put("event", "cancel_subscribe");
        js.put("channel", "");
        js.put("pair", pair);
        return js.toJSONString();
    }

    @Override
    public String onEventCancelTicker(String pair) {
        JSONObject js = new JSONObject();
        js.put("event", "cancel_subscribe");
        js.put("channel", "ticker");
        js.put("pair", pair);
        return js.toJSONString();
    }

    @Override
    public String onEventCancelKLine(String pair) {
        JSONObject js = new JSONObject();
        js.put("event", "cancel_subscribe");
        js.put("channel", "kline");
        js.put("pair", pair);
        return js.toJSONString();
    }

    @Override
    public String makeLimitBuyOrder(String pair, String price, String amount) {
        JSONObject parameters = new JSONObject();
        parameters.put("pair", pair);
        parameters.put("type", "buy");
        parameters.put("orderType", "LIMIT");
        parameters.put("price", price);
        parameters.put("amount", amount);
        JSONObject js = new JSONObject();
        js.put("event", "exec");
        js.put("channel", "auth-make-order");
        js.put("parameters", parameters);
        return js.toJSONString();
    }

    @Override
    public String makeLimitSellOrder(String pair, String price, String amount) {
        JSONObject parameters = new JSONObject();
        parameters.put("pair", pair);
        parameters.put("type", "sell");
        parameters.put("orderType", "LIMIT");
        parameters.put("price", price);
        parameters.put("amount", amount);
        JSONObject js = new JSONObject();
        js.put("event", "exec");
        js.put("channel", "auth-make-order");
        js.put("parameters", parameters);
        return js.toJSONString();
    }

    @Override
    public String makeMarketBuyOrder(String pair, String money) {
        JSONObject parameters = new JSONObject();
        parameters.put("pair", pair);
        parameters.put("type", "buy");
        parameters.put("orderType", "MARKET");
        parameters.put("money", money);
        JSONObject js = new JSONObject();
        js.put("event", "exec");
        js.put("channel", "auth-make-order");
        js.put("parameters", parameters);
        return js.toJSONString();
    }

    @Override
    public String cancelOrder(String pair, String orderId) {
        JSONObject parameters = new JSONObject();
        parameters.put("pair", pair);
        parameters.put("orderId", orderId);
        JSONObject js = new JSONObject();
        js.put("event", "exec");
        js.put("channel", "auth-cancel-order");
        js.put("parameters", parameters);
        System.out.println(js.toJSONString());
        return js.toJSONString();
    }

    @Override
    public String makeMarketSellOrder(String pair, String money) {
        JSONObject parameters = new JSONObject();
        parameters.put("pair", pair);
        parameters.put("type", "sell");
        parameters.put("orderType", "MARKET");
        parameters.put("money", money);
        JSONObject js = new JSONObject();
        js.put("event", "exec");
        js.put("channel", "auth-make-order");
        js.put("parameters", parameters);
        return js.toJSONString();
    }

    @Override
    public String makeStopBuyOrder(String pair, String price, String amount, String stop_price) {
        JSONObject parameters = new JSONObject();
        parameters.put("pair", pair);
        parameters.put("type", "buy");
        parameters.put("orderType", "STOP");
        parameters.put("stopPrice", stop_price);
        parameters.put("price", price);
        parameters.put("amount", amount);
        JSONObject js = new JSONObject();
        js.put("event", "exec");
        js.put("channel", "auth-make-order");
        js.put("parameters", parameters);
        return js.toJSONString();
    }

    @Override
    public String makeStopSellOrder(String pair, String price, String amount, String stop_price) {
        JSONObject parameters = new JSONObject();
        parameters.put("pair", pair);
        parameters.put("type", "sell");
        parameters.put("orderType", "STOP");
        parameters.put("stopPrice", stop_price);
        parameters.put("price", price);
        parameters.put("amount", amount);
        JSONObject js = new JSONObject();
        js.put("event", "exec");
        js.put("channel", "auth-make-order");
        js.put("parameters", parameters);
        return js.toJSONString();
    }

    @Override
    public String onEventAutnTrades(int last) {
        JSONObject js = new JSONObject();
        js.put("event", "subscribe");
        js.put("channel", "auth-trades");
        js.put("last", last);
        return js.toJSONString();
    }

    @Override
    public String onEventAuthOrders() {
        JSONObject js = new JSONObject();
        js.put("event", "subscribe");
        js.put("channel", "auth-orders");
        return js.toJSONString();
    }

    @Override
    public String onEventAuthWallet() {
        JSONObject js = new JSONObject();
        js.put("event", "subscribe");
        js.put("channel", "auth-wallet");
        return js.toJSONString();
    }

    @Override
    public String onEventAuthHistrades(int pageSize, int pageIndex) {
        JSONObject js = new JSONObject();
        js.put("event", "query");
        js.put("channel", "auth-trades-history");
        js.put("pageSize", pageSize);
        js.put("pageIndex", pageIndex);
        return js.toJSONString();
    }

    @Override
    public String onEventAuthHisOrders(int pageSize, int pageIndex) {
        JSONObject js = new JSONObject();
        js.put("event", "query");
        js.put("channel", "auth-orders-history");
        js.put("pageSize", pageSize);
        js.put("pageIndex", pageIndex);
        return js.toJSONString();
    }

    public String onAuthInfo(AuthInfo authInfo) {
        String apiKey = authInfo.getApi_key();
        String authNonce = authInfo.getAuth_nonce();
        String authKey = authInfo.getAuth_key();
        String apiSecret = authInfo.getApiSecret();
        String authSign = MD5coding.MD5(authNonce + authKey + apiSecret);
        JSONObject js = new JSONObject();
        js.put("event", "login");
        js.put("authNonce", authNonce);
        js.put("authKey", authKey);
        js.put("apiKey", apiKey);
        js.put("authSign", authSign);
        return js.toJSONString();
    }


    public WebSocket createNewWebSocket(HibtcApiWebSocketListener listener) {
        String streamingUrl = HibtcApiConstants.WS_API_BASE_URL;
        Request request = new Request.Builder().url(streamingUrl).get().build();
        WebSocket webSocket = client.newWebSocket(request, listener);
        return webSocket;
    }

    public WebSocket createNewWebSocket(String url,HibtcApiWebSocketListener listener) {
        Request request = new Request.Builder().url(url).get().build();
        WebSocket webSocket = client.newWebSocket(request, listener);
        return webSocket;
    }


}

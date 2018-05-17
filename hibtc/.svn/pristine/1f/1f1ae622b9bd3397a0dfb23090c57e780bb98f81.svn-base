package com.guanyou.hibtc.impl.ws;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guanyou.hibtc.constant.HibtcApiConstants;
import com.guanyou.hibtc.domain.Event.*;
import com.guanyou.hibtc.exception.HibtcApiError;
import com.guanyou.hibtc.exception.HibtcApiException;
import com.guanyou.hibtc.impl.build.BuildJSON;
import com.guanyou.hibtc.until.StringUtil;
import com.guanyou.hibtc.ws.HibtcApiCallback;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hibtc API WebSocket listener.
 */
public class HibtcApiWebSocketListener extends WebSocketListener {

    boolean flag = false;
    private boolean closing = false;
    HibtcApiCallback call = null;

    private BuildJSON buildJSON = new BuildJSON();
    Map<String, HibtcApiCallback> m = new HashMap<>();

    public HibtcApiWebSocketListener() {
    }

    public <I, O> HibtcApiWebSocketListener addProcess(HibtcApiCallback callback, Class<O> t) {
        this.m.put(t.getName(), callback);
        return this;
    }


    @Override
    public void onMessage(WebSocket webSocket, String text) {

        ObjectMapper mapper = new ObjectMapper();
        Object event = null;
        if (text.matches("\"\\{'ping':''}\"")) {
            return;
        } else {
            try {
                if (!StringUtil.isEmpty(((JSONObject) JSONObject.parse(text)).getString(HibtcApiConstants.JSON_EVENT))) {
                    if (HibtcApiConstants.CANCLE_SUB.equalsIgnoreCase(((JSONObject) JSONObject.parse(text)).getString(HibtcApiConstants.JSON_EVENT))) {
                        event = mapper.readValue(text, new TypeReference<CancleSubResponse>() {
                        });
                        call = m.get(CancleSubResponse.class.getName());
                        if (null != call) call.onResponse(event);
                        return;
                    }
                    if (!"0".equals(((JSONObject) JSONObject.parse(text)).getString(HibtcApiConstants.JSON_DATA))) {
                        HibtcApiError error = new HibtcApiError();
                        error.setCode(-1);
                        error.setMsg("login failed");
                        throw new HibtcApiException(error);
                    } else {
                        event = mapper.readValue(text, new TypeReference<LoginResult>() {
                        });
                        call = m.get(LoginResult.class.getName());
                        if (null != call) call.onResponse(event);
                        flag = true;
                        return;
                    }
                }

                String channel = ((JSONObject) JSONObject.parse(text)).getString(HibtcApiConstants.JSON_CHINNEL);
                if (HibtcApiConstants.TICKER.equalsIgnoreCase(channel)) {
                    event = mapper.readValue(text, new TypeReference<EventTicker>() {
                    });

                    call = m.get(EventTicker.class.getName());
                } else if (HibtcApiConstants.DEPTH.equalsIgnoreCase(channel)) {
                    event = mapper.readValue(text, new TypeReference<EventDepth>() {
                    });

                    call = m.get(EventDepth.class.getName());
                } else if (HibtcApiConstants.TRADE.equalsIgnoreCase(channel)) {
                    JSONObject js = (JSONObject) JSONObject.parse(text);
                    List<String[]> dataArray = JSONObject.parseArray(js.getString(HibtcApiConstants.JSON_DATA), String[].class);
                    JSONArray jsonArra = buildJSON.buildTrade(dataArray);
                    js.put("data", jsonArra);
                    text = js.toJSONString();
                    event = mapper.readValue(text, new TypeReference<EventTrade>() {
                    });

                    call = m.get(EventTrade.class.getName());
                } else if (HibtcApiConstants.KLINE.equalsIgnoreCase(channel)) {
                    JSONObject js = (JSONObject) JSONObject.parse(text);
                    List<String[]> dataArray = JSONObject.parseArray(js.getString(HibtcApiConstants.JSON_DATA), String[].class);
                    JSONArray jsonArra = buildJSON.buildKline(dataArray);
                    js.put(HibtcApiConstants.JSON_DATA, jsonArra);
                    text = js.toJSONString();
                    event = mapper.readValue(text, new TypeReference<EventKLine>() {
                    });

                    call = m.get(EventKLine.class.getName());
                } else if (HibtcApiConstants.AUTH_TRADE.equalsIgnoreCase(channel)) {
                    if (!flag) errorInfo();
                    JSONObject js = (JSONObject) JSONObject.parse(text);
                    List<String[]> dataArray = JSONObject.parseArray(js.getString(HibtcApiConstants.JSON_DATA), String[].class);
                    JSONArray jsonArra = buildJSON.buildHisTrade(dataArray);
                    js.put(HibtcApiConstants.JSON_DATA, jsonArra);
                    text = js.toJSONString();
                    event = mapper.readValue(text, new TypeReference<EventListTrade>() {
                    });
                    call = m.get(EventListTrade.class.getName());
                } else if (HibtcApiConstants.AUTH_ORDER.equalsIgnoreCase(channel)) {
                    if (!flag) errorInfo();
                    JSONObject js = (JSONObject) JSONObject.parse(text);
                    List<String[]> dataArray = JSONObject.parseArray(js.getString(HibtcApiConstants.JSON_DATA), String[].class);
                    JSONArray jsonArra = buildJSON.buildOrder(dataArray);
                    js.put(HibtcApiConstants.JSON_DATA, jsonArra);
                    text = js.toJSONString();
                    event = mapper.readValue(text, new TypeReference<EventOrder>() {
                    });
                    call = m.get(EventOrder.class.getName());
                } else if (HibtcApiConstants.AUTH_WALLET.equalsIgnoreCase(channel)) {
                    if (!flag) errorInfo();
                    event = mapper.readValue(text, new TypeReference<EventWallet>() {
                    });

                    call = m.get(EventWallet.class.getName());
                } else if (HibtcApiConstants.AUTH_HIS_TRADES.equalsIgnoreCase(channel)) {
                    if (!flag) errorInfo();
                    JSONObject js = (JSONObject) JSONObject.parse(text);
                    List<String[]> dataArray = JSONObject.parseArray(js.getString(HibtcApiConstants.JSON_DATA), String[].class);
                    JSONArray jsonArra = buildJSON.buildHisTrade(dataArray);
                    js.put(HibtcApiConstants.JSON_DATA, jsonArra);
                    event = mapper.readValue(js.toJSONString(), new TypeReference<HisListTrade>() {
                    });

                    call = m.get(HisListTrade.class.getName());
                } else if (HibtcApiConstants.AUTH_HIS_ORDERS.equalsIgnoreCase(channel)) {
                    if (!flag) errorInfo();
                    JSONObject js = (JSONObject) JSONObject.parse(text);
                    List<String[]> dataArray = JSONObject.parseArray(js.getString(HibtcApiConstants.JSON_DATA), String[].class);
                    JSONArray jsonArra = buildJSON.buildOrder(dataArray);
                    js.put(HibtcApiConstants.JSON_DATA, jsonArra);
                    text = js.toJSONString();
                    event = mapper.readValue(text, new TypeReference<HisListOrder>() {
                    });

                    call = m.get(HisListOrder.class.getName());
                } else if (HibtcApiConstants.AUTH_MAKE_ORDER.equalsIgnoreCase(channel)) {
                    if (!flag) errorInfo();
                    event = mapper.readValue(text, new TypeReference<MKOrderResponse>() {
                    });

                    call = m.get(MKOrderResponse.class.getName());
                } else if (HibtcApiConstants.AUTH_CANCLE_ORDER.equalsIgnoreCase(channel)) {
                    if (!flag) errorInfo();
                    event = mapper.readValue(text, new TypeReference<CancleOrderResponse>() {
                    });

                    call = m.get(CancleOrderResponse.class.getName());
                }
                if (null != call) call.onResponse(event);
            } catch (IOException e) {
                e.printStackTrace();
                if (null != call) call.onFailure(new HibtcApiException(e));
                throw new HibtcApiException(e);
            }
        }
    }

    @Override
    public void onClosing(final WebSocket webSocket, final int code, final String reason) {
        closing = true;
    }

    public void errorInfo() {
        HibtcApiError error = new HibtcApiError();
        error.setCode(-1);
        error.setMsg("please login first");
        throw new HibtcApiException(error);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        if (!closing) {
            if (null != call)
                call.onFailure(t);
        }
    }

    @Override
    public void onClosed(final WebSocket webSocket, final int code, final String reason) {
        webSocket.close(1000, null);
    }
}
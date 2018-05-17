package com.guanyou.hibtc.impl.build;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author seif
 * @Description:
 * @date 2018/5/1412:01
 * @Modified by:
 */
public class BuildJSON {
    public  JSONArray buildKline(List<String[]> jsonArray) {
        JSONArray jsonArra = new JSONArray();
        for (String[] str : jsonArray) {
            JSONObject jso = new JSONObject();
            jso.put("timestamp", str[0]);
            jso.put("open_price", str[1]);
            jso.put("high_price", str[2]);
            jso.put("low_price", str[3]);
            jso.put("close_price", str[4]);
            jso.put("volume", str[5]);
            jsonArra.add(jso);
        }
        return jsonArra;
    }

    public JSONArray buildTrade(List<String[]> jsonArray) {
        JSONArray jsonArra = new JSONArray();
        for (String[] str : jsonArray) {
            JSONObject jso = new JSONObject();
            jso.put("trade_id", str[0]);
            jso.put("price", str[1]);
            jso.put("volume", str[2]);
            jso.put("timestamp", str[3]);
            jso.put("isbid", str[4]);
            jsonArra.add(jso);
        }
        return jsonArra;
    }

    public  JSONArray buildOrder(List<String[]> jsonArray) {
        JSONArray jsonArra = new JSONArray();
        for (String[] str : jsonArray) {
            JSONObject jso = new JSONObject();
            jso.put("order_id", str[0]);
            jso.put("pair", str[1]);
            jso.put("timestamp", str[2]);
            jso.put("volume", str[3]);
            jso.put("amount", str[4]);
            jso.put("place_price", str[5]);
            jso.put("trade_price", str[6]);
            jso.put("order_type", str[7]);
            jso.put("associated_order", str[8]);
            jso.put("order_status", str[9]);
            jsonArra.add(jso);
        }
        return jsonArra;
    }

    public  JSONArray buildHisTrade(List<String[]> jsonArray) {
        JSONArray jsonArra = new JSONArray();
        for (String[] str : jsonArray) {
            JSONObject jso = new JSONObject();
            jso.put("trade_id", str[0]);
            jso.put("pair", str[1]);
            jso.put("timestamp", str[2]);
            jso.put("trade_price", str[3]);
            jso.put("price", str[4]);
            jso.put("trade_amount", str[5]);
            jso.put("orderType", str[6]);
            jso.put("related_orders", str[7]);
            jso.put("fee", str[8]);
            jsonArra.add(jso);
        }
        return jsonArra;
    }
}

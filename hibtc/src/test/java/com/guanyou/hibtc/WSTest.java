package com.guanyou.hibtc;

import com.guanyou.hibtc.domain.Event.*;
import com.guanyou.hibtc.domain.account.AuthInfo;
import com.guanyou.hibtc.impl.ws.HibtcApiWebSocketListener;
import com.guanyou.hibtc.ws.HibtcApiCallback;
import com.guanyou.hibtc.ws.HibtcApiWebSocketClient;
import okhttp3.WebSocket;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/1514:25
 * @Modified by:
 */
public class WSTest {
    public static void main(String[] args) throws Exception {
        HibtcApiClientFactory fc = HibtcApiClientFactory.newInstance();
        HibtcApiWebSocketClient client = fc.newWebSocketClient();
        HibtcApiWebSocketListener listner = new HibtcApiWebSocketListener();

        listner.addProcess(response -> System.out.println(response + "*****1"), EventTicker.class)
                .addProcess(response -> System.out.println(response + "*****2"), EventDepth.class)
                .addProcess(response -> System.out.println(response + "*****3"), EventTrade.class)
                .addProcess(response -> System.out.println(response + "*****4"), EventKLine.class)
                .addProcess(response -> System.out.println(response + "*****5"), EventListTrade.class)
                .addProcess(response -> System.out.println(response + "*****6"), EventOrder.class)
                .addProcess(response -> System.out.println(response + "*****7"), CancleSubResponse.class)
                .addProcess(response -> System.out.println(response + "*****8"), EventWallet.class)
                .addProcess(response -> System.out.println(response + "*****9"), HisListTrade.class)
                .addProcess(response -> System.out.println(response + "*****10"), HisListOrder.class)
                .addProcess(response -> System.out.println(response + "*****11"), MKOrderResponse.class)
                .addProcess(response -> System.out.println(response + "*****12"), CancleOrderResponse.class)
                .addProcess(response -> System.out.println(response + "*****13"),LoginResult.class);

//        WebSocket webSocket = client.createNewWebSocket(listner);
        WebSocket webSocket = client.createNewWebSocket("wss://api.hibtc.com/wsjoint",listner);


        AuthInfo authInfo = new AuthInfo();
        authInfo.setApi_key("your api key");
        authInfo.setAuth_key("12345");
        authInfo.setAuth_nonce(String.valueOf(System.currentTimeMillis()));
        authInfo.setApiSecret("your api secret");


        webSocket.send(client.onEventOrderBook("ETH_BTC", 20, 1));
//        webSocket.send(client.onEventTicker("ETH_BTC"));
//        webSocket.send(client.onEventTrade("ETH_BTC", 10));
//        webSocket.send(client.onEventKLine("ETH_BTC", "1", System.currentTimeMillis() - 100000, System.currentTimeMillis()));
//        webSocket.send(client.onAuthInfo(authInfo));//LONGGIN
//        webSocket.send(client.onEventAuthHisOrders(10, 1));
//        webSocket.send(client.makeLimitBuyOrder("ETH_BTC", "0.01", "0.01"));
//        webSocket.send(client.makeLimitSellOrder("ETH_BTC", "0.01", "0.01"));
//        webSocket.send(client.makeMarketBuyOrder("ETH_BTC", "0.01"));
//        webSocket.send(client.makeMarketSellOrder("ETH_BTC", "0.01"));
//        webSocket.send(client.makeStopBuyOrder("ETH_BTC", "0.01", "0.01", "0.005"));
//        webSocket.send(client.makeStopSellOrder("ETH_BTC", "0.01", "0.01", "0.005"));
//        webSocket.send(client.onEventAuthOrders());
//        webSocket.send(client.onEventAuthHistrades(20, 1));
//        webSocket.send(client.onEventAutnTrades(10));
//        webSocket.send(client.cancelOrder("ETH_BTC", "1234567"));
//        webSocket.send(client.onEventCancelKLine("ETH_BTC"));
//        webSocket.send(client.onEventCancelOrdereBook("ETH_BTC"));
//        webSocket.send(client.onEventCancelTicker("ETH_BTC"));
//        webSocket.send(client.onEventCancelTrades("ETH_BTC"));
//        webSocket.send(client.onEventCancelALL("ETH_BTC"));
//        webSocket.close(1000, "BYE");
    }
}

package com.guanyou.hibtc.ws;

import com.guanyou.hibtc.domain.account.AuthInfo;
import com.guanyou.hibtc.impl.ws.HibtcApiWebSocketListener;
import okhttp3.WebSocket;


/**
 * Hibtc API data streaming façade, supporting streaming of events through web sockets.
 */
public interface HibtcApiWebSocketClient {

    /**
     * Direct subscription
     *
     * @param pair
     * @param
     * @return
     */
    String onEventTicker(String pair);

    String onEventOrderBook(String pair, int depth, int prec);

    String onEventTrade(String pair, int last);

    String onEventOrderBook(String pair, int depth);

    String onEventKLine(String pair, String type, long time_start, long time_end);

    String onEventCancelKLine(String pair);

    String onEventCancelTrades(String pair);

    String onEventCancelOrdereBook(String pair);

    String onEventCancelALL(String pair);

    String onEventCancelTicker(String pair);

    /**
     * need to log in and subscribe.
     *
     * @param last
     * @param
     */
    String onEventAutnTrades(int last);

    String onEventAuthOrders();

    String onEventAuthWallet();

    String onEventAuthHistrades(int pageSize, int pageIndex);

    String onEventAuthHisOrders(int pageSize, int pageIndex);

    /**
     * Place order - price limit.
     *
     * @param pair
     * @param price
     * @param amount
     * @param
     */
    String makeLimitBuyOrder(String pair, String price, String amount);

    String makeLimitSellOrder(String pair, String price, String amount);

    /**
     * Place to market
     *
     * @param pair
     * @param money
     * @param
     */
    String makeMarketBuyOrder(String pair, String money);

    String makeMarketSellOrder(String pair, String money);

    /**
     * Place order - stop limit
     *
     * @param pair
     * @param price
     * @param amount
     * @param stop_price
     * @param
     */
    String makeStopBuyOrder(String pair, String price, String amount, String stop_price);

    String makeStopSellOrder(String pair, String price, String amount, String stop_price);

    /**
     * Cancel the order
     *
     * @param
     * @param pair
     * @param orderId
     * @param
     * @return
     */
    String cancelOrder(String pair, String orderId);

    /**
     * The login information
     * @param authInfo
     * @return
     */
    String onAuthInfo(AuthInfo authInfo);

    /**
     * Create wesocket
     * @param listener
     * @return
     */
    WebSocket createNewWebSocket(HibtcApiWebSocketListener listener);
    WebSocket createNewWebSocket(String url,HibtcApiWebSocketListener listener);


}

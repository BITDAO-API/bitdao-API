package com.guanyou.hibtc.rest;

import com.guanyou.hibtc.domain.Event.*;
import com.guanyou.hibtc.domain.account.AuthInfo;
import com.guanyou.hibtc.domain.bb.OrderResponse;
import com.guanyou.hibtc.ws.HibtcApiCallback;

import java.util.List;

/**
 * Hibtc API façade, supporting synchronous/blocking access Hibtc's REST API.
 */
public interface HibtcApiAsynRestClient {
    /**
     * The ticker channel provides real-time price updates every time a match happens.
     *
     * @param pair
     *
     */
    void getTicker(String pair,HibtcApiCallback<Object> callback);

    /**
     * Order Book / Depth
     *
     * @param pair
     * @param depth
     * @param prec  precedence
     *
     */
    void getOrderBook(String pair, int depth, int prec,HibtcApiCallback<Object> callback);

    /**
     * Kline
     *
     * @param pair
     * @param type
     * @param time_start
     * @param time_end
     *
     */
    void getKLine(String pair, String type, long time_start, long time_end,HibtcApiCallback<Object> callback);

    /**
     * Trades
     *
     * @param pair
     * @param last
     *
     */
    void getTrade(String pair, int last,HibtcApiCallback<Object> callback);

    /**
     * Cancel an Order
     *
     * @param authInfo
     * @param pair
     * @param order_id
     *
     */
    void cancleOrder(AuthInfo authInfo, String pair, String order_id,HibtcApiCallback<Object> callback);

    /**
     * List Orders
     *
     * @param authInfo
     *
     */
    void getOderList(AuthInfo authInfo,HibtcApiCallback<Object> callback);

    /**
     * List Order History
     *
     * @param authInfo
     * @param page_size
     * @param page_index
     *
     */
    void getHistoryOrders(AuthInfo authInfo, int page_size, int page_index,HibtcApiCallback<Object> callback);

    /**
     * List Trade
     *
     * @param authInfo
     * @param last
     *
     */
    void getTradeList(AuthInfo authInfo, int last,HibtcApiCallback<Object> callback);

    /**
     * List Trade History
     *
     * @param authInfo
     * @param page_size
     * @param page_index
     *
     */
    void getHistoryTrades(AuthInfo authInfo, int page_size, int page_index,HibtcApiCallback<Object> callback);

    /**
     * Wallet Balance
     *
     * @param authInfo
     *
     */
    void getWalletBalance(AuthInfo authInfo,HibtcApiCallback<Object> callback);

    /**
     * Place a limit Order for buy
     *
     * @param authInfo
     * @param pair
     * @param price
     * @param amount
     *
     */
    void makeLimitBuyOrder(AuthInfo authInfo, String pair, String price, String amount,HibtcApiCallback<Object> callback);

    /**
     * Place a limit Order for sell
     *
     * @param authInfo
     * @param pair
     * @param price
     * @param amount
     *
     */
    void makeLimitSellOrder(AuthInfo authInfo, String pair, String price, String amount,HibtcApiCallback<Object> callback);

    /**
     * Place a market Order for buy
     *
     * @param authInfo
     * @param pair
     * @param money
     *
     */
    void makeMarketBuyOrder(AuthInfo authInfo, String pair, String money,HibtcApiCallback<Object> callback);

    /**
     * Place a market Order for sell
     *
     * @param authInfo
     * @param pair
     * @param money
     *
     */
    void makeMarketSellOrder(AuthInfo authInfo, String pair, String money,HibtcApiCallback<Object> callback);

    /**
     * Place a stop-limit Order for buy
     *
     * @param authInfo
     * @param pair
     * @param price
     * @param amount
     * @param stop_price
     *
     */
    void makeStopBuyOrder(AuthInfo authInfo, String pair, String price, String amount, String stop_price,HibtcApiCallback<Object> callback);

    /**
     * Place a stop-limit Order for sell
     *
     * @param authInfo
     * @param pair
     * @param price
     * @param amount
     * @param stop_price
     *
     */
    void makeStopSellOrder(AuthInfo authInfo, String pair, String price, String amount, String stop_price,HibtcApiCallback<Object> callback);

}

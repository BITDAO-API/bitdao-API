package com.guanyou.hibtc.rest;

import com.guanyou.hibtc.domain.Event.*;
import com.guanyou.hibtc.domain.account.AuthInfo;
import com.guanyou.hibtc.domain.bb.OrderResponse;

/**
 * Hibtc API façade, supporting synchronous/blocking access Hibtc's REST API.
 */
public interface HibtcApiRestClient {
    /**
     * The ticker channel provides real-time price updates every time a match happens.
     *
     * @param pair
     * @return
     */
    EventTicker getTicker(String pair);

    /**
     * Order Book / Depth
     *
     * @param pair
     * @param depth
     * @param prec  precedence
     * @return
     */
    EventDepth getOrderBook(String pair, int depth, int prec);

    /**
     * Kline
     *
     * @param pair
     * @param type
     * @param time_start
     * @param time_end
     * @return
     */
    EventKLine getKLine(String pair, String type, long time_start, long time_end);

    /**
     * Trades
     *
     * @param pair
     * @param last
     * @return
     */
    EventTrade getTrade(String pair, int last);

    /**
     * Cancel an Order
     *
     * @param authInfo
     * @param pair
     * @param order_id
     * @return
     */
    CancleOrderResponse cancleOrder(AuthInfo authInfo, String pair, String order_id);

    /**
     * List Orders
     *
     * @param authInfo
     * @return
     */
    EventOrder getOderList(AuthInfo authInfo);

    /**
     * List Order History
     *
     * @param authInfo
     * @param page_size
     * @param page_index
     * @return
     */
    HisListOrder getHistoryOrders(AuthInfo authInfo, int page_size, int page_index);

    /**
     * List Trade
     *
     * @param authInfo
     * @param last
     * @return
     */
    EventListTrade getTradeList(AuthInfo authInfo, int last);

    /**
     * List Trade History
     *
     * @param authInfo
     * @param page_size
     * @param page_index
     * @return
     */
    HisListTrade getHistoryTrades(AuthInfo authInfo, int page_size, int page_index);

    /**
     * Wallet Balance
     *
     * @param authInfo
     * @return
     */
    EventWallet getWalletBalance(AuthInfo authInfo);

    /**
     * Place a limit Order for buy
     *
     * @param authInfo
     * @param pair
     * @param price
     * @param amount
     * @return
     */
    OrderResponse makeLimitBuyOrder(AuthInfo authInfo, String pair, String price, String amount);

    /**
     * Place a limit Order for sell
     *
     * @param authInfo
     * @param pair
     * @param price
     * @param amount
     * @return
     */
    OrderResponse makeLimitSellOrder(AuthInfo authInfo, String pair, String price, String amount);

    /**
     * Place a market Order for buy
     *
     * @param authInfo
     * @param pair
     * @param money
     * @return
     */
    OrderResponse makeMarketBuyOrder(AuthInfo authInfo, String pair, String money);

    /**
     * Place a market Order for sell
     *
     * @param authInfo
     * @param pair
     * @param money
     * @return
     */
    OrderResponse makeMarketSellOrder(AuthInfo authInfo, String pair, String money);

    /**
     * Place a stop-limit Order for buy
     *
     * @param authInfo
     * @param pair
     * @param price
     * @param amount
     * @param stop_price
     * @return
     */
    OrderResponse makeStopBuyOrder(AuthInfo authInfo, String pair, String price, String amount, String stop_price);

    /**
     * Place a stop-limit Order for sell
     *
     * @param authInfo
     * @param pair
     * @param price
     * @param amount
     * @param stop_price
     * @return
     */
    OrderResponse makeStopSellOrder(AuthInfo authInfo, String pair, String price, String amount, String stop_price);

}

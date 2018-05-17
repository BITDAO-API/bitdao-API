package com.guanyou.hibtc.constant;

import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Constants used throughout Hibtc's API.
 */
public class HibtcApiConstants {

    /**
     * REST API base URL.
     */
    public static final String API_BASE_URL = "https://api.hibtc.com";

    /**
     * Streaming API base URL.
     */
    public static final String WS_API_BASE_URL = "wss://api.hibtc.com/wsjoint";


    /**
     * Default ToStringStyle used by toString methods.
     * Override this to change the output format of the overridden toString methods.
     * - Example ToStringStyle.JSON_STYLE
     */
    public static ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;

    public static final String TICKER ="ticker";
    public static final String  DEPTH="depth";
    public static final String TRADE ="trades";
    public static final String  KLINE="kline";
    public static final String  AUTH_TRADE="auth-trades";
    public static final String  AUTH_ORDER="auth-orders";
    public static final String  AUTH_WALLET="auth-wallet";
    public static final String  AUTH_HIS_TRADES="auth-trades-history";
    public static final String  AUTH_HIS_ORDERS="auth-orders-history";
    public static final String  AUTH_MAKE_ORDER="auth-make-order";
    public static final String  AUTH_CANCLE_ORDER="auth-cancel-order";
    public static final String  CANCLE_SUB="cancel_subscribe";
    public static final String  JSON_EVENT="event";
    public static final String  JSON_DATA="data";
    public static final String  JSON_CHINNEL="channel";


}

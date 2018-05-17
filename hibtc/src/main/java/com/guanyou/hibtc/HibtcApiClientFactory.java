package com.guanyou.hibtc;

import com.guanyou.hibtc.impl.rest.HibtcApiAsynRestClientImpl;
import com.guanyou.hibtc.impl.rest.HibtcApiRestClientImpl;
import com.guanyou.hibtc.impl.rest.HibtcApiServiceGenerator;
import com.guanyou.hibtc.impl.ws.HibtcApiWebSocketClientImpl;
import com.guanyou.hibtc.rest.HibtcApiAsynRestClient;
import com.guanyou.hibtc.rest.HibtcApiRestClient;
import com.guanyou.hibtc.ws.HibtcApiWebSocketClient;

/**
 * A factory for creating HibtcApi client objects.
 */
public class HibtcApiClientFactory {

    private HibtcApiClientFactory() {

    }

    /**
     * New instance
     *
     * @return the Hibtc api client factory
     */
    public static HibtcApiClientFactory newInstance() {
        return new HibtcApiClientFactory();
    }

    /**
     * Creates a new  REST client.
     */
    public HibtcApiRestClient newRestClient(HibtcApiServiceGenerator server) {
        return new HibtcApiRestClientImpl(server);
    }

    /**
     * Creates a new asyn REST client.
     */
    public HibtcApiAsynRestClient newRestAsynClient(HibtcApiServiceGenerator server) {
        return new HibtcApiAsynRestClientImpl(server);
    }

    /**
     * Creates a new web socket client used for handling data streams.
     */

    public HibtcApiWebSocketClient newWebSocketClient() {
        return new HibtcApiWebSocketClientImpl();
    }




}

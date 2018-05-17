package com.guanyou.hibtc;

import com.guanyou.hibtc.domain.account.AuthInfo;
import com.guanyou.hibtc.impl.rest.HibtcApiServiceGenerator;
import com.guanyou.hibtc.rest.HibtcApiAsynRestClient;
import com.guanyou.hibtc.rest.HibtcApiRestClient;
import com.guanyou.hibtc.ws.HibtcApiCallback;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/1610:44
 * @Modified by:
 */
public class RestAsynTest {
    public static void main(String[] args) {
        HibtcApiClientFactory fc = HibtcApiClientFactory.newInstance();
        AuthInfo authInfo = new AuthInfo();
        authInfo.setApi_key("NDM2MjU5OTY2NDI1ODcyODA4OzE1MjQwNTQzNzkwMDA7MTUyNTc3NTIyMzAzMzszNjY4OTtiMDk1OGJhMWU1NjkwNTlmNTEyY2Q4ZjNkNTE0ZWVjZg==");
        authInfo.setAuth_key("12345");
        authInfo.setAuth_nonce(String.valueOf(System.currentTimeMillis()));
        authInfo.setApiSecret("NDM2MjU5OTY2NDI1ODcyODA4OzE1MjQwNTQzNzkwMDA7MTUyNTc3NTIxNjkxODszMDU3NDsxNDNhYzA5MzMxOGEwZGRkNWQyNjliMDQ3Yzk3MmVlZg==");

        HibtcApiServiceGenerator hi = new HibtcApiServiceGenerator("https://api.hibtc.com");
        HibtcApiAsynRestClient re = fc.newRestAsynClient(hi);



//        re.getTicker("ETH_BTC", response -> System.out.println(response+"***1"));
//        re.getTrade("ETH_BTC",10, response -> System.out.println(response+"***2"));
//        re.getKLine("ETH_BTC","1",System.currentTimeMillis()-10000,System.currentTimeMillis(), response -> System.out.println(response+"***3"));
//        re.getOrderBook("ETH_BTC",10,1,  response -> System.out.println(response+"***4"));
//        re.getHistoryOrders(authInfo,10,1, response -> System.out.println(response+"***5"));
//        re.getHistoryTrades(authInfo,10,1, response -> System.out.println(response+"***6"));
//        re.getOderList(authInfo,  response -> System.out.println(response+"***7"));
//        re.getTradeList(authInfo,10,  response -> System.out.println(response+"***8"));
//        re.getWalletBalance(authInfo,  response -> System.out.println(response+"***9"));
//        re.makeLimitBuyOrder(authInfo,"ETH_BTC","0.01","0.01", response -> System.out.println(response+"***10"));
//        re.makeLimitSellOrder(authInfo,"ETH_BTC","0.01","0.01",  response -> System.out.println(response+"***11"));
//        re.makeMarketBuyOrder(authInfo,"ETH_BTC","0.01",  response -> System.out.println(response+"***12"));
//        re.makeMarketSellOrder(authInfo,"ETH_BTC","0.01", response -> System.out.println(response+"***13"));
//        re.makeStopBuyOrder(authInfo,"ETH_BTC","0.01","0.01","0.005", response -> System.out.println(response+"***14"));
//        re.makeStopSellOrder(authInfo,"ETH_BTC","0.01","0.01","0.005", response -> System.out.println(response+"***15"));
//        re.cancleOrder(authInfo,"ETH_BTC","446302115069478912", response -> System.out.println(response+"***16"));





    }
}

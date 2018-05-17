package com.guanyou.hibtc;

import com.guanyou.hibtc.domain.account.AuthInfo;
import com.guanyou.hibtc.impl.rest.HibtcApiServiceGenerator;
import com.guanyou.hibtc.rest.HibtcApiRestClient;

/**
 * @author seif
 * @Description: TODO
 * @date 2018/5/1520:16
 * @Modified by:
 */
public class RestTest {

    public static void main(String[] args) {
//        SpringApplication.run(HibtcApplication.class, args);

        HibtcApiClientFactory fc = HibtcApiClientFactory.newInstance();
        AuthInfo authInfo = new AuthInfo();
        authInfo.setApi_key("NDM2MjU5OTY2NDI1ODcyODA4OzE1MjQwNTQzNzkwMDA7MTUyNTc3NTIyMzAzMzszNjY4OTtiMDk1OGJhMWU1NjkwNTlmNTEyY2Q4ZjNkNTE0ZWVjZg==");
        authInfo.setAuth_key("12345");
        authInfo.setAuth_nonce(String.valueOf(System.currentTimeMillis()));
        authInfo.setApiSecret("NDM2MjU5OTY2NDI1ODcyODA4OzE1MjQwNTQzNzkwMDA7MTUyNTc3NTIxNjkxODszMDU3NDsxNDNhYzA5MzMxOGEwZGRkNWQyNjliMDQ3Yzk3MmVlZg==");
//        HibtcApiServiceGenerator hi=new HibtcApiServiceGenerator();
        HibtcApiServiceGenerator hi=new HibtcApiServiceGenerator("https://api.hibtc.com");
        HibtcApiRestClient re = fc.newRestClient(hi);
////        1. 行情（ticker）
//        Object obj1 = re.getTicker("ETH_BTC");
//        System.out.println(obj1 + "++++++++++++1");
//        //        1. 行情（ticker）
//        Object obj2 = re.getOrderBook("ETH_BTC", 20, 1);
//        System.out.println(obj2 + "++++++++++++2");
////        3. 交易（trades）
//        Object obj3 = re.getTrade("ETH_BTC", 10);
//        System.out.println(obj3 + "++++++++++++3");
////        4. K线图（kline）
//        Object obj4 = re.getKLine("ETH_BTC", "1", System.currentTimeMillis() - 100000000, System.currentTimeMillis());
//        System.out.println(obj4 + "++++++++++++4");
////        2. 个人成交订阅( / bb / api / auth / trades)
//        Object obj5 = re.getTradeList(authInfo, 10);
//        System.out.println(obj5 + "++++++++++++5");
////        3. 个人订单订阅( / bb / api / auth / orders)
//        Object obj6 = re.getOderList(authInfo);
//        System.out.println(obj6 + "++++++++++++6");
////        4. 个人账户变化订阅( / bb / api / auth / wallet)
//        Object obj7 = re.getWalletBalance(authInfo);
//        System.out.println(obj7 + "++++++++++++7");
////        5. 个人历史成交查询( / bb / api / query / trades)
//        Object obj8 = re.getHistoryTrades(authInfo, 10, 1);
//        System.out.println(obj8 + "++++++++++++8");
////        6. 个人历史订单查询( / bb / api / query / orders)
//        Object obj9 = re.getHistoryOrders(authInfo, 10, 1);
//        System.out.println(obj9 + "++++++++++++9");
////        7. 下单( / bb / api / make / order)
//        Object obj10 = re.makeLimitBuyOrder(authInfo, "ETH_BTC", "0.01", "1");
//        System.out.println(obj10 + "++++++++++++10");
//        Object obj11 = re.makeLimitSellOrder(authInfo, "ETH_BTC", "0.01", "1");
//        System.out.println(obj11 + "++++++++++++11");
//        Object obj12 = re.makeMarketBuyOrder(authInfo, "ETH_BTC", "0.01");
//        System.out.println(obj12 + "++++++++++++12");
//        Object obj13 = re.makeMarketSellOrder(authInfo, "ETH_BTC", "0.01");
//        System.out.println(obj13 + "++++++++++++13");
//        Object obj14 = re.makeStopBuyOrder(authInfo, "ETH_BTC", "0.01", "1", "0.005");
//        System.out.println(obj14 + "++++++++++++14");
//        Object obj15 = re.makeStopSellOrder(authInfo, "ETH_BTC", "0.01", "1", "0.005");
//        System.out.println(obj15 + "++++++++++++15");
////        8. 撤单( / bb / api / cancel / order).
//        Object obj16 = re.cancleOrder(authInfo, "ETH_BTC", "445528112839051264");
//        System.out.println(obj16 + "++++++++++++16");

    }
}

# hibtc
                      ************** wesocket ********************
##create wesocketclient

    HibtcApiClientFactory fc = HibtcApiClientFactory.newInstance();
    
    HibtcApiWebSocketClient client = fc.newWebSocketClient();
    
##create listenner

    HibtcApiWebSocketListener listner = new HibtcApiWebSocketListener();
##add observer

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
##create websocket

     WebSocket webSocket = client.createNewWebSocket(listner);//default url
     
     WebSocket webSocket = client.createNewWebSocket("wss://api.hibtc.com/wsjoint",listner);//Add the url yourself

##get information

     example: wSocket.send(client.onEventOrderBook("ETH_BTC", 20, 1));




                     ******************* rest *******************
##create httpservice

    HibtcApiServiceGenerator service=new HibtcApiServiceGenerator();//default  url
    
    HibtcApiServiceGenerator service=new HibtcApiServiceGenerator("https://api.hibtc.com");//Add the url yourself
##create restclient

    HibtcApiClientFactory fc = HibtcApiClientFactory.newInstance();
    
    HibtcApiRestClient client = fc.newRestClient(service);
    
##get information

    example:Object obj1 = client.getTicker("ETH_BTC");


##create asynchronous rest

    HibtcApiClientFactory fc = HibtcApiClientFactory.newInstance();
   
    HibtcApiAsynRestClient client = fc.newRestAsynClient(service);
   
##get information

    example:re.getTicker("ETH_BTC", response -> System.out.println(response+"***1"));


package com.froyo.hazelcast.common;

import com.hazelcast.client.config.ClientConfig;


public class CommonConfig {

    public static String HOSTNAME = "127.0.0.1";
    public static String PORT = "5701";
    
    private final ClientConfig clientConfig = new ClientConfig();        
    
    public CommonConfig() {
        
        getClientConfig().addAddress(HOSTNAME + ":" + PORT);
    }

    public ClientConfig getClientConfig() {
        return clientConfig;
    }
    
    
    
}

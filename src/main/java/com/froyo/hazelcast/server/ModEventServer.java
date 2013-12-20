package com.froyo.hazelcast.server;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;

public class ModEventServer {       

    public static void main(String[] args) {
        
        Config cfg = new Config();
        
        Hazelcast.newHazelcastInstance(cfg);                                             
    }    
}

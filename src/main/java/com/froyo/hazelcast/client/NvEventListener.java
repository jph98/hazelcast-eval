package com.froyo.hazelcast.client;

import java.util.concurrent.TimeUnit;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;
import com.froyo.hazelcast.common.FileEvents;

public class NvEventListener {

    public NvEventListener() throws InterruptedException {

        HazelcastInstance client = null;

        try {

            client = HazelcastClient.newHazelcastClient();

            IQueue<Object> queue = client.getQueue(FileEvents.RENAME_EVENTS);
                                   
            String msg = (String) queue.poll(1, TimeUnit.SECONDS);
            
            System.out.println("Message received: " + msg);
            System.out.println("Queue Size:" + queue.size());

        } finally {
            client.shutdown();
        }

    }

    public static void main(String[] args) {

        NvEventListener client = new NvEventListener();
    }
}

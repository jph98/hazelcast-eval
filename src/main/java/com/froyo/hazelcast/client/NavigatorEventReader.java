package com.froyo.hazelcast.client;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;
import com.froyo.hazelcast.common.FileEvents;

public class NavigatorEventReader {

    private HazelcastInstance client;

    public NavigatorEventReader() {

        client = HazelcastClient.newHazelcastClient();

    }

    public void readMessages() {

        IQueue<Object> queue = client.getQueue(FileEvents.RENAME_EVENTS);

        System.out.println("Queue Size:" + queue.size());

        System.out.println("Reading...");

        while (queue.iterator().hasNext()) {
            String m = (String) queue.iterator().next();
            System.out.println(m);
            queue.remove(m);
        }

    }

    public void shutdown() {
        client.shutdown();
    }

    public static void main(String[] args) {

        NavigatorEventReader client = new NavigatorEventReader();
    }
}

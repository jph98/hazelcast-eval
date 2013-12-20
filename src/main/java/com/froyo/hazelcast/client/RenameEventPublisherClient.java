package com.froyo.hazelcast.client;

import java.util.Queue;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.froyo.hazelcast.common.FileEvents;

public class RenameEventPublisherClient {

    private HazelcastInstance client = null;

    public RenameEventPublisherClient() {

        client = HazelcastClient.newHazelcastClient();

    }

    public void publish() {

        Queue<String> queue = client.getQueue(FileEvents.RENAME_EVENTS);
        String message = "nonmem1.ctl renamed to nonmem2.ctl";
        queue.offer(message);
        System.out.println("Number of events on queue after publish: " + queue.size());

    }

    public void shutdown() {
        client.shutdown();
    }

    public static void main(String[] args) {
        new RenameEventPublisherClient();
    }

}

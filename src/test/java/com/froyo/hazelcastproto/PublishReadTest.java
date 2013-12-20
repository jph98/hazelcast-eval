package com.froyo.hazelcastproto;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.froyo.hazelcast.client.NvEventReader;
import com.froyo.hazelcast.client.RenameEventPublisherClient;
import com.froyo.hazelcast.common.FileEvents;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

public class PublishReadTest {

    @Test
    public void shouldPublishAndReadMessages() {
        
        HazelcastInstance assertClient = HazelcastClient.newHazelcastClient();
        IQueue<Object> queue = assertClient.getQueue(FileEvents.RENAME_EVENTS);
        
        RenameEventPublisherClient client = new RenameEventPublisherClient();
        client.publish();
        client.publish();
        client.publish();
        client.shutdown();        
        assertThat(queue.size(), equalTo(3));
        
        NvEventReader reader = new NvEventReader();
        reader.readMessages();
        reader.shutdown();
        
        assertClient = HazelcastClient.newHazelcastClient();
        queue = assertClient.getQueue(FileEvents.RENAME_EVENTS);        
        assertThat(queue.size(), equalTo(0));
        
    }
}

package com.paladii.school.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by anton.riabov on 8/10/2015.
 */
public class ZkConnectionFactory implements Watcher {

    public static final int SESSION_TIME_OUT = 5000;
    private CountDownLatch countDownLatch = new CountDownLatch(1);



    public void process(WatchedEvent watchedEvent) {
       if (watchedEvent.getState() == Event.KeeperState.SyncConnected){
           countDownLatch.countDown();
       }
    }

    public ZooKeeper getZkConnection(String host) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper(host, SESSION_TIME_OUT, this);
        countDownLatch.await();
        return zooKeeper;
    }
}

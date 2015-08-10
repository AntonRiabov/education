package com.paladii.school.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * Created by anton.riabov on 8/10/2015.
 */
public class HealthWatcher implements Watcher {

    private ZooKeeper zk;

    public HealthWatcher(String host) throws IOException, InterruptedException {
          zk = new ZkConnectionFactory().getZkConnection(host);
    }

    public void setNodeWatcher(String path) throws KeeperException, InterruptedException {
       List<String> children = zk.getChildren(path, this);
        System.out.println("Path: " + path + "\nChildren list:");
        for(String child : children){
            System.out.println(child);
        }
    }

    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
            System.out.println(String.format("Node with path %s was %s  || " + watchedEvent.toString(), watchedEvent.getPath(), watchedEvent.getType().toString()));
            try {
                setNodeWatcher(watchedEvent.getPath());
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        HealthWatcher hw = new HealthWatcher("localhost");

        hw.setNodeWatcher("/Group");

        Thread.sleep(Long.MAX_VALUE);

    }
}

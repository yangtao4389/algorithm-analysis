package cn.angetech.javademo.thread.artConcurrentBook.chapter11;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedTransferQueue;
import java.util.logging.Logger;

/*
 * 总消息队列管理
 *
 * */
public class MsgQueueManager implements IMsgQueue {
    public final BlockingDeque<Message> messageBlockingDeque;

    private MsgQueueManager() {
        messageBlockingDeque = (BlockingDeque<Message>) (new LinkedTransferQueue<Message>());
    }

    public void put(Message msg) {

        try {
            messageBlockingDeque.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Message take() {
        try {
            return messageBlockingDeque.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("hh");
    }

}

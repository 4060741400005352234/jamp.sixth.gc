package jamp.main;

import jamp.task.MemoryConsumer;
import jamp.util.Constant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        start();
        Thread.sleep(Constant.EXPERIMENT_TIME);
        stop();
        System.out.println("Finish.");
    }

    private static void start() {
        ExecutorService execService = Executors.newCachedThreadPool();
        for (int i = 0; i < Constant.NUMBER_OF_REQUEST_THREADS; i++) {
            execService.execute(new MemoryConsumer());
        }
    }

    private static void stop() {
        Constant.stop = true;
    }
}

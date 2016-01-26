package jamp.task;

import jamp.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemoryConsumer implements Runnable {

    @Override
    public void run() {
        while (true && !Constant.stop) {
            makeObjects();
        }
    }

    private void makeObjects() {
        Random rInt = new Random();
        List<byte[]> objectList = new ArrayList<byte[]>();
        for (int i = 0; i < Constant.OBJECTS_NUMBER; i++) {
            objectList.add(new byte[Constant.OBJECT_SIZE + i + Math.abs(rInt.nextInt(1000))]);
        }

        try {
            Thread.sleep(Constant.ADD_PROCESS_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

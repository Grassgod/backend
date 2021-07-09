package com.msc.backend.manage;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerManage {


    @Autowired
    TaskManage taskManage;

    public WorkerManage() {
        // 创建一个固定大小的线程池:
        ExecutorService es = Executors.newFixedThreadPool(4);

        taskManage.getAllTask();

        for (int i = 0; i < 6; i++) {
            es.submit(new Worker("" + i));
        }
        // 关闭线程池:
        es.shutdown();
    }

    public class Worker implements {

        @Override
        public void run() {

        }
    }

}

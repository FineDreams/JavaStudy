package com.yy.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
    /**
     * 通过@Async注解，表示该方法是一个异步方法
     * 如果将@Async注解标识在类的声明上，则表明这个类中所有的方法都是异步的
     * 那个ThreadPoolTaskExecutor作为TaskExecutor
     *
     */
    @Async
    public void executeAsyncTask(Integer integer){
        System.out.println("异步任务执行:"+integer);
    }
    @Async
    public void executeAsyncTaskPlus(Integer integer){
        System.out.println("异步任务执行+1:"+(integer+1));
    }
}

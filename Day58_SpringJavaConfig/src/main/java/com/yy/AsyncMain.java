package com.yy;

import com.yy.config.TaskExecutorConfig;
import com.yy.service.AsyncTaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AsyncMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(TaskExecutorConfig.class);
        context.refresh();
        AsyncTaskService taskService=context.getBean(AsyncTaskService.class);
        for (int i = 0; i <10; i++) {
            taskService.executeAsyncTask(i);
            taskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }
}

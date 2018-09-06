package com.hzf.task.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zf.huang on 2018.9.6
 */

@Component
public class TimerTask {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private int time = 0;

    @Scheduled(cron = "0/1 * * * * ?")
    public void task() {
        System.out.print(format.format(new Date()) + " ...... start task-" + ++time);
        System.out.println(" ...... end task-" + time);
    }
}
package com.hzf.task.task;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zf.huang on 2018.9.6
 */

@Service
public class TimerTask {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private int time = 0;

    public void task() {
        System.out.print(format.format(new Date()) + " ...... start task-" + ++time);
        System.out.println(" ...... end task-" + time);
    }
}

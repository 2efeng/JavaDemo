package com.hzf.task;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zf.huang on 2018.9.6
 */
public class TimerTask {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");

    public void task() {

        System.out.println("task start... date:" + format.format(new Date()));

    }


}

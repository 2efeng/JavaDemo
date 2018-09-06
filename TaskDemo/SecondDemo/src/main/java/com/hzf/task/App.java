package com.hzf.task;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zf.huang on 2018.9.6
 */
public class App {


    public static void main(String[] args) {

        new ClassPathXmlApplicationContext("taskContext.xml");

    }
}

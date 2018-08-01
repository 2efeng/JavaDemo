package com.hzf.mq;

import org.apache.camel.ProducerTemplate;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by zf.huang on 2018.7.17
 */
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("camel-server.xml");
        ProducerTemplate producerTemplate = (ProducerTemplate) ctx.getBean("camelTemplate");
        String mqName = "jms:queue:uk.bet.ack.queue";
//        String mqName = "jms:topic:uk.bet.ack.queue";
        producerTemplate.asyncSendBody(mqName, "some message......");
    }

    public void getMsg(String msg) {
        System.out.println(msg);
    }

}
package com.hzf.jpa;

import com.hzf.jpa.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zf.huang on 2018.8.3
 */
public class App {

    public static void main(String[] args) {


        //用绝对路径applicationContext
//        String applicationContext = System.getProperty("user.dir") +
//                File.separator + "src" +
//                File.separator + "main" +
//                File.separator + "resources" +
//                File.separator + "applicationContext.xml";
//        ApplicationContext context = new FileSystemXmlApplicationContext(applicationContext);


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        PersonService dao = (PersonService) context.getBean("personService");
        dao.findAll().forEach(it -> System.out.println(it.toString()));
    }
}

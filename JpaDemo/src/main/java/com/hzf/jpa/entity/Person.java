package com.hzf.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zf.huang on 2018.8.3
 */

@Data
@Entity
@Table(name = "tb_person")
public class Person {

    //1、AUTO      自动选择一个最适合底层数据库的主键生成策略。如MySQL会自动对应auto increment。
    //             这个是默认选项，即如果只写@GeneratedValue，等价于@GeneratedValue(strategy=GenerationType.AUTO)。
    //
    //2、IDENTITY　表自增长字段，Oracle不支持这种方式。
    //
    //3、SEQUENCE　通过序列产生主键，MySQL不支持这种方式。
    //
    //4、TABLE　   通过表产生主键，框架借由表模拟序列产生主键，使用该策略可以使应用更易于数据库移植。
    //            不同的JPA实现商生成的表名是不同的，如 OpenJPA生成openjpa_sequence_table表，Hibernate生成一个hibernate_sequences表，
    //            而TopLink则生成sequence表。这些表都具有一个序列名和对应值两个字段，如SEQ_NAME和SEQ_COUNT。
    //
    // @GeneratedValue(strategy = GenerationType.IDENTITY)//自动递增
    // @GenericGenerator(name = "system-uuid", strategy = "uuid")

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    //length默认是255
    @Column(name = "gender", length = 2)
    private String gender;

    //updatable 字段不更新
    @Column(name = "birthday", updatable = false)
    private Date birthday;

    //sql server varchar(max),@Lob转成text
    @Lob
    @Column(name = "remark", updatable = false)
    private String remark;

    //mysql
    //@Column(name = "remark" ,length = Integer.MAX_VALUE)
    //private String remark;

}

package com.hzf.jpa.dao;

import com.hzf.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by zf.huang on 2018.8.3
 */

public interface PersonDao extends PagingAndSortingRepository<Person, Integer>, JpaSpecificationExecutor<Person> {

    //手写sql 也可以使用Specification （service包下面的例子）
    @Query(value = "from Person person where person.name = ?1")
    List<Person> findByName(String name);

}
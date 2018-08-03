package com.hzf.jpa.service;

import com.hzf.jpa.dao.PersonDao;
import com.hzf.jpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by zf.huang on 2018.8.3
 */
public class PersonService {

    @Autowired
    private PersonDao dao;

    public Iterable<Person> findAll() {
        return dao.findAll();
    }

    public Person find(int id) {
        Optional<Person> person = dao.findById(id);
        return person.orElse(null);
    }

    public boolean updateUser(Person... persons) {
        for (Person person : persons) {
            dao.save(person);
        }
        return true;
    }

    public boolean deleteUserById(int... ids) {
        for (int id : ids) {
            dao.deleteById(id);
        }
        return true;
    }

    //Specification 拼接查询语句 （未写连表查询）

    public void find() {
        List<Person> personList = dao.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            predicatesList.add(criteriaBuilder.and(criteriaBuilder.equal(
                    root.get("name"), "小明")));
//            predicatesList.add(criteriaBuilder.and(criteriaBuilder.like(
//                    root.get("remark"), "%呵呵%")));
            return criteriaBuilder.and(predicatesList.toArray(new Predicate[0]));
//        });
        }, Sort.by(Sort.Direction.DESC, "gender"));
        personList.forEach(it -> System.out.println(it.toString()));
    }
    /**
     * Keyword              Sample                              JPQL snippet
     * And                  findByLastnameAndFirstname          … where x.lastname = ?1 and x.firstname = ?2
     * Or                   indByLastnameOrFirstname            … where x.lastname = ?1 or x.firstname = ?2
     * Is,Equals            indByFirstname,findByFirstnameIs,   … where x.firstname = ?1
     *                      findByFirstnameEquals
     * Between              findByStartDateBetween              … where x.startDate between ?1 and ?2
     * LessThan             findByAgeLessThan                   … where x.age < ?1
     * LessThanEqual        findByAgeLessThanEqual              … where x.age ⇐ ?1
     * GreaterThan          findByAgeGreaterThan                … where x.age > ?1
     * GreaterThanEqual     findByAgeGreaterThanEqual           … where x.age >= ?1
     * After                findByStartDateAfter                … where x.startDate > ?1
     * Before               findByStartDateBefore               … where x.startDate < ?1
     * IsNull               findByAgeIsNull                     … where x.age is null
     * IsNotNull,NotNull    findByAge(Is)NotNull                … where x.age not null
     * Like                 findByFirstnameLike                 … where x.firstname like ?1
     * NotLike              findByFirstnameNotLike              … where x.firstname not like ?1
     * StartingWith         findByFirstnameStartingWith         … where x.firstname like ?1(parameter bound with appended %)
     * EndingWith           findByFirstnameEndingWith           … where x.firstname like ?1(parameter bound with prepended %)
     * Containing           indByFirstnameContaining            … where x.firstname like ?1(parameter bound wrapped in%)
     * OrderBy              findByAgeOrderByLastnameDesc        … where x.age = ?1 order by x.lastname desc
     * Not                  findByLastnameNot                   … where x.lastname <> ?1
     * In                   findByAgeIn(Collection<Age> ages)   … where x.age in ?1
     * NotIn                findByAgeNotIn(Collection<Age> age) … where x.age not in ?1
     * True                 findByActiveTrue()                  … where x.active = true
     * False                findByActiveFalse()                 … where x.active = false
     * IgnoreCase           findByFirstnameIgnoreCase           … where UPPER(x.firstame) = UPPER(?1)
     */
}

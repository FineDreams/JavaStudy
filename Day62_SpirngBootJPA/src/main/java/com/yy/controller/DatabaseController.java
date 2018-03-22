package com.yy.controller;

import com.yy.dao.PersonRepository;
import com.yy.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DatabaseController {
    @Autowired
    PersonRepository personRepository;
    /**
     *增删改都一样
     * 保持支持批量保存
     * 删除支持id删除，批量删除，删除全部
     * @param name
     * @param address
     * @param age
     * @return
     */
    @RequestMapping("/save")
    public Person save(String name,String address,Integer age){
        Person p = personRepository.save(new Person(name, age, address));
        return p;
    }

    @RequestMapping("/query1")
    public List<Person> query1(String address){
        List<Person> people = personRepository.findByAddress(address);
        return people;
    }

    @RequestMapping("/query2")
    public Person query2(String name,String address){
        Person person = personRepository.findByNameAndAddress(name, address);
        return person;
    }

    @RequestMapping("/query3")
    public Person query3(String name,String address){
        Person p = personRepository.withNameAndAddressQuery(name,address);
        return p;
    }

    @RequestMapping("/query4")
    public Person query4(String name,String address){
        Person p = personRepository.withNameAndAddressNameQuery(name,address);
        return p;
    }

    /**
     * 排序
     * @return
     */
    @RequestMapping("/sort")
    public List<Person> sort(){
        //根据年龄排序
        List<Person> people=personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
        return people;
    }

    /**
     * 分页
     * @return
     */
    @RequestMapping("/page")
    public Page<Person> page(){
        Page<Person> personPage = personRepository.findAll(new PageRequest(1, 2));
        return personPage;

    }

}

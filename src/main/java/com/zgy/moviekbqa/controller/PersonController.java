package com.zgy.moviekbqa.controller;

import com.zgy.moviekbqa.node.Person;
import com.zgy.moviekbqa.repository.PersonRepository;
import com.zgy.moviekbqa.result.ResponseMessage;
import com.zgy.moviekbqa.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/appleyk/person")
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	/**
	 * 根据演员名查询Person实体
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/get")
	public List<Person> getPersons(@RequestParam(value = "name") String name) {
		return personRepository.findByName(name);
	}

	/**
	 * 创建一个演员节点
	 * 
	 * @param person
	 * @return
	 */
	@PostMapping("/save")
	public ResponseResult savePerson(@RequestBody Person person) {
		personRepository.save(person);
		return new ResponseResult(ResponseMessage.OK);
	}

	
}

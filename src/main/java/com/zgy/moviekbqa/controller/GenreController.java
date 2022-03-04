package com.zgy.moviekbqa.controller;

import com.zgy.moviekbqa.node.Genre;
import com.zgy.moviekbqa.repository.GenreRepository;
import com.zgy.moviekbqa.result.ResponseMessage;
import com.zgy.moviekbqa.result.ResponseResult;
import com.zgy.moviekbqa.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/zgy.moviekbqa/genre")
public class GenreController {
	
	@Autowired
	GenreRepository genreRepository;  
	

	/**
	 * 根据类型名查询Genre实体
	 * @param name
	 * @return
	 */
    @RequestMapping("/get")  
    public List<Genre> getGenres(@RequestParam(value="name") String name){             
    	return genreRepository.findByName(name); 	
    }  
      
    /**
     * 创建一个电影类型节点
     * @param genre
     * @return
     */
    @PostMapping("/save")  
    public ResponseResult saveGenre(@RequestBody Genre genre){      	
    	genreRepository.save(genre);
    	return new ResponseResult(ResponseMessage.OK);
    }  
}

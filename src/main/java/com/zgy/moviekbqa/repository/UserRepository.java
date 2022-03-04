package com.zgy.moviekbqa.repository;


import com.zgy.moviekbqa.node.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends Neo4jRepository<User, Long> {
	User findByUserName(@Param("name") String userName);
}

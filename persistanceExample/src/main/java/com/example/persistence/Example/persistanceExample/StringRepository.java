package com.example.persistence.Example.persistanceExample;

import org.springframework.data.repository.CrudRepository;

public interface StringRepository extends CrudRepository<StringEntity, String>{
    
}

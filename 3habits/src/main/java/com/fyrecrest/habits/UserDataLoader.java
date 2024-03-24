package com.fyrecrest.habits;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class UserDataLoader implements CommandLineRunner {

    public static final Logger log = LoggerFactory.getLogger(UserDataLoader.class);
    private final UserRepository repository;
    private final ObjectMapper objectMapper;

    public UserDataLoader(UserRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if(repository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/user-content.json")) {
                repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<User>>(){}));
            }
        } else {
            log.info("Not loading users from json data because the database table already contains data");
                    
        }
    }

}

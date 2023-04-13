package com.bunkmate.bunkmateweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired //lets framework know to instantiate class
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public Optional<User> singleUserByFirstName(String firstName) {
        return userRepository.findUserByFirstName(firstName);
    }

    public List<User> findUserByLastName(String lastName) {
        Query query = new Query().addCriteria(Criteria.where("lastName").is(lastName));
        return mongoTemplate.find(query, User.class);
    }

    public User createUser(User user) {
        userRepository.insert(user);

        return user;
    }

}

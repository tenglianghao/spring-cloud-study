package jack.controller;

import jack.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestMongoDbController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/save")
    public void saveToMongodb() {
        User user = new User(1, "jack", 24);
        mongoTemplate.insert(user);
    }

    @RequestMapping("/get")
    public List<User> getAll() {
        return mongoTemplate.findAll(User.class);
    }
}

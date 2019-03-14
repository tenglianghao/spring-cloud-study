package jack.controller;

import jack.dao.User;
import jack.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserCotroller {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user/getAll")
    public List<User> selectAll() {
        List<User> list = userRepository.findAll();
        System.out.println(list);
        return list;
    }

    @RequestMapping("/user/save")
    public boolean saveUser() {
        User user = new User(2, "hello worlk", 18);
        userRepository.save(user);
        return true;
    }

}

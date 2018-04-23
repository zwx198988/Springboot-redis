package com.myproject.controller;

import com.myproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author: Administrator
 * @create 2018-01-04 10:31
 */
@RestController
public class TestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("test")
    public String test() throws Exception {

        // 保存字符串
//        stringRedisTemplate.opsForValue().set("aaa", "111");
//        String string = stringRedisTemplate.opsForValue().get("aaa");
//        System.out.println(string);

        List<User> list = new ArrayList<User>();

        // 保存对象
        User user = new User("超人", 20);
        //redisTemplate.opsForValue().set(user.getUsername(), user);

        User user1 = new User("蝙蝠侠", 30);
        //redisTemplate.opsForValue().set(user1.getUsername(), user);

        User user2 = new User("蜘蛛侠", 40);
        //redisTemplate.opsForValue().set(user2.getUsername(), user);
//        User user3 = (User)redisTemplate.opsForValue().get("超人");
//        System.out.println(user1.getAge().longValue());
//        System.out.println(((User)redisTemplate.opsForValue().get("蝙蝠侠")).getAge().longValue());
//        System.out.println(((User)redisTemplate.opsForValue().get("蜘蛛侠")).getAge().longValue());


        list.add(user);
        list.add(user1);
        list.add(user2);
        redisTemplate.opsForValue().set("list001", list);

        System.out.println(((List<User>)redisTemplate.opsForValue().get("list001")).toString());

        return "Hello World";
    }
}

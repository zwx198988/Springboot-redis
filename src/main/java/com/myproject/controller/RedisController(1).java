package com.myproject.controller;

import com.myproject.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @author: Administrator
 * @create 2018-01-05 16:54
 */
@RestController
@Api(tags = "rediscontroller")
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    private RedisTemplate RedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "向redis插入数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", paramType = "query", value = "key", dataType = "string",required = true),
            @ApiImplicitParam(name = "value", paramType = "query", value = "value", dataType = "string",required = true)
    })
    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public String insertString(String key,String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return "OK";
    }
    @ApiOperation(value = "从redis查询数据")
    @ApiImplicitParam(name = "key", paramType = "query", value = "key", dataType = "string",required = true)
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String insertString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @ApiOperation(value = "从redis查询数据2")
    @ApiImplicitParam(name = "key", paramType = "query", value = "key", dataType = "string",required = true)
    @RequestMapping(value = "/get2", method = RequestMethod.GET)
    public String insertString2(String key) {
        return(redisTemplate.opsForValue().get("list001")).toString();
    }



}
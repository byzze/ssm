package org.mybatis.example.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.example.dao.UserDao;
import org.mybatis.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.Connection;

@Controller
public class TsetController {

    private static final Logger logger = LogManager.getLogger(TsetController.class.getName());

    @Autowired
    UserDao userDao;

    @Autowired
    UserDao userDao1;

    @Autowired
    DataSource dataSource;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/test")
    @ResponseBody
    public User test(){
        System.out.println("进来了");
        User user = userDao.selectUser(103);
        User user1 = userDao1.selectUser(103);
        System.out.println(user==user1);
        System.out.println(userDao);
        System.out.println(userDao1);
        logger.info(user1);
        return user1;
    }
    @RequestMapping("/test1")
    @ResponseBody
    public Connection test1() throws Exception {

        return null;
    }
}

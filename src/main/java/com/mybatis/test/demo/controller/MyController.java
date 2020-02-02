package com.mybatis.test.demo.controller;

import com.mybatis.test.demo.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈description〉
 * 〈〉
 *
 * @author zhixuan.xue
 * @create 2020/2/1 17:46
 */
@RestController
public class MyController {

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(value="/qian")
    public Long haha() {
        return bookMapper.countByExample(null);
    }
}

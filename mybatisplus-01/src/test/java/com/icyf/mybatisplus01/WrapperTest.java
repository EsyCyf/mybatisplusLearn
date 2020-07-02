package com.icyf.mybatisplus01;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.icyf.mybatisplus01.mapper.UserMapper;
import com.icyf.mybatisplus01.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @Author: ESy
 * @Date: 2020/6/29 15:03
 */
@SpringBootTest
public class WrapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    void test1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age",12);
        userMapper.selectList(wrapper).forEach(System.out::print);
        //Execute SQL：SELECT id,name,age,email,version,deleted,create_time,update_time FROM user WHERE deleted=0 AND (name IS NOT NULL AND email IS NOT NULL AND age >= 12)
    }

    @Test
    void test2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","2222");
        userMapper.selectOne(wrapper);
    }

    //区间
    @Test
    void test3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,22);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    //模糊查询
    @Test
    void test4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("name","a")
                .likeRight("name","J");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::print);
        //Execute SQL：SELECT id,name,age,email,version,deleted,create_time,update_time FROM user WHERE deleted=0 AND (name NOT LIKE '%a%' AND name LIKE 'J%')
    }



}

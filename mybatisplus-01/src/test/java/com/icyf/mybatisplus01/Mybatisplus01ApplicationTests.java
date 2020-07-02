package com.icyf.mybatisplus01;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.icyf.mybatisplus01.mapper.UserMapper;
import com.icyf.mybatisplus01.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class Mybatisplus01ApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("hehe");
        user.setAge(13);
        user.setEmail("212414@eer.com");
        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1277223225623252994L);
        user.setName("hahahahahaahhah");
        user.setAge(99);

        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    //测试乐观锁单线程 成功
    @Test
    public void testOptimisticLockerInterceptor(){
        User user = userMapper.selectById(1277223225623252994L);

        user.setName("cccc");
        user.setEmail("55555@qq.com");

        userMapper.updateById(user);
    }

    //测试乐观锁多线程 失败
    @Test
    public void testOptimisticLockerInterceptor2(){
        //线程1
        User user = userMapper.selectById(1277223225623252994L);
        user.setName("1111111");
        user.setEmail("1111111@qq.com");


        //模拟另外一个线程执行了插队操作
        User user2 = userMapper.selectById(1277223225623252994L);
        user2.setName("2222");
        user2.setEmail("2222@qq.com");
        userMapper.updateById(user2);

        userMapper.updateById(user);
    }

    //测试批量查询
    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::print);

    }

    //按条件查询 map
    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","hehe");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::print);
    }

    //测试分页查询
    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::print);

    }

    //测试删除
    @Test
    public void testDelete(){
        userMapper.deleteById(1277223225623253006L);
    }


    @Test
    public void test(){
        System.out.println(LocalDateTime.now());
    }

}

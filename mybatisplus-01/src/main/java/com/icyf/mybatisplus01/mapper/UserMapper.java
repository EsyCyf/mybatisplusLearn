package com.icyf.mybatisplus01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.icyf.mybatisplus01.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: ESy
 * @Date: 2020/6/28 20:13
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    //所有的CRUD操作已经编写完成
}

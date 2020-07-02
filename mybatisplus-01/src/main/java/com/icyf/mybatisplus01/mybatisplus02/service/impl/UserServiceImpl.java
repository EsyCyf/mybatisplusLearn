package com.icyf.mybatisplus01.mybatisplus02.service.impl;

import com.icyf.mybatisplus01.mybatisplus02.entity.User;
import com.icyf.mybatisplus01.mybatisplus02.mapper.UserMapper;
import com.icyf.mybatisplus01.mybatisplus02.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ESy
 * @since 2020-06-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

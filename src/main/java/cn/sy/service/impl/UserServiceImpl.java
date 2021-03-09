package cn.sy.service.impl;

import cn.sy.entity.User;
import cn.sy.mapper.UserMapper;
import cn.sy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

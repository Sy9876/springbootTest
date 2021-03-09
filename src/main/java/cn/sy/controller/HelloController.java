package cn.sy.controller;

import cn.sy.entity.User;
import cn.sy.mapper.UserMapper;
import cn.sy.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.sy.dto.HelloBean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@Slf4j
public class HelloController {

	@Autowired
	UserMapper userMapper;

	@Autowired
	UserService userService;

	/*
	 * request:
	 *     curl -i "http://localhost:8083/hello?name=sy"
	 * response:
	 *     hello sy
	 */
    @RequestMapping("/hello")
    public String hello(String name) {
    	System.out.println("HelloController hello. name=" + name);

//		List<User> userList = userMapper.selectList(null);
//		String s = userList.stream()
//				.map(x -> x.toString())
//				.collect(Collectors.joining("\n"));
//		log.info("userList: " + s);
		Page<User> page = new Page<>();
		page.setCurrent(1);
		page.setSize(10);

		IPage<User> res = userMapper.selectPage(page, null);
		log.info("res: " + res);
		String s = res.getRecords().stream()
				.map(x -> x.toString())
				.collect(Collectors.joining("\n"));
		log.info("userList: " + s);

    	return "hello " + name;
    }

	@RequestMapping("/save")
	public String save(String name) {
		System.out.println("HelloController save. name=" + name);
		User user = new User();
		user.setName(name);
		user.setPassword(UUID.randomUUID().toString());
		user.setStatus("0");
		userMapper.insert(user);

		return "hello " + name;
	}

	@RequestMapping("/batchSave")
	public String batchSave(String name, int count) {
		System.out.println("HelloController batchSave. name=" + name);
		List<User> userList = new ArrayList<>();
		for(int i=0;i<count;i++) {
			User user = new User();
			user.setName(name + "_" + i);
			user.setPassword(UUID.randomUUID().toString());
			user.setStatus("0");
			userList.add(user);
		}

		userService.saveBatch(userList);

		return "hello " + name;
	}

	@RequestMapping("/findByName")
	public String findByName(String name, int count) {
		System.out.println("HelloController findByName. name=" + name);
		List<User> userList = userMapper.findByName(name);
		String s = userList.stream()
				.map(x -> x.toString())
				.collect(Collectors.joining("\n"));
		log.info("userList: " + s);

		return "hello " + name;
	}

	/*
	 * request:
	 *     curl -i "http://localhost:8083/helloBean"
	 * response:
	 *     {"code":"1","message":"name can not be null","name":null}
	 *     
	 * request:
	 *     curl -i "http://localhost:8083/helloBean?name=sy"
	 * response:
	 *     {"code":"0","message":null,"name":"sy"}
	 */
    @ResponseBody
    @RequestMapping("/helloBean")
    public HelloBean helloBean(String name) {
    	HelloBean helloBean = new HelloBean();
    	System.out.println("HelloController helloBean. name=" + name);
    	if(name==null) {
    		helloBean.setCode("1");
    		helloBean.setMessage("name can not be null");
    		helloBean.setName(null);
    	}
    	else {
    		helloBean.setCode("0");
    		helloBean.setMessage(null);
    		helloBean.setName(name);
    	}
    	return helloBean;
    }

}

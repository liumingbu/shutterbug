package cn.photo.shutterbug.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import cn.photo.shutterbug.annotation.LoginPowerAnnotation;
import cn.photo.shutterbug.domain.User;
import cn.photo.shutterbug.service.UserService;
import cn.photo.shutterbug.utils.JSONUtil;
import cn.photo.shutterbug.utils.MD5Util;
import cn.photo.shutterbug.utils.UserContext;

/**
 *  用户相关操作控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	
	@Value("${web.appFilePath}")
	private String appFilePath;
	
	/**
	 * 新用户注册接口
	 * @param u
	 * @return
	 */
	@RequestMapping(value="register")
	@ResponseBody
	public JSONObject register(User u){
		JSONObject ret = JSONUtil.create();
		try {
			service.insertUser(u);
			ret.put("msg", "创建成功");
		} catch (Exception e) {
			ret.put("op", "fail");
			ret.put("msg", e.getMessage());
		}
		return ret;
	}
	
	/**
	 * 用户登录入口
	 * @param u
	 * @return
	 */
	@RequestMapping(value="login")
	@ResponseBody
	public JSONObject login(User u){
		JSONObject ret = JSONUtil.create();
		try {
			User user = service.login(u.getUsername(),MD5Util.getMD5(u.getPassword()));
			ret.put("user", user);
			UserContext.setUser(user);
		} catch (Exception e) {
			ret.put("op", "fail");
			ret.put("msg", e.getMessage());
		}
		return ret;
	}
	
	/**
	 * 用户信息编辑--头像的上传更新
	 * @param file
	 * @return
	 */
	@RequestMapping(value="uploadHeadImg", method = RequestMethod.POST)
	@ResponseBody
	@LoginPowerAnnotation
	public JSONObject uploadHeadImg(MultipartFile file){
		JSONObject ret = JSONUtil.create();
		String path = service.uploadHeadImg(file);
		ret.put("filePath", path);
	    return ret;
	}
	
	@RequestMapping(value="test", method = RequestMethod.POST)
	@ResponseBody
	@LoginPowerAnnotation
	public JSONObject test(HttpServletRequest req){
		//System.out.println(UserContext.getUser());
		return null;
	}
}

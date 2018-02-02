package cn.photo.shutterbug.service;

import org.springframework.web.multipart.MultipartFile;

import cn.photo.shutterbug.domain.User;

public interface UserService {
	
	/**
	 * 用户注册
	 * @param user
	 */
	void insertUser(User user);
	
	/**
	 * 用户登录
	 * @param u
	 * @return
	 */
	User login(String username,String password);
	
	/**
	 * 用户头像更新接口
	 * @param file
	 * @return 上传后图片的位置
	 */
	String uploadHeadImg(MultipartFile file);
}

package cn.photo.shutterbug.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.photo.shutterbug.domain.User;
import cn.photo.shutterbug.mapper.UserMapper;
import cn.photo.shutterbug.service.UserService;
import cn.photo.shutterbug.utils.FileUtils;
import cn.photo.shutterbug.utils.MD5Util;
import cn.photo.shutterbug.utils.UUIDUtil;
import cn.photo.shutterbug.utils.UserContext;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	

	
	@Override
	public void insertUser(User user) {
		User oldUser = mapper.getUserByUsername(user.getUsername());
		if(oldUser != null){
			throw new RuntimeException("用户名已存在,请重新输入");
		}
		User u = new User();
		u.setName(user.getName());
		u.setPassword(MD5Util.getMD5(user.getPassword()));
		u.setStatus(User.USER_STATUS_NORMAL);
		u.setUsername(user.getUsername());
		mapper.insert(u);
	}
	
	
	@Override
	public User login(String username,String password) {
		User user = mapper.getUserByUsername(username);
		if(user != null){
			if(user.getPassword().equals(password)){
				user.setPassword(null);
				return user;
			}
			throw new RuntimeException("密码输入错误,请重新输入");
		}
		throw new RuntimeException("当前用户不存在");
	}


	
	@Override
	public String uploadHeadImg(MultipartFile file) {
		if(file == null){
			throw new RuntimeException("请选择上传图片");
		}
		String contentType = file.getContentType();
	    if(!contentType.startsWith("image")){
	    	throw new RuntimeException("请上传图片格式文件");
	    }
	    //获取原文件名,根据原文件名后缀生成UUID的文件名
	    String fileName = file.getOriginalFilename();
	    String newFileName = UUIDUtil.getFileName(fileName);
	    User u = UserContext.getUser();
	    try {
	    	//头像存储路径  应用的文件存储路径 filePath + 用户的id + 文件名（文件名前面加上 head 用于标记用户头像）
	    	String imgPath = FileUtils.uploadFile(file.getBytes(),u.getId()+"/headImg/",newFileName);
	    	//删除原头像
	    	FileUtils.deleteFile(u.getHeadImg());
	    	u.setHeadImg(imgPath);
	    	//更新用户信息
	    	mapper.updateBase(u);
			return imgPath;
		} catch (IOException e) {
			throw new RuntimeException("上传图片处理失败");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("图片上传失败");
		}
	}

}

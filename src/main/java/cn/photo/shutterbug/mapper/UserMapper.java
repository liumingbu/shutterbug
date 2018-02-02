package cn.photo.shutterbug.mapper;

import cn.photo.shutterbug.domain.User;


public interface UserMapper {
	
    
    
    /**
     * 创建一个用户
     * @param user
     */
	void insert(User user);
	
	/**
	 * 更新用户的基本信息,不包含password
	 * @param user
	 */
	void updateBase(User user);
	
	
	/**
	 * 通过用户名查找user对象
	 * @param loginId
	 * @return
	 */
	User getUserByUsername(String username);
	
	
}

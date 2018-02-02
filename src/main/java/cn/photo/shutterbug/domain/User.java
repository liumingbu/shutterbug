package cn.photo.shutterbug.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class User {
	
	public static final int USER_STATUS_NORMAL = 1;
	
	private Integer id;
	private String username;  	//用户名
	private String password; 	//用户密码  md5加密
	private String name;	 	//昵称
	private int status;			//用户状态  1 正常
	private String headImg;		//头像
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", status="
				+ status + ", headImg=" + headImg + "]";
	}
	
}

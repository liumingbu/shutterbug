package cn.photo.shutterbug.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.photo.shutterbug.domain.User;

/**
 * 应用中  用户对象的操作  存储与获取
 * @author Administrator
 *
 */
public class UserContext {
	/**
	 * 在session存储用户的 属性名
	 */
	private static final String USER_SESSION_ATT = "USER_SESSION";
	
	public final static ThreadLocal<HttpServletRequest> THREADLOCAL_REQ = new ThreadLocal<>();
	
	/**
	 * 获取请求中的session
	 * @return
	 */
	private static HttpSession getSession(){
		return THREADLOCAL_REQ.get().getSession();
	}
	
	/**
	 * 获取登录用户
	 * @return
	 */
	public static User getUser(){
		return (User)getSession().getAttribute(USER_SESSION_ATT);
	}
	
	/**
	 * 将登录用户存到session中
	 * @param u
	 */
	public static void setUser(User u){
		getSession().setAttribute(USER_SESSION_ATT, u);
	}
}

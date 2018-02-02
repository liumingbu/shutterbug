package cn.photo.shutterbug.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.photo.shutterbug.utils.UserContext;

public class HttpRequestInterceptor extends HandlerInterceptorAdapter{

	
	/**
	 * 进入congtroller前拦截, 将请求对象存到 threadLocal中
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse response, Object handler)
			throws Exception {
		UserContext.THREADLOCAL_REQ.set(req);
		return true;
	}
}

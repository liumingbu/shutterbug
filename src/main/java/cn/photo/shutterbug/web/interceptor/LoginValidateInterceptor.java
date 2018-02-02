package cn.photo.shutterbug.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;

import cn.photo.shutterbug.annotation.LoginPowerAnnotation;
import cn.photo.shutterbug.domain.User;
import cn.photo.shutterbug.utils.UserContext;

/**
 *  登录确认 拦截器
 * @author Administrator
 *
 */
public class LoginValidateInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * 用户是否登录   true 已登录  false 未登录
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod method = (HandlerMethod)handler;
		LoginPowerAnnotation annotation = method.getMethodAnnotation(LoginPowerAnnotation.class);
		if(annotation != null && annotation.value()){
			User user = UserContext.getUser();
			if(user == null){
				response.setContentType("text/json;charset=UTF-8");
				JSONObject jo = new JSONObject();
				jo.put("msg", "请求拒绝,未登录或登录已过期");
				jo.put("op", "fail");
				response.getWriter().println(jo);
				return false;
			}
		}
		return true;
	}
}

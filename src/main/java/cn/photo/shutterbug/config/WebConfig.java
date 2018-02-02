package cn.photo.shutterbug.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.photo.shutterbug.web.interceptor.HttpRequestInterceptor;
import cn.photo.shutterbug.web.interceptor.LoginValidateInterceptor;

/**
 * 注册拦截器
 * @author Administrator
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HttpRequestInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(new LoginValidateInterceptor()).addPathPatterns("/**");
	}
}

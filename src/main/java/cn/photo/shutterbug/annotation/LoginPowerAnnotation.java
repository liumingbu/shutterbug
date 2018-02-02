package cn.photo.shutterbug.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要用户登录才能访问
 * @author XGD
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoginPowerAnnotation {
	
	/**
	 * 是否需要执行登录校验
	 * @return
	 */
	boolean value() default true;
}

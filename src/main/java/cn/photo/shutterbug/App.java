package cn.photo.shutterbug;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Hello world!
 *
 */

@Configuration	//定义为一个配置文件
@EnableAutoConfiguration	//将所有符合自动配置条件的bean定义加载到IoC容器
//组件扫描:controller,service,repository 
@ComponentScan
//扫描这个包下的所有mapper对象
@MapperScan(basePackages="cn.photo.shutterbug.mapper")	
public class App extends WebMvcConfigurerAdapter {
	
    public static void main( String[] args ) {
    	 SpringApplication.run(App.class, args);
    	 System.out.println("启动成功");
    }
}

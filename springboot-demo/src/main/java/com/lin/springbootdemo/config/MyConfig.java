package com.lin.springbootdemo.config;

import com.lin.springbootdemo.util.ResponseBo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyConfig extends WebMvcConfigurerAdapter{
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//       // super.addInterceptors(registry);
//        registry.addInterceptor(new MyIntercepter()).addPathPatterns("/**").excludePathPatterns("/login","/user/login","/");
//    }
//
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
//        前面是请求地址，后面是template里面的页面
        registry.addViewController("/login.html").setViewName("login");
//        registry.addViewController("/").setViewName("index");
        //registry.addViewController("/main").setViewName("main");
//        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/order-list.html").setViewName("order-list");
        registry.addViewController("/order-list1.html").setViewName("order-list1");
        registry.addViewController("/member-del.html").setViewName("member-del");
        registry.addViewController("/welcome.html").setViewName("welcome");
        registry.addViewController("/welcome1.html").setViewName("welcome1");
        registry.addViewController("/city.html").setViewName("city");
        registry.addViewController("/member-list.html").setViewName("member-list");
        registry.addViewController("/member-list1.html").setViewName("member-list1");
        registry.addViewController("/member-edit.html").setViewName("member-edit");
        registry.addViewController("/member-password.html").setViewName("member-password");
        registry.addViewController("/cate.html").setViewName("cate");
        registry.addViewController("/echarts1.html").setViewName("echarts1");
        registry.addViewController("/admin-add.html").setViewName("admin-add");
        registry.addViewController("/admin-cate.html").setViewName("admin-cate");
        registry.addViewController("/admin-list.html").setViewName("admin-list");
        registry.addViewController("/admin-role.html").setViewName("admin-role");
        registry.addViewController("/admin-rule.html").setViewName("admin-rule");
        registry.addViewController("/log.html").setViewName("log");
        registry.addViewController("/demo.html").setViewName("demo");
        registry.addViewController("/unicode.html").setViewName("unicode");
        registry.addViewController("/echarts1.html").setViewName("echarts1");
        registry.addViewController("/order-add.html").setViewName("order-add");
        registry.addViewController("/good-add.html").setViewName("good-add");
        registry.addViewController("/myshopcart.html").setViewName("myshopcart");
        registry.addViewController("/userlogin.html").setViewName("userlogin");
        registry.addViewController("/countpay.html").setViewName("countpay");
        registry.addViewController("/userlogin.html").setViewName("userlogin");
        registry.addViewController("/shopIndex.html").setViewName("shopIndex");
        registry.addViewController("/details.html").setViewName("details");
        registry.addViewController("/goodList.html").setViewName("font/goodList");
        registry.addViewController("/test1.html").setViewName("test1");
    }
    @Bean
    public ResponseBo getResponseBo(){
        return new ResponseBo();
    }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //将所有/static/** 访问都映射到classpath:/static/ 目录下
//
////addResourceLocations的每一个值必须以'/'结尾,否则虽然映射了,但是依然无法访问该目录下的的文件(支持: classpath:/xxx/xx/, file:/xxx/xx/, http://xxx/xx/)
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }
}

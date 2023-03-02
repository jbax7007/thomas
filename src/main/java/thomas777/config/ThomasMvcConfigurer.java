package thomas777.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ThomasMvcConfigurer implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("index");

        registry.addViewController("/content.html").setViewName("content");
        registry.addViewController("/content").setViewName("content");

        registry.addViewController("/books.html").setViewName("books");
        registry.addViewController("/books").setViewName("books");

        registry.addViewController("/about.html").setViewName("about");
        registry.addViewController("/about").setViewName("about");

        registry.addViewController("/contact.html").setViewName("contact");
        registry.addViewController("/contact").setViewName("contact");

        registry.addViewController("/error.html").setViewName("error");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/error.html").setViewName("error");
        registry.addViewController("/404").setViewName("error");

        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/admin.html").setViewName("admin");
        registry.addViewController("/admin").setViewName("admin");

        registry.addViewController("/newvideo.html").setViewName("newvideo");
        registry.addViewController("/newvideo").setViewName("newvideo");
    }

}

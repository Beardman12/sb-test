import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrosConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String [] allowOrgins=new String[]{"http://localhost:8081"};
        registry.addMapping("/")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedOrigins(allowOrgins);

    }
}

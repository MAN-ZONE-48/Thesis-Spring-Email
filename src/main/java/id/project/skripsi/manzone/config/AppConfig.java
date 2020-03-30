package id.project.skripsi.manzone.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EntityScan("com.java.common.lib")
@ComponentScan("com.java.common.lib")
@EnableSwagger2
public class AppConfig {
}

package id.project.skripsi.manzone.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages = "id.project.skripsi.manzone")
@EnableSwagger2
public class AppConfig {
}

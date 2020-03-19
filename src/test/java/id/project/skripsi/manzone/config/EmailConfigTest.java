package id.project.skripsi.manzone.config;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test")
@Configuration
@Component
public class EmailConfigTest {

    @Value("${spring.mail.host}")
    private String host;

    @Value("#{T(java.lang.Integer).parseInt('${spring.mail.port}')}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Bean
    @Primary
    public EmailConfig emailConfig(){
        return Mockito.mock(EmailConfig.class);
    }

}

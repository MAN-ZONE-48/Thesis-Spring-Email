package id.project.skripsi.manzone.service;

import id.project.skripsi.manzone.config.EmailConfigTest;
import id.project.skripsi.manzone.service.impl.EmailServiceImpl;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {
        EmailConfigTest.class
})
public class EmailServiceImplTest {

    @InjectMocks
    EmailServiceImpl emailService;

    @MockBean
    JavaMailSenderImpl mailSender;

    @Autowired
    EmailConfigTest emailConfigTest;

    @Rule
    public SmtpServerRule smtpServerRule = new SmtpServerRule(2525);


    @Test
    @Ignore
    public void testSendingOneEmail(){

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(emailConfigTest.getHost());
        javaMailSender.setUsername(emailConfigTest.getUsername());
        javaMailSender.setPassword(emailConfigTest.getPassword());

        //create email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("test@gmail.com");
        mailMessage.setTo("test123@gmail.com");
        mailMessage.setSubject("Verify Your Account Now!");
        mailMessage.setText("Your verification code is 1111" + "\n" + "If this verification code doesn't work, please contact our admin at admin@gmail.com");

        emailService.getEmail();
        MimeMessage[] receivedMessage = smtpServerRule.getMessages();
        assertEquals(1,receivedMessage.length);
    }



}

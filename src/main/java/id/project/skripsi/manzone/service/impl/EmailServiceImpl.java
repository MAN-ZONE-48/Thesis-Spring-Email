package id.project.skripsi.manzone.service.impl;

import id.project.skripsi.manzone.config.EmailConfig;
import id.project.skripsi.manzone.service.EmailService;
import id.project.skripsi.manzone.service.OtpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {


    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class.getName());

    final EmailConfig emailConfig;
    final OtpService otpService;

    @Autowired
    public EmailServiceImpl(EmailConfig emailConfig, OtpService otpService) {
        this.emailConfig = emailConfig;
        this.otpService = otpService;
    }

    @Override
    public String getEmail() {

        //create mail sender
        try {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setPort(this.emailConfig.getPort());
            mailSender.setHost(this.emailConfig.getHost());
            mailSender.setUsername(this.emailConfig.getUsername());
            mailSender.setPassword(this.emailConfig.getPassword());

            //create email instance
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("admin@gmail.com");
            mailMessage.setTo("maderajaadi@gmail.com");
            mailMessage.setSubject("Verify Your Account Now!");
            mailMessage.setText("Your verification code is " + otpService.createOtpCode() + " \n" + "If this verification code doesn't work, please contact our admin at admin@gmail.com");

            //send email with mail sender
            mailSender.send(mailMessage);
            return "Your Email has Been Sent. Please Check Your Mailbox To Complete Your Registration Process!";
        }catch(Exception e){
            LOGGER.info("there is an error while sending an email: {}", e.getMessage());
            return null;
        }
    }
}

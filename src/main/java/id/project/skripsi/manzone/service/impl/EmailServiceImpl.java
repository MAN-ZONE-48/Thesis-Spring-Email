package id.project.skripsi.manzone.service.impl;

import id.project.skripsi.manzone.config.EmailConfig;
import id.project.skripsi.manzone.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailServiceImpl implements EmailService {

    final EmailConfig emailConfig;

    @Autowired
    public EmailServiceImpl(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    @Override
    public String getEmail() {

        //create mail sender
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
        mailMessage.setText("Your verification code is "+ createOtpCode() + " \n" + "If this verification code doesn't work, please contact our admin at admin@gmail.com");


        //send email with mail sender
        mailSender.send(mailMessage);
        return "Your Email has Been Sent. Please Check Your Mailbox To Complete Your Registration Process!";
    }

    private String createOtpCode(){
        String number = "0123456789";
        Random random = new Random();

        char[] otpCode = new char[4];

        for(int i=0; i<otpCode.length; i++){
            otpCode[i] = number.charAt(random.nextInt(number.length()));
        }
        String otpCodeString = String.valueOf(otpCode);
        return otpCodeString;
    }

}

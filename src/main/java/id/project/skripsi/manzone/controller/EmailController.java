package id.project.skripsi.manzone.controller;

import id.project.skripsi.manzone.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/test")
public class EmailController {

    final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/getEmail")
    public ResponseEntity sendFeedBack(){
        String success = emailService.getEmail();
        return new ResponseEntity(success ,HttpStatus.OK);

    }

}

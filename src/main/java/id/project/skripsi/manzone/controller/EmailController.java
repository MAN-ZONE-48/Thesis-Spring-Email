package id.project.skripsi.manzone.controller;

import id.project.skripsi.manzone.dto.response.Response;
import id.project.skripsi.manzone.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import static id.project.skripsi.manzone.constant.AppConstant.*;

@RestController
@RequestMapping("/test")
public class EmailController {

    final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/getEmail")
    public ResponseEntity sendFeedBack(HttpServletResponse response){
        try {
            String success = emailService.getEmail();
            return new ResponseEntity(new Response(false,response.getStatus(),STATUS_200.getMessage(),"The Email Has Been Sent. Please Check Your Email for Verification Code!"), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(new Response(true,response.getStatus(),"There is an error in our server: {}" + e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

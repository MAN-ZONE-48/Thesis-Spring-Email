package id.project.skripsi.manzone.controller;

import com.java.auth.dto.Response;
import id.project.skripsi.manzone.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static com.java.auth.constant.ResponseConstant.OK;


@RestController
@RequestMapping("/v1")
public class EmailController {

    final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/getEmail")
    public ResponseEntity sendFeedBack(HttpServletResponse response){
            String success = emailService.getEmail();
            return new ResponseEntity(new Response(false,response.getStatus(),OK.getMessage(),success), HttpStatus.OK);
    }
}

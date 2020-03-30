package id.project.skripsi.manzone.controller;

import com.java.common.lib.constant.StatusConstant;
import com.java.common.lib.dto.Response;
import id.project.skripsi.manzone.dto.EmailDTO;
import id.project.skripsi.manzone.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1")
public class EmailController {

    final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/getVerificationCode")
    public ResponseEntity sendFeedBack(HttpServletResponse response){
            String success = emailService.getEmail();
            return new ResponseEntity(new Response(false,response.getStatus(), StatusConstant.OK.getMessage(),success), HttpStatus.OK);
    }

    @PostMapping("/forgotPassword")
    public ResponseEntity getPasswordByEmail(@RequestBody EmailDTO emailDTO, HttpServletResponse response){

        String successResponse = emailService.getRandomPassword(emailDTO.getUserEmail());
        return new ResponseEntity(new Response(false,response.getStatus(),StatusConstant.OK.getMessage(),successResponse), HttpStatus.OK);
    }

}

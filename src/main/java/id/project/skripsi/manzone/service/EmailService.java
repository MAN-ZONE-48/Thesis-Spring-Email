package id.project.skripsi.manzone.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    String getEmail();
    String getRandomPassword(String userEmail);

}

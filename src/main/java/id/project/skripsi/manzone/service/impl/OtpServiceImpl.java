package id.project.skripsi.manzone.service.impl;

import id.project.skripsi.manzone.service.OtpService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpServiceImpl implements OtpService {

    @Override
    @Cacheable(cacheNames = "otp")
    public String createOtpCode(){
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

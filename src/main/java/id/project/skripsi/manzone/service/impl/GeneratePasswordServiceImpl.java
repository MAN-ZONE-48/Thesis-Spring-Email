package id.project.skripsi.manzone.service.impl;

import id.project.skripsi.manzone.service.GeneratePasswordService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeneratePasswordServiceImpl implements GeneratePasswordService {

    @Override
    public String generatePassword() {
        int minLimit = 65;
        int maxLimit = 122;
        int length = 10;

        Random random = new Random();
        String generatedString = random.ints(minLimit,maxLimit + 1)
                .limit(length + 1)
                .filter(i -> (i <= 90 || i >= 97))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}

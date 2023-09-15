package ks.msx.InternetBanking.utility;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSender {
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendEmail(String toEmail, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(toEmail);
        message.setSubject("Confirm Email");
        message.setText(body);

        javaMailSender.send(message);
        System.out.println("Message send");
    }
}

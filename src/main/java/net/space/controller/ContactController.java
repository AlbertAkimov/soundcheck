package net.space.controller;

import net.space.model.Contact;
import net.space.utilities.EmailAddress;
import net.space.validators.json.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

/**
 * @Author A.Albert
 * @Data 8/31/17
 * @Time 1:31 PM
 * @Version 1.0
 * @Info empty
 */

@RestController
public class ContactController {

    private JavaMailSender mailSender;

    private SimpleMailMessage templateMessage;

    @Autowired
    @Qualifier("mailSender")
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Autowired
    @Qualifier("templateMessage")
    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    @PostMapping(value = "/contact", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<?> sendMessage(@RequestBody Contact contact) {

        SimpleMailMessage mailMessage = new SimpleMailMessage(templateMessage);

        mailMessage.setTo(EmailAddress.TO_EMAIL_SOUNDCHECK);
        mailMessage.setText(EmailAddress.buildMessage(contact.getMessage(), contact.getNameAuthor(), contact.getEmail()));

        JsonResponse jr = new JsonResponse();

        try {
            mailSender.send(mailMessage);
            jr.setStatus("SUCCESS");
            jr.setResult(contact);
            System.out.println("Mail sended");
        } catch (MailException mailException) {
            System.out.println("Mail send failed.");
            mailException.printStackTrace();
        }


        return ResponseEntity.ok(jr);
    }
}

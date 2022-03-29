package org.common.email.controller;

import org.common.email.dto.Mail;
import org.common.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;



@RestController
public class SendEmailController {

    @Autowired
    private EmailService emailService;

    @CrossOrigin(origins = "http://localhost:8080/")
    @RequestMapping(value = "/SendEmail" , method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody Mail mail){


        boolean result=false;
        try {
            emailService.sendMail(mail.getTo(), mail.getSubject(), mail.getMessage());
            result=true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        if(result){
            return ResponseEntity.ok("Email Sent Successfully....");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not Sent ......");
        }
    }

}



//final product...

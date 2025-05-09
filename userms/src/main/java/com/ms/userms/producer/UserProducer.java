package com.ms.userms.producer;


import com.ms.userms.model.User;
import com.ms.userms.producer.dto.EmailDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User user){
        var emailDTO = new EmailDTO();

        emailDTO.setUserID(user.getUserID());
        emailDTO.setEmailTo(user.getMail());
        emailDTO.setSubject("Registration completed successfully!");
        emailDTO.setText(user.getName() + ", Welcome! Thank you and enjoy your benefits!");

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }

}

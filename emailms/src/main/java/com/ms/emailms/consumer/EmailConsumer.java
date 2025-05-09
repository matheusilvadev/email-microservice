package com.ms.emailms.consumer;


import com.ms.emailms.dtos.PayloadDTO;
import com.ms.emailms.model.Email;
import com.ms.emailms.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService service;

    //Queue listener
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload PayloadDTO dto){
        var email = new Email();
        BeanUtils.copyProperties(dto, email);

        service.sendEmail(email);
    }

}

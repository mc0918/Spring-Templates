package com.example.eurekafeignqueuetemplate;

import com.example.eurekafeignqueuetemplate.util.messages.ModelEntry;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @RabbitListener(queues = EurekaFeignQueueTemplateApplication.QUEUE_NAME)
    public void receiveMessage(ModelEntry msg) {
        System.out.println(msg.toString());
    }
}

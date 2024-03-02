package com.bfz.usermanagementapi.user.infraestructure.adapter.out.notification.email.aws;

import com.bfz.usermanagementapi.user.core.application.port.out.IUserEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

/**
 * @author bruferper
 */

@Service
@RequiredArgsConstructor
public class AwsSesEmailService implements IUserEmailService {

    private final SesClient sesClient;

    @Value("${aws.ses.from}")
    private String emailFrom;

    @Override
    public void sendBasicEmail(String recipient, String subject, String text) {
        Destination destination = Destination.builder().toAddresses(recipient).build();

        Message message = Message.builder()
                .subject(Content.builder().data(subject).build())
                .body(Body.builder().text(Content.builder().data(text).build()).build())
                .build();

        SendEmailRequest sendEmailRequest = SendEmailRequest.builder()
                .source(emailFrom)
                .destination(destination)
                .message(message)
                .build();

        sesClient.sendEmail(sendEmailRequest);
    }

}

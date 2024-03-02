package com.bfz.usermanagementapi.user.core.application.port.out;

/**
 * @author bruferper
 */

public interface IUserEmailService {

    void sendBasicEmail(String recipient, String subject, String message);

}

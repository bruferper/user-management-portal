package com.bfz.usermanagementapi.user.core.application.port.out;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author bruferper
 */

public interface IUserStorage {

    String uploadPhoto(String fileName, MultipartFile file);

}

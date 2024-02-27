package com.bfz.usermanagementapi.user.infraestructure.adapter.out.storage.aws;

import com.bfz.usermanagementapi.user.core.application.port.out.IUserStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author bruferper
 */

@Service
@RequiredArgsConstructor
public class AwsS3Service implements IUserStorage {

    @Value("${aws.s3.user.profile.bucket}")
    private String userProfileBucket;

    private final AwsS3CustomClient s3CustomClient;

    @Override
    public String uploadPhoto(String fileName, MultipartFile file) {
        return s3CustomClient.uploadObject(userProfileBucket, fileName, file);
    }

}

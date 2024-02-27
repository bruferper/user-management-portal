package com.bfz.usermanagementapi.user.infraestructure.adapter.out.storage.aws;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.IOException;

/**
 * @author bruferper
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class AwsS3CustomClient {

    private final S3Client s3Client;

    public String uploadObject(String bucketName, String objectKey, MultipartFile file) {
        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .acl(ObjectCannedACL.PUBLIC_READ)
                    .build();
            s3Client.putObject(putObjectRequest, RequestBody.fromBytes(file.getBytes()));
            return getObjectUrl(bucketName, objectKey);
        } catch (SdkException ex) {
            log.error(ex.getMessage());
            String errorMessage = String.format("Error creating object on bucket: %s with object key: %s", bucketName, objectKey);
            throw new RuntimeException(errorMessage);
        } catch (IOException ex) {
            log.error(ex.getMessage());
            String errorMessage = String.format("IO error creating the object URL from bucket: %s and object key: %s", bucketName, objectKey);
            throw new RuntimeException(errorMessage);
        }
    }

    private String getObjectUrl(String bucketName, String objectKey) {
        try {
            GetUrlRequest getUrlRequest = GetUrlRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();
            return s3Client.utilities().getUrl(getUrlRequest).toString();
        } catch (SdkException ex) {
            log.error(ex.getMessage());
            String errorMessage = String.format("Error getting the object URL from bucket: %s and object key: %s", bucketName, objectKey);
            throw new RuntimeException(errorMessage);
        }
    }

}

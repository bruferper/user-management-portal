package com.bfz.usermanagementapi.user.infraestructure.adapter.out.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

/**
 * @author bruferper
 */

@Configuration
public class AwsS3Config {

    @Value("${aws.s3.access.key}")
    private String accessKey;

    @Value("${aws.s3.access.secret}")
    private String secret;

    @Bean
    public S3Client getS3Client() {
        Region region = Region.SA_EAST_1;
        AwsCredentials credentials = AwsBasicCredentials.create(accessKey, secret);
        S3Client s3Client = S3Client.builder()
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
        return s3Client;
    }

}

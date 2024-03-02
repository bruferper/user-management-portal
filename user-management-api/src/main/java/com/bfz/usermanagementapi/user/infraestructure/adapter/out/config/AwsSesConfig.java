package com.bfz.usermanagementapi.user.infraestructure.adapter.out.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;

/**
 * @author bruferper
 */

@Configuration
public class AwsSesConfig {

    @Value("${aws.access.key}")
    private String accessKey;

    @Value("${aws.access.secret}")
    private String secret;

    @Bean
    public SesClient getSesClient() {
        Region region = Region.SA_EAST_1;
        AwsCredentials credentials = AwsBasicCredentials.create(accessKey, secret);
        return SesClient.builder()
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }

}

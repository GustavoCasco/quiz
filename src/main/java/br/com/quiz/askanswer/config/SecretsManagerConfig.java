package br.com.quiz.askanswer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class SecretsManagerConfig {
    @Bean
    public SecretsManagerClient configurationAwsConfig() throws URISyntaxException {
        Region region = Region.SA_EAST_1;
        return SecretsManagerClient.builder()
                .region(region)
                .endpointOverride(new URI("http://localhost:4566"))
                .build();
    }
}

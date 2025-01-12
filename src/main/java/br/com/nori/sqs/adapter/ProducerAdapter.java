package br.com.nori.sqs.adapter;

import br.com.nori.core.port.ProducerPort;
import jakarta.enterprise.context.ApplicationScoped;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

import java.math.BigDecimal;
import java.net.URI;

@ApplicationScoped
public class ProducerAdapter implements ProducerPort {

    private final SqsClient sqsClient;
    private final String queueUrl = "https://localhost.localstack.cloud:4566/000000000000/quarkus-queue";

    public ProducerAdapter() {
        this.sqsClient = SqsClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("accessKey", "secretKey")))
                .endpointOverride(URI.create("https://localhost.localstack.cloud:4566"))
                .build();
    }

    public void sendMessage(String codigoBarra, BigDecimal valorPago, String email) {
        String messageBody = String.format("CodigoBarra: %s, ValorPago: %.2f, Email: %s", codigoBarra, valorPago, email);
        SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(messageBody)
                .build();

        SendMessageResponse sendMsgResponse = sqsClient.sendMessage(sendMsgRequest);
        System.out.println("Identificador da mensagem: " + sendMsgResponse.messageId());
    }
}
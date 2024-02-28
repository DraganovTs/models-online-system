package com.models.online.system.download.service.messaging.publisher.kafka;

import com.models.online.system.kafka.download.avro.model.PaymentRequestAvroModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
@Component
public class DownloadKafkaMessageHelper {

    public<T> CompletableFuture<SendResult<String, T>>
    getKafkaCallback(String responseTopicName, T requestAvroModel , String downloadId,String requestAvroModelName ) {
        return new CompletableFuture<SendResult<String, T>>() {

            @Override
            public CompletableFuture<Void> thenAccept(Consumer<? super SendResult<String, T>> action) {
                return super.thenAccept(result -> {

                    RecordMetadata metadata = result.getRecordMetadata();
                    log.info("Received successful response from Kafka for download whit id: {}" +
                                    " Topic: {} Partition: {} Offset: {} Timestamp: {}",
                            downloadId,
                            metadata.topic(),
                            metadata.partition(),
                            metadata.offset(),
                            metadata.timestamp());
                    action.accept(result);
                });
            }

            @Override
            public CompletableFuture<SendResult<String, T>> exceptionally(Function<Throwable,
                    ? extends SendResult<String, T>> fn) {
                log.error("Error while sending "+ requestAvroModelName +
                        " message {} to topic {}", requestAvroModel.toString(), responseTopicName);
                return super.exceptionally(fn);
            }
        };
    }
}

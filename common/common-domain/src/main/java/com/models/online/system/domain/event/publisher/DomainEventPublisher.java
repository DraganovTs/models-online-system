package com.models.online.system.domain.event.publisher;

import com.models.online.system.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}

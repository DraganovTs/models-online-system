package com.models.online.system.download.service.domain.ports.output.repository;

import com.models.online.system.download.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Optional<Customer> findCustomer (UUID customerId);
}

package com.models.online.system.download.system.dataaccess.customer.adapter;

import com.models.online.system.download.service.domain.entity.Customer;
import com.models.online.system.download.service.domain.ports.output.repository.CustomerRepository;
import com.models.online.system.download.system.dataaccess.customer.mapper.CustomerDataAccessMapper;
import com.models.online.system.download.system.dataaccess.customer.repository.CustomerJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerDataAccessMapper customerDataAccessMapper;

    public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository, CustomerDataAccessMapper customerDataAccessMapper) {
        this.customerJpaRepository = customerJpaRepository;
        this.customerDataAccessMapper = customerDataAccessMapper;
    }

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository.findById(customerId).map(customerDataAccessMapper::customerEntityToCustomer);
    }
}

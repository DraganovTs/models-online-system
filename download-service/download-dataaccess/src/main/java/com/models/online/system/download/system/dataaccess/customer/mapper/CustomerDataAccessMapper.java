package com.models.online.system.download.system.dataaccess.customer.mapper;

import com.models.online.system.domain.valueobject.CustomerId;
import com.models.online.system.download.service.domain.entity.Customer;
import com.models.online.system.download.system.dataaccess.customer.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity){
        return new Customer(new CustomerId(customerEntity.getId()));
    }
}

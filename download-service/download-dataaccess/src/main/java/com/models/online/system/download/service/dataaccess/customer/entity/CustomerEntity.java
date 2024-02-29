package com.models.online.system.download.service.dataaccess.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "download_customer_m_view", schema = "customer")
@Entity
public class CustomerEntity {

    @Id
    private UUID id;
}

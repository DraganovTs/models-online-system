package com.models.online.system.download.system.dataaccess.download.entity;

import com.models.online.system.domain.valueobject.DownloadStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "downloads")
@Entity
public class DownloadEntity {

    @Id
    private UUID id;
    private UUID customerId;
    private UUID categoryId;
    private UUID trackingId;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private DownloadStatus downloadStatus;
    private String failureMessages;

    @OneToOne(mappedBy = "download", cascade = CascadeType.ALL)
    private UserInformationEntity userInfo;
    @OneToMany(mappedBy = "download", cascade = CascadeType.ALL)
    private List<DownloadModelEntity> models;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DownloadEntity that = (DownloadEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package com.models.online.system.download.service.dataaccess.download.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(DownloadModelEntityId.class)
@Table(name = "download_models")
@Entity
public class DownloadModelEntity {
    @Id
    private Long id;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DOWNLOAD_ID")
    private DownloadEntity download;

    private UUID modelId;
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DownloadModelEntity that = (DownloadModelEntity) o;
        return id.equals(that.id) && download.equals(that.download);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, download);
    }
}

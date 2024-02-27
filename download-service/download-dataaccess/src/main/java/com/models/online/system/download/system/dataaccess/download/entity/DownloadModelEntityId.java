package com.models.online.system.download.system.dataaccess.download.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DownloadModelEntityId implements Serializable {
    private Long id;
    private DownloadEntity download;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DownloadModelEntityId that = (DownloadModelEntityId) o;
        return id.equals(that.id) && download.equals(that.download);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, download);
    }
}

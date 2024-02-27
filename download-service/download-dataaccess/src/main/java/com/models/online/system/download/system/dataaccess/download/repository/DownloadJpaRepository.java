package com.models.online.system.download.system.dataaccess.download.repository;

import com.models.online.system.download.system.dataaccess.download.entity.DownloadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DownloadJpaRepository extends JpaRepository<DownloadEntity, UUID> {
        Optional<DownloadEntity> findByTrackingId(UUID trackingId);

}

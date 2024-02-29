package com.models.online.system.download.service.dataaccess.download.adapter;

import com.models.online.system.download.service.dataaccess.download.mapper.DownloadDataAccessMapper;
import com.models.online.system.download.service.dataaccess.download.repository.DownloadJpaRepository;
import com.models.online.system.download.service.domain.entity.Download;
import com.models.online.system.download.service.domain.ports.output.repository.DownloadRepository;
import com.models.online.system.download.service.domain.valueobject.TrackingId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DownloadRepositoryImpl implements DownloadRepository {

    private final DownloadJpaRepository downloadJpaRepository;
    private final DownloadDataAccessMapper downloadDataAccessMapper;

    public DownloadRepositoryImpl(DownloadJpaRepository downloadJpaRepository, DownloadDataAccessMapper downloadDataAccessMapper) {
        this.downloadJpaRepository = downloadJpaRepository;
        this.downloadDataAccessMapper = downloadDataAccessMapper;
    }

    @Override
    public Download save(Download download) {
        return downloadDataAccessMapper.downloadEntityToDownload(downloadJpaRepository
                .save(downloadDataAccessMapper.downloadToDownloadEntity(download)));
    }

    @Override
    public Optional<Download> findByTrackingId(TrackingId trackingId) {
        return downloadJpaRepository.findByTrackingId(trackingId.getValue())
                .map(downloadDataAccessMapper::downloadEntityToDownload);
    }
}

package com.models.online.system.download.service.domain;

import com.models.online.system.download.service.domain.dto.track.TrackDownloadQuery;
import com.models.online.system.download.service.domain.dto.track.TrackDownloadResponse;
import com.models.online.system.download.service.domain.entity.Download;
import com.models.online.system.download.service.domain.exception.DownloadDomainException;
import com.models.online.system.download.service.domain.exception.DownloadNotFoundException;
import com.models.online.system.download.service.domain.mapper.DownloadDataMapper;
import com.models.online.system.download.service.domain.ports.output.repository.DownloadRepository;
import com.models.online.system.download.service.domain.valueobject.TrackingId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class DownloadTrackCommandHandler {

    private final DownloadDataMapper downloadDataMapper;
    private final DownloadRepository downloadRepository;

    public DownloadTrackCommandHandler(DownloadDataMapper downloadDataMapper,
                                       DownloadRepository downloadRepository) {
        this.downloadDataMapper = downloadDataMapper;
        this.downloadRepository = downloadRepository;
    }

    @Transactional(readOnly = true)
    TrackDownloadResponse trackDownload(TrackDownloadQuery trackDownloadQuery) {
        Optional<Download> downloadResult = downloadRepository.findByTrackingId(new TrackingId(
                trackDownloadQuery.getDownloadTrackingId()));
        if (downloadResult.isEmpty()) {
            log.warn("Could not find order whit tracking id: {}", trackDownloadQuery.getDownloadTrackingId());
            throw new DownloadNotFoundException("Could not find order whit tracking id: "
                    + trackDownloadQuery.getDownloadTrackingId());
        }
        return downloadDataMapper.downloadToTrackDownloadResponse(downloadResult.get());
    }
}

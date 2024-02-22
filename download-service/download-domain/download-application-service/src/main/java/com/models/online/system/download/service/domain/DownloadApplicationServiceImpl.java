package com.models.online.system.download.service.domain;

import com.models.online.system.download.service.domain.dto.create.CreateDownloadCommand;
import com.models.online.system.download.service.domain.dto.create.CreateDownloadResponse;
import com.models.online.system.download.service.domain.dto.track.TrackDownloadQuery;
import com.models.online.system.download.service.domain.dto.track.TrackDownloadResponse;
import com.models.online.system.download.service.domain.ports.input.service.DownloadApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class DownloadApplicationServiceImpl implements DownloadApplicationService {

    private final DownloadCreateCommandHandler downloadCreateCommandHandler;
    private final DownloadTrackCommandHandler downloadTrackCommandHandler;

    DownloadApplicationServiceImpl(DownloadCreateCommandHandler downloadCreateCommandHandler,
                                   DownloadTrackCommandHandler downloadTrackCommandHandler) {
        this.downloadCreateCommandHandler = downloadCreateCommandHandler;
        this.downloadTrackCommandHandler = downloadTrackCommandHandler;
    }


    @Override
    public CreateDownloadResponse createDownload(CreateDownloadCommand createDownloadCommand) {
        return downloadCreateCommandHandler.createDownload(createDownloadCommand);
    }

    @Override
    public TrackDownloadResponse trackDownload(TrackDownloadQuery trackDownloadQuery) {
        return downloadTrackCommandHandler.trackDownload(trackDownloadQuery);
    }
}

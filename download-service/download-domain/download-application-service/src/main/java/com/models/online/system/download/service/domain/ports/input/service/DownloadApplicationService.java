package com.models.online.system.download.service.domain.ports.input.service;

import com.models.online.system.download.service.domain.dto.create.CreateDownloadCommand;
import com.models.online.system.download.service.domain.dto.create.CreateDownloadResponse;
import com.models.online.system.download.service.domain.dto.track.TrackDownloadQuery;
import com.models.online.system.download.service.domain.dto.track.TrackDownloadResponse;
import jakarta.validation.Valid;

public interface DownloadApplicationService {

    CreateDownloadResponse createDownload(@Valid CreateDownloadCommand createDownloadCommand);

    TrackDownloadResponse trackDownload(@Valid TrackDownloadQuery trackDownloadQuery);
}

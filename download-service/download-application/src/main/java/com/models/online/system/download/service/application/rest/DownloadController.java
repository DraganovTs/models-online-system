package com.models.online.system.download.service.application.rest;

import com.models.online.system.download.service.domain.dto.create.CreateDownloadCommand;
import com.models.online.system.download.service.domain.dto.create.CreateDownloadResponse;
import com.models.online.system.download.service.domain.dto.track.TrackDownloadQuery;
import com.models.online.system.download.service.domain.dto.track.TrackDownloadResponse;
import com.models.online.system.download.service.domain.ports.input.service.DownloadApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/downloads", produces = "application/vnd.api.v1+json")
public class DownloadController {

    private final DownloadApplicationService downloadApplicationService;

    public DownloadController(DownloadApplicationService downloadApplicationService) {
        this.downloadApplicationService = downloadApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateDownloadResponse> createDownload(@RequestBody CreateDownloadCommand createDownloadCommand) {
        log.info("Creating download for customer: {}", createDownloadCommand.getCustomerId());
        CreateDownloadResponse createDownloadResponse = downloadApplicationService.createDownload(createDownloadCommand);
        log.info("Download created whit tracking id: {}", createDownloadResponse.getDownloadTrackingId());
        return ResponseEntity.ok(createDownloadResponse);
    }

    @GetMapping("/{trackingId}")
    public ResponseEntity<TrackDownloadResponse> getDownloadByTrackingId(@PathVariable UUID trackingId){
        TrackDownloadResponse trackDownloadResponse =
                downloadApplicationService.trackDownload(TrackDownloadQuery.builder().downloadTrackingId(trackingId).build());
        log.info("Returning download status whit tracking id: {}",trackDownloadResponse.getDownloadTrackingId());
        return ResponseEntity.ok(trackDownloadResponse);
    }
}

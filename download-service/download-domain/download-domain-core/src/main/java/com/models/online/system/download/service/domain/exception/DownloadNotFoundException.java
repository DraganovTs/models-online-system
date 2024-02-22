package com.models.online.system.download.service.domain.exception;

import com.models.online.system.domain.exception.DomainException;

public class DownloadNotFoundException extends DomainException {
    public DownloadNotFoundException(String message) {
        super(message);
    }

    public DownloadNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.models.online.system.download.service.domain.exception;

import com.models.online.system.domain.exception.DomainException;

public class DownloadDomainException extends DomainException {
    public DownloadDomainException(String message) {
        super(message);
    }

    public DownloadDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}

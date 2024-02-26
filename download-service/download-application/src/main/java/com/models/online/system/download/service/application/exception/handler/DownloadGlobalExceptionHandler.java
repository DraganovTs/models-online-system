package com.models.online.system.download.service.application.exception.handler;

import com.models.online.system.application.handler.ErrorDTO;
import com.models.online.system.application.handler.GlobalExceptionHandler;
import com.models.online.system.download.service.domain.exception.DownloadDomainException;
import com.models.online.system.download.service.domain.exception.DownloadNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class DownloadGlobalExceptionHandler extends GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {DownloadDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(DownloadDomainException downloadDomainException) {
        log.error(downloadDomainException.getMessage(), downloadDomainException);
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(downloadDomainException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {DownloadNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(DownloadNotFoundException downloadNotFoundException) {
        log.error(downloadNotFoundException.getMessage(), downloadNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(downloadNotFoundException.getMessage())
                .build();
    }
}

package com.models.online.system.download.service.domain;

import com.models.online.system.download.service.domain.dto.message.CategoryApproveResponse;
import com.models.online.system.download.service.domain.ports.input.message.listener.categoryapproval.CategoryResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class CategoryResponseMessageListenerImpl implements CategoryResponseMessageListener {
    @Override
    public void downloadApproved(CategoryApproveResponse categoryApproveResponse) {

    }

    @Override
    public void downloadRejected(CategoryApproveResponse categoryApproveResponse) {

    }
}

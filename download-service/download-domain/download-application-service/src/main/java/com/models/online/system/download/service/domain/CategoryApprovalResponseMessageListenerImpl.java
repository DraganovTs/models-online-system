package com.models.online.system.download.service.domain;

import com.models.online.system.download.service.domain.dto.message.CategoryApprovalResponse;
import com.models.online.system.download.service.domain.ports.input.message.listener.categoryapproval.CategoryApprovalResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class CategoryApprovalResponseMessageListenerImpl implements CategoryApprovalResponseMessageListener {
    @Override
    public void downloadApproved(CategoryApprovalResponse categoryApprovalResponse) {

    }

    @Override
    public void downloadRejected(CategoryApprovalResponse categoryApprovalResponse) {

    }
}

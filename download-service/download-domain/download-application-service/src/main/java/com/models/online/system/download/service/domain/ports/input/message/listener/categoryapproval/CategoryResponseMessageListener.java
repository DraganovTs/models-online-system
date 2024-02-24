package com.models.online.system.download.service.domain.ports.input.message.listener.categoryapproval;

import com.models.online.system.download.service.domain.dto.message.CategoryApprovalResponse;

public interface CategoryResponseMessageListener {
    void downloadApproved(CategoryApprovalResponse categoryApprovalResponse);

    void downloadRejected(CategoryApprovalResponse categoryApprovalResponse);
}

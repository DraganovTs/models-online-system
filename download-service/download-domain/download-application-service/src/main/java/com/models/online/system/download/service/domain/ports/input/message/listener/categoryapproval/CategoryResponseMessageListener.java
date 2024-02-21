package com.models.online.system.download.service.domain.ports.input.message.listener.categoryapproval;

import com.models.online.system.download.service.domain.dto.message.CategoryApproveResponse;

public interface CategoryResponseMessageListener {
    void downloadApproved(CategoryApproveResponse categoryApproveResponse);

    void downloadRejected(CategoryApproveResponse categoryApproveResponse);
}

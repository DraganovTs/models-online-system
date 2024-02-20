package com.models.online.system.domain.valueobject;

import java.util.UUID;

public class CategoryId extends BaseId<UUID> {
    protected CategoryId(UUID value) {
        super(value);
    }
}

package com.models.online.system.domain.valueobject;

import java.util.UUID;

public class ModelId extends BaseId<UUID>{
    public ModelId(UUID value) {
        super(value);
    }
}

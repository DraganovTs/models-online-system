package com.models.online.system.download.service.dataaccess.download.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_information")
@Entity
public class UserInformationEntity {
    @Id
    private UUID id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DOWNLOAD_ID")
    private DownloadEntity download;

    private  String email;
    private  String country;
    private  String city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInformationEntity that = (UserInformationEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

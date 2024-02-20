package com.models.online.system.download.service.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

public class UserInformation {
    private final UUID id;
    private final String email;
    private final String country;
    private final String city;

    public UserInformation(UUID id, String email, String country, String city) {
        this.id = id;
        this.email = email;
        this.country = country;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInformation that = (UserInformation) o;
        return email.equals(that.email) && country.equals(that.country) && city.equals(that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, country, city);
    }
}

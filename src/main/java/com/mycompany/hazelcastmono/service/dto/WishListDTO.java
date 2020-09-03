package com.mycompany.hazelcastmono.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mycompany.hazelcastmono.domain.WishList} entity.
 */
public class WishListDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String title;

    private Boolean restricted;


    private Long customerId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean isRestricted() {
        return restricted;
    }

    public void setRestricted(Boolean restricted) {
        this.restricted = restricted;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WishListDTO)) {
            return false;
        }

        return id != null && id.equals(((WishListDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WishListDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", restricted='" + isRestricted() + "'" +
            ", customerId=" + getCustomerId() +
            "}";
    }
}

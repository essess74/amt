package com.amt.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by MedMalek on 06/11/2015.
 */
@Entity
@Table(name = "category")
public class CategoryEntity implements Serializable {


    @Id
    @Column(name = "category")
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof CategoryEntity)) return false;

        CategoryEntity that = (CategoryEntity) o;

        return new EqualsBuilder()
                .append(category, that.category)
                .isEquals();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(category)
                .toHashCode();
    }
}

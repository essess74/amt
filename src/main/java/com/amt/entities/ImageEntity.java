package com.amt.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MedMalek on 01/11/2015.
 */
@Entity
@Table(name = "image")
public class ImageEntity
        implements Serializable {

    @Id
    @GeneratedValue(generator = "image_seq")
    @SequenceGenerator(name = "image_seq",
                       sequenceName = "image_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "image")
    private byte image[];

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ImageEntity)) return false;

        ImageEntity that = (ImageEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(image, that.image)
                .isEquals();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(image)
                .toHashCode();
    }
}

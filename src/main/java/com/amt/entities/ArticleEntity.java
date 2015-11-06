package com.amt.entities;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by MedMalek on 18/10/2015.
 */
@Entity
@Table(name = "ARTICLE")
public class ArticleEntity implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "article_no_seq",
                       allocationSize = 1,
                       sequenceName = "article_no_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "article_no_seq")
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "submission_date")
    private Date submissionDate;
    @Column(name = "url")
    private String url;
    @Column(name = "type")
    private String type;
    @Column(name = "image_id")
    private Long imageId;
    @Column(name = "category")
    private String category;

    private transient byte[] image;

    private transient List<KeyWordEntity> keyWords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<KeyWordEntity> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<KeyWordEntity> keyWords) {
        this.keyWords = keyWords;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @PrePersist
    public void prePersist() {
        submissionDate = submissionDate == null ? new Date() : submissionDate;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ArticleEntity)) return false;

        ArticleEntity that = (ArticleEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(content, that.content)
                .append(title, that.title)
                .append(author, that.author)
                .append(submissionDate, that.submissionDate)
                .append(url, that.url)
                .append(type, that.type)
                .append(imageId, that.imageId)
                .append(category, that.category)
                .append(image, that.image)
                .append(keyWords, that.keyWords)
                .isEquals();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(content)
                .append(title)
                .append(author)
                .append(submissionDate)
                .append(url)
                .append(type)
                .append(imageId)
                .append(category)
                .append(image)
                .append(keyWords)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("content", content)
                .append("title", title)
                .append("author", author)
                .append("submissionDate", submissionDate)
                .append("url", url)
                .append("type", type)
                .toString();
    }
}

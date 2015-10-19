package com.amt.entities;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by MedMalek on 18/10/2015.
 */
@Entity
@Table(name = "ARTICLE")
public class ArticleEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Override
    public boolean equals(Object o) {
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
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(content)
                .append(title)
                .append(author)
                .append(submissionDate)
                .append(url)
                .append(type)
                .toHashCode();
    }
}

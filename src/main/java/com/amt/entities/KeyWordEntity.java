package com.amt.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "key_word")
public class KeyWordEntity {

    @Id
    @SequenceGenerator(name = "key_word_seq",
                       initialValue = 1,
                       sequenceName = "key_word_seq",
                       allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "key_word_seq")
    @Column(name = "ID")
    private Long id;
    @Column(name = "KEY_WORD")
    private String keyWord;

    @ManyToOne
    @JoinColumn(name = "article_id")
    @JsonBackReference
    private ArticleEntity article;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public ArticleEntity getArticle() {
        return article;
    }

    public void setArticle(ArticleEntity article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof KeyWordEntity)) return false;

        KeyWordEntity that = (KeyWordEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(keyWord, that.keyWord)
                .append(article, that.article)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(keyWord)
                .append(article)
                .toHashCode();
    }
}

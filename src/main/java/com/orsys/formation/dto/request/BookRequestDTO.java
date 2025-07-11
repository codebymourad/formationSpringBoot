package com.orsys.formation.dto.request;

import com.orsys.formation.models.Category;
import jakarta.persistence.Column;

public class BookRequestDTO {

    private String title;

    private String description;

    private Boolean publish;

    private Category category;

    private Long authorId;

    public BookRequestDTO() {}

    public BookRequestDTO(String title, String description, Boolean publish) {
        this.title = title;
        this.description = description;
        this.publish = publish;
    }

    public BookRequestDTO(String title, String description, Boolean publish, Category category) {
        this.title = title;
        this.description = description;
        this.publish = publish;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getAuthorId() { return authorId; }

    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    @Override
    public String toString() {
        return "BookRequestDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publish=" + publish +
                ", category=" + category +
                ", authorId=" + authorId +
                '}';
    }
}

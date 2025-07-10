package com.orsys.formation.dto.response;

import com.orsys.formation.models.Category;

public class BookResponseDTO {

    private Long id;

    private String title;

    private String description;

    private Boolean publish;

    private Category category;

    public BookResponseDTO() {}

    public BookResponseDTO(Long id, String title, String description, Boolean publish) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publish = publish;
    }

    public BookResponseDTO(Long id, String title, String description, Boolean publish, Category category) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

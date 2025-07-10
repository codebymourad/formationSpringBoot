package com.orsys.formation.dto.request;

public class CategoryRequestDTO {

    private String title;

    public CategoryRequestDTO() { }

    public CategoryRequestDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

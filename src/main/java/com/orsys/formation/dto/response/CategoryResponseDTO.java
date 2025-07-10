package com.orsys.formation.dto.response;

public class CategoryResponseDTO {
    private Long id;

    private String title;

    public CategoryResponseDTO() { }

    public CategoryResponseDTO(String title) {
        this.title = title;
    }

    public CategoryResponseDTO(String title, Long id) {
        this.title = title;
        this.id = id;
    }

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
}

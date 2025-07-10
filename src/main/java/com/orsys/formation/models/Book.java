package com.orsys.formation.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="publish")
    private Boolean publish;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private Category category;

    public Book() {}

    public Book(String title, String description, Boolean publish) {
        this.title = title;
        this.description = description;
        this.publish = publish;
    }

    public Book(Long id, String title, String description, Boolean publish) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publish = publish;
    }

    public Book(Long id, String title, String description, Boolean publish, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publish = publish;
        this.category = category;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publish=" + publish +
                ", category=" + category +
                '}';
    }
}

package br.com.estudo.vidolocadora.api.entities;

import br.com.estudo.vidolocadora.api.enums.Category;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 5699950690377279726L;

    private Long id;
    private String title;
    private String director;
    private Date createdDate;
    private Date updatedDate;
    private Category category;
    private Shelf shelf;

    public Movie(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="director", nullable = false)
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Column(name="created_date", nullable = false)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name="updated_date", nullable = false)
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="category", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    @PreUpdate
    public void preUpdate(){
        updatedDate = new Date();
    }

    @PrePersist
    public void prePersist(){
        Date today = new Date();
        createdDate = today;
        updatedDate = today;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", category=" + category +
                '}';
    }
}

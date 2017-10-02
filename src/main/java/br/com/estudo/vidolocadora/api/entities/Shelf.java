package br.com.estudo.vidolocadora.api.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Shelf")
public class Shelf implements Serializable{

    private static final long serialVersionUID = -8634360647648607227L;

    private Long id;
    private String location;
    private List<Movie> movies;
    private Date createdDate;
    private Date updatedDate;

    public Shelf(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "location", nullable = false)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @OneToMany(mappedBy = "shelf", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    @Column(name = "created_date", nullable = false)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "updatedDate", nullable = false)
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
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
        return "Shelf{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", movies=" + movies +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}

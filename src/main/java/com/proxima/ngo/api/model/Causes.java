package com.proxima.ngo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proxima.ngo.api.model.audit.DateAudit;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
public class Causes extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cover;
    private String title;
    private String email;
    @Column(length=500)
    private String description;
    private String location;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Photos> photos;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Posts> posts;

    @OneToMany(mappedBy = "causes",cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CauseType> types;


    @ManyToOne()
    @JoinColumn
    private User user;

    public Causes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photos> photos) {
        this.photos = photos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    public List<CauseType> getTypes() {
        return types;
    }

    public void setTypes(List<CauseType> types) {
        this.types = types;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

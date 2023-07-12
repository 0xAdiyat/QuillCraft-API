package com.anon007.quillcraftapi.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(name = "post_title", length = 100, nullable = false)
    private String title;

    @Column(name = "post_content", length = 10000)
    private String content;
    private String imageName;
    private Date addedDate;
    @ManyToOne
    private UserEntity user;
    @ManyToOne
    private CategoryEntity category;


}

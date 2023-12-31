package com.anon007.quillcraftapi.entities;

import jakarta.persistence.*;

import java.util.Date;


/*
*
* Explanations:
* Consider a real-life scenario of a blogging platform where users can create posts and categorize them into different categories. Here's how the `ManyToOne` and `OneToMany` relationships between the `UserEntity`, `CategoryEntity`, and `PostEntity` can be explained:
*
1. `ManyToOne` Relationship (User to Posts):
In this scenario, each post is created by a single user, and a user can have multiple posts. This relationship is represented by the `ManyToOne` annotation in the `PostEntity` class, referencing the `UserEntity` class. Here's how it works:
- One user can have multiple posts, but each post is associated with only one user.
- The `UserEntity` class has a collection of posts represented by the `List<PostEntity> posts` field, annotated with `OneToMany` and specifying the mapping using `mappedBy = "user"`. This means that the relationship is owned by the `PostEntity` class.
- The `cascade = CascadeType.ALL` option ensures that any changes made to the user (e.g., deletion) will cascade to the associated posts.
- The `fetch = FetchType.LAZY` option specifies that the collection of posts should be loaded lazily, which means that the posts will be fetched from the database only when accessed.
*
2. `ManyToOne` Relationship (Category to Posts):
In this scenario, each post belongs to a specific category, and a category can have multiple posts. This relationship is represented by the `ManyToOne` annotation in the `PostEntity` class, referencing the `CategoryEntity` class. Here's how it works:
- One category can have multiple posts, but each post is associated with only one category.
- The `CategoryEntity` class has a collection of posts represented by the `List<PostEntity> posts` field, annotated with `OneToMany` and specifying the mapping using `mappedBy = "category"`. This means that the relationship is owned by the `PostEntity` class.
- The `cascade = CascadeType.ALL` option ensures that any changes made to the category (e.g., deletion) will cascade to the associated posts.
- The `fetch = FetchType.LAZY` option specifies that the collection of posts should be loaded lazily, which means that the posts will be fetched from the database only when accessed.
*
In summary, these relationships allow for the following relationships in the blogging platform:
- Each post belongs to a single user (ManyToOne: User to Posts).
- Each post belongs to a single category (ManyToOne: Category to Posts).
- Each category can have multiple posts (OneToMany: Category to Posts).
*
This setup enables the platform to organize posts into different categories and attribute each post to the user who created it.
*
*
* */

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
    @JoinColumn(name = "categoryId", nullable = false)
    private CategoryEntity category;

    public PostEntity(Integer postId, String title, String content, String imageName, Date addedDate, UserEntity user, CategoryEntity category) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.imageName = imageName;
        this.addedDate = addedDate;
        this.user = user;
        this.category = category;
    }

    public PostEntity() {

    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}

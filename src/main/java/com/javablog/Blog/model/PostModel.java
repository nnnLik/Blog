package com.javablog.Blog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "posts")
public class PostModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private String id;
	private String title;
	private String description;
	private String content;
	private String author; // FIXME: foreign key

//	private int viewCount;

	public PostModel() {
	}

	public PostModel(String title, String description, String content, String author) {
		this.title = title;
		this.description = description;
		this.content = content;
		this.author = author;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

//	public int getViewCount() {
//		return viewCount;
//	}
//
//	public void setViewCount(int viewCount) {
//		this.viewCount = viewCount;
//	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}

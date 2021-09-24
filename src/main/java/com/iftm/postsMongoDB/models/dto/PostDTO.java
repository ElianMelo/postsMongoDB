package com.iftm.postsMongoDB.models.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.iftm.postsMongoDB.models.embedded.Author;
import com.iftm.postsMongoDB.models.embedded.Comment;
import com.iftm.postsMongoDB.models.entities.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
	private String id;
	private Instant moment;
	private String title;
	private String body;
	
	private Author author;
	private List<Comment> comments = new ArrayList<>();
	
	public PostDTO(String id, Instant moment, String title, String body, Author author) {
		super();
		this.id = id;
		this.moment = moment;
		this.title = title;
		this.body = body;
		this.author = author;
	}
	
	public PostDTO(Post entity) {
		super();
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.title = entity.getTitle();
		this.body = entity.getBody();
		this.author = entity.getAuthor();
		this.comments.addAll(entity.getComments());
	}
	
}

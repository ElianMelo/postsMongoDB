package com.iftm.postsMongoDB.models.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
	private String id;
	private String name;
	private String email;
}

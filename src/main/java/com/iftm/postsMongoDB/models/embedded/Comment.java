package com.iftm.postsMongoDB.models.embedded;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	private String text;
	private Instant moment;
	private Author author;
}

package com.cse456.lab5.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "story")
public class Story {
	
	@Id
	private int story_id;
	@Column(length = 1000)
	private String story_title;
	private String story_content;
	private String email_id;
	private int story_words;
	private String date_of_submission;

	public int getStory_id() {
		return story_id;
	}

	public void setStory_id(int id) {
		this.story_id = id;
	}

	public String getStory_title() {
		return story_title;
	}

	public void setStory_title(String story_tilte) {
		this.story_title = story_tilte;
	}

	public String getStory_content() {
		return story_content;
	}

	public void setStory_content(String story_content) {
		this.story_content = story_content;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public int getStory_words() {
		return story_words;
	}

	public void setStory_words(int story_words) {
		this.story_words = story_words;
	}

	public String getDate_of_submission() {
		return date_of_submission;
	}

	public void setDate_of_submission(String date_of_submission) {
		this.date_of_submission = date_of_submission;
	}

	public Story() {
		super();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		this.date_of_submission = String.valueOf(format.format(new Date()));
	}
	
	

}

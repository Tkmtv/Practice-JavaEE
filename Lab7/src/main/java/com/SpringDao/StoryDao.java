package com.SpringDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.annotations.NamedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.SpringModel.Story;

@Repository
public class StoryDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	//Save or Insert or Create story
	@Transactional
	public int insert(Story story) {
		Integer i = (Integer) this.hibernateTemplate.save(story);
		return i;
	}

	//Get or Fetch or Read a story
	public Story getStory(int id) {
		Story story = this.hibernateTemplate.get(Story.class, id);
		return story;
	}
	//Get or Fetch or Read all student data or object
	public List<Story> getAllStory() {
		List<Story> stories = this.hibernateTemplate.loadAll(Story.class);
		return stories;
	}

	// Deleting the story
	@Transactional
	public void deleteStory(int id) {
		Story story = this.hibernateTemplate.get(Story.class, id);
		this.hibernateTemplate.delete(story);
	}

	//Updating the story
	@Transactional
	public void updateStory(String newTitle, String newContent, int id) {
		Story story = getStory(id);
		story.setContent(newContent);
		story.setTitle(newTitle);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		story.setDate(format.format(new Date()));
		this.hibernateTemplate.update(story);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
package com.SpringService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringDao.StoryDao;
import com.SpringModel.Story;

@Service
public class StoryService {
	@Autowired
	private StoryDao storyDao;

	public int createStory(Story story) {
		return this.storyDao.insert(story);
	}

	public void deleteStory(int id) {
		this.storyDao.deleteStory(id);
	}

	public void updateStory(String newTitle, String newContent, int id) {
		this.storyDao.updateStory(newTitle, newContent, id);
	}

	public List<Story> showAllStory() {
		List<Story> stories = this.storyDao.getAllStory();
		return stories;
	}

	public Story showStory(int id) {
		Story story = this.storyDao.getStory(id);
		return story;
	}
}

package com.SpringController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringModel.Story;
import com.SpringService.StoryService;

@Controller
public class SaveStoryController {
	@Autowired
	private StoryService storyService;

	@RequestMapping("/home")
	public String showHome() {
		return "home";
	}

	@RequestMapping("/add_story")
	public String addStory() {
		return "add_story";
	}

	@RequestMapping(path = "/saveForm", method = RequestMethod.POST)
	public String haldelForm(@ModelAttribute Story story, Model model) {
		model.addAttribute("story", story);
		this.storyService.createStory(story);
		return "success";
	}

	@RequestMapping("/show_stories")
	public String showAllStories(Model model) {
		List<Story> stories = this.storyService.showAllStory();
		model.addAttribute("stories", stories);
		return "show_stories";
	}

	@RequestMapping("/delete_story")
	public String deleteStories(@RequestParam int id, Model model) {
		this.storyService.deleteStory(id);
		return "redirect:/show_stories";
	}

	@RequestMapping("/update")
	public String updateStory(@RequestParam int id, Model model) {
		Story story = this.storyService.showStory(id);
		model.addAttribute("editStory", story);
		return "/update";
	}

	@RequestMapping(path = "/updateForm", method = RequestMethod.POST)
	public String updateForm(@RequestParam String title, String content, int id) {
		this.storyService.updateStory(title, content, id);
		return "redirect:/show_stories";
	}
}

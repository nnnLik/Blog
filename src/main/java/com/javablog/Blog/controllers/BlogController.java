package com.javablog.Blog.controllers;

import com.javablog.Blog.model.PostModel;
import com.javablog.Blog.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Controller()
public class BlogController {

	@Autowired
	private PostRepo postRepo;

	@GetMapping("/blog")
	public String GetBlogMain(Model model) {
		Iterable<PostModel> posts = postRepo.findAll();
		model.addAttribute("posts", posts);
		return "blog-main";
	}

	@GetMapping("/blog/add")
	public String getBlogAddMain(Model model) {
		return "blog-add";
	}

	@PostMapping("/blog/add")
	public String postBlogAddMain(@RequestParam String title,
								  @RequestParam String author,
								  @RequestParam String description,
								  @RequestParam String content,
								  Model model) {

		PostModel postModel = new PostModel(title, description, content, author);
		postModel.setId(UUID.randomUUID().toString());
		postRepo.save(postModel);

		return "redirect:/blog";
	}

	@GetMapping("/blog/{id}")
	public String getBlogDetail(@PathVariable(value = "id") String id, Model model) {
		Optional<PostModel> post = postRepo.findById(id);
		if (post.isPresent()) {
			model.addAttribute("post", post.get());
			return "blog-detail";
		} else {
			return "error-page";
		}
	}

	@GetMapping("/blog/edit/{id}")
	public String putBlogDetail(@PathVariable(value = "id") String id, Model model) {
		Optional<PostModel> post = postRepo.findById(id);
		if (post.isPresent()) {
			model.addAttribute("post", post.get());
			return "edit-post";
		} else {
			return "error-page";
		}
	}
	@PostMapping("/blog/edit/{id}")
	public String patchBlogMain(@PathVariable(value = "id") String id,
								@RequestParam String title,
								@RequestParam String author,
								@RequestParam String description,
								@RequestParam String content,
								Model model) {

		PostModel post = postRepo.findById(id).orElseThrow();

		post.setTitle(title);
		post.setAuthor(author);
		post.setDescription(description);
		post.setContent(content);

		postRepo.save(post);

		return "redirect:/blog";
	}

	@GetMapping("/blog/delete/{id}")
	public String deleteBlogDetail(@PathVariable(value = "id") String id, Model model) {
		Optional<PostModel> post = postRepo.findById(id);
		if (post.isPresent()) {
			postRepo.deleteById(id);
			return "redirect:/blog";
		} else {
			return "error-page";
		}
	}

}

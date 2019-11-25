package br.com.simulated.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.simulated.models.Questions;
import br.com.simulated.repository.QuestionRepository;

@Controller
@RequestMapping("/")
public class QuestionController {
	
	private QuestionRepository repository;
	
	@Autowired
	public QuestionController(QuestionRepository qr) {
		this.repository = qr;
	}
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Questions> insertQuestion() {
		Iterable<Questions> insertQuestion = repository.findAll();
		return insertQuestion;
	}
	
	@PostMapping()
	public String insertQuestion(@RequestBody @Valid Questions question) {
		repository.save(question);
		return "redirect:/";
	}
	
	@DeleteMapping()
	public String deleteQuestion(@RequestBody Questions question) {
		repository.delete(question);
		return "redirect:/";
	}
}

package com.interglobe.test.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.interglobe.test.aop.Log;
import com.interglobe.test.constant.ToDoPageViewName;
import com.interglobe.test.entity.Note;
import com.interglobe.test.service.NoteService;

/**
 * 
 * @author Sanjib Pramanick
 *
 */
@Controller
public class HomeController {

	@Autowired
	private NoteService service;

	@Log
	@GetMapping(value = "/welcome")
	public String getDashBoardView(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page) {
		model.addAttribute("notes", service.getAllNotes(new PageRequest(page, 5)));
		model.addAttribute("currentPage", page);
		return ToDoPageViewName.DASHBOARD;
	}

	@Log
	@PostMapping(value = "/note")
	public @ResponseBody Note saveNote(@RequestBody Note note) {
		return service.saveNote(note);
	}

	@Log
	@GetMapping(value = "/delete/{id}")
	public @ResponseBody Boolean deleteNote(@PathVariable("id") BigInteger noteId) {
		return service.deleteNote(noteId);
	}

	@Log
	@GetMapping(value = "/done/{id}")
	private @ResponseBody Boolean done(@PathVariable("id") BigInteger noteId) {
		try {
			Note note = service.findById(noteId);
			if (note != null) {
				note.setStatus("INACTIVE");
				service.updateNote(note);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

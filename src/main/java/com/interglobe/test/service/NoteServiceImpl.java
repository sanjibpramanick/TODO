package com.interglobe.test.service;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.interglobe.test.aop.Log;
import com.interglobe.test.entity.Note;
import com.interglobe.test.repository.NoteRepository;

/**
 * 
 * @author Sanjib Pramanick
 *
 */
@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteRepository repo;

	@Log
	@Override
	public Note saveNote(Note note) {
		note.setCreateDate(Calendar.getInstance().getTime());
		note.setModifiedDate(Calendar.getInstance().getTime());
		note.setStatus("ACTIVE");
		return repo.save(note);
	}

	@Log
	@Override
	public List<Note> getAllNotes() {
		return repo.findAll();
	}

	@Log
	@Override
	public Note updateNote(Note note) {
		note.setModifiedDate(Calendar.getInstance().getTime());
		return repo.save(note);
	}

	@Log
	@Override
	public boolean deleteNote(BigInteger noteId) {
		try {
			repo.deleteById(noteId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public Page<Note> getAllNotes(Pageable page) {
		return repo.findAll(page);
	}

	@Override
	public Note findById(BigInteger noteId) {
		Optional<Note> note = repo.findById(noteId);
		if (note.isPresent()) {
			return note.get();
		}
		return null;
	}

}

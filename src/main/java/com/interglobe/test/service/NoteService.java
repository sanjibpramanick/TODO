package com.interglobe.test.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.interglobe.test.entity.Note;


/**
 * 
 * @author Sanjib Pramanick
 *
 */

public interface NoteService {

	public Note saveNote(Note note);

	public List<Note> getAllNotes();

	public Page<Note> getAllNotes(Pageable page);

	public Note updateNote(Note note);

	public boolean deleteNote(BigInteger noteId);
	
	public Note findById(BigInteger noteId);
}

package com.stackroute.keepnote.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.stackroute.keepnote.model.Note;

/*
 * This class contains the code for data storage interactions and methods 
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */
@Component
public class NoteRepository {

	/* Declare a variable called "list" to store all the notes. */
	private List<Note> notes;
	public NoteRepository() {

		/* Initialize the variable using proper data type */
		this.notes = new ArrayList<Note>();
	}

	/* This method should return all the notes in the list */

	public List<Note> getList() {
		
		return null;
	}

	/* This method should set the list variable with new list of notes */

	public void setList(List<Note> list) {
		
	}

	/*
	 * This method should Note object as argument and add the new note object into
	 * list
	 */

	public void addNote(Note note) {
		note.setCreatedAt(new Date());
		notes.add(note);
	}

	/* This method should deleted a specified note from the list */

	public boolean deleteNote(int noteId) {
		/* Use list iterator to find matching note id and remove it from the list */
		Note e_note = getNoteById(noteId);
		if(e_note!=null) {
			notes.remove(e_note);
			return true;
		}
		return false;
		
		
	}
	
//	public boolean updateNote(Note note) {
//		boolean checkNote = exists(note.getNoteId());
//		Note existingUser = get.getNoteId();
//		if(existingUser == true) {
//			
//		}
//	}

	/* This method should return the list of notes */

	public List<Note> getAllNotes() {
		
		return notes;
	}
	
//	public Note getNoteById(int noteId) {
//		Iterator<Note> itr = notes.iterator();
//		
//		Note note = null;
//		while(itr.hasNext()) {
//			note =itr.next();
//			if(no)
//		}
//	}
	
	public boolean updateNote(Note note) {
Note existingNote = getNoteById(note.getNoteId());
		
		if(existingNote!=null) {
			existingNote.setNoteId(note.getNoteId());
			existingNote.setNoteTitle(note.getNoteTitle());
			existingNote.setNoteContent(note.getNoteContent());
			existingNote.setNoteStatus(note.getNoteStatus());
			return true;
		}

		return false;
	}

	/*
	 * This method should check if the matching note id present in the list or not.
	 * Return true if note id exists in the list or return false if note id does not
	 * exists in the list
	 */

	public boolean exists(int noteId) {
		Iterator<Note> itr = notes.iterator();
		Note note = null;
		while(itr.hasNext()) {
			note = itr.next();
			if(noteId == (note.getNoteId())) {
				return true;
			}
		}
		return false;
	}
public Note getNoteById(int noteId) {
		
		Iterator<Note> itr = notes.iterator();
		
		Note note = null;
		
		while(itr.hasNext()) {
			note = itr.next();
			if(noteId == (note.getNoteId())) {
				return note;
			}
		}
		
		return null;
	}

}
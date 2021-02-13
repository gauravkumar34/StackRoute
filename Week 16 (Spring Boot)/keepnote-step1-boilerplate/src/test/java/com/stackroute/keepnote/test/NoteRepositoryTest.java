package com.stackroute.keepnote.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stackroute.keepnote.model.Note;
import com.stackroute.keepnote.repository.NoteRepository;

public class NoteRepositoryTest {
	
	NoteRepository noteRepository;

	@Before
	public void setup() {
		noteRepository = new NoteRepository();
	}

	@After
	public void teardown() {
	}

	@Test
	public void testAddNote() {
		assertTrue(noteRepository != null);
		Note note = new Note();
		note.setNoteId(1);
		note.setNoteTitle("Technology");
		note.setNoteContent("Spring");
		note.setNoteStatus("Completed");
		noteRepository.addNote(note);
		assertTrue(noteRepository.exists(note.getNoteId()));
		// remove the data from data structure now
		noteRepository.deleteNote(1);
		// verify data is cleared
		assertFalse(noteRepository.exists(1));
	}

	@Test
	public void testDeleteNote() {
		assertTrue(noteRepository != null);
		Note note = new Note();
		note.setNoteId(1);
		note.setNoteTitle("Technology");
		note.setNoteContent("Spring");
		note.setNoteStatus("Completed");
		// saving the note
		noteRepository.addNote(note);
		// verify note saved exists or not?
		assertTrue(noteRepository.exists(note.getNoteId()));
		// delete the note
		noteRepository.deleteNote(note.getNoteId());
		// verify if note still exists or not
		assertFalse(noteRepository.exists(note.getNoteId()));
		// assertTrue(noteRepository.exists(note.getNoteId()));
	}

	@Test
	public void testGetAllNotes() {
		Note note = new Note();
		note.setNoteId(1);
		note.setNoteTitle("Technology");
		note.setNoteContent("Spring");
		note.setNoteStatus("Completed");
		// saving the note
		noteRepository.addNote(note);
		Note note1 = new Note();
		note1.setNoteId(2);
		note1.setNoteTitle("Expenses");
		note1.setNoteContent("15000");
		note1.setNoteStatus("Finished");
		noteRepository.addNote(note1);
		// verify note saved exists or not?
		assertTrue(noteRepository.exists(note.getNoteId()));
		assertTrue(noteRepository.exists(note1.getNoteId()));
		// get all notes now
		List<Note> notes = noteRepository.getAllNotes();
		Iterator<Note> itr = notes.iterator();
		while (itr.hasNext()) {
			Note tempnote = itr.next();
			System.out.println(tempnote.getNoteId());
		}
		assertEquals(notes.size(), 2);
	}
}
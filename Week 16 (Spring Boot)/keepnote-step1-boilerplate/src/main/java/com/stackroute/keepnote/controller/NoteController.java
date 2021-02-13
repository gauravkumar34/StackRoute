


package com.stackroute.keepnote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.keepnote.model.Note;
import com.stackroute.keepnote.repository.NoteRepository;

/*Annotate the class with @Controller annotation. @Controller annotation is used to mark 
 * any POJO class as a controller so that Spring can recognize this class as a Controller
 * */
@Controller
public class NoteController {
	/*
	 * From the problem statement, we can understand that the application requires
	 * us to implement the following functionalities.
	 * 
	 * 1. display the list of existing notes from the collection. Each note should
	 * contain Note Id, title, content, status and created date. 2. Add a new note
	 * which should contain the note id, title, content and status. 3. Delete an
	 * existing note. 4. Update an existing note.
	 */

	private NoteRepository noteRepository;

	/*
	 * Get the application context from resources/beans.xml file using
	 * ClassPathXmlApplicationContext() class. Retrieve the Note object from the
	 * context. Retrieve the NoteRepository object from the context.
	 */

	// public NoteController() {

	// }

	@Autowired
	public NoteController(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	// get all notes
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("noteList", noteRepository.getAllNotes());
		return "index";
	}

	@PostMapping("/saveNote")
	public String addNote(@RequestParam("noteId") int noteId, @RequestParam("noteTitle") String noteTitle,
			@RequestParam("noteContent") String noteContent, @RequestParam("noteStatus") String noteStatus) {

		Note noteExist = noteRepository.getNoteById(noteId);
		if (noteExist != null) {
			noteExist.setNoteId(noteId);
			noteExist.setNoteTitle(noteTitle);
			noteExist.setNoteContent(noteContent);
			noteExist.setNoteStatus(noteStatus);
			noteRepository.updateNote(noteExist);
		} else {
			if (noteTitle != null || noteContent != null || noteStatus != null) {
				Note note = new Note(noteId, noteTitle, noteContent, noteStatus);
				noteRepository.addNote(note);
				return "index";
			}
		}

		return "redirect:/";
	}

	@GetMapping("/deleteNote")
	public String deleteNote(@RequestParam("noteId") int noteId) {
		noteRepository.deleteNote(noteId);
		return "redirect:/";
	}

	@GetMapping("/updateNote/{noteId}")
	public String updateNote(@PathVariable("noteId") int noteId, ModelMap model) {
		Note noteItem = noteRepository.getNoteById(noteId);
		model.addAttribute("noteItem", noteItem);
		model.addAttribute("noteList", noteRepository.getAllNotes());

		return "index";

	}

	/*
	 * Define a handler method to read the existing notes by calling the
	 * getAllNotes() method of the NoteRepository class and add it to the ModelMap
	 * which is an implementation of Map for use when building model data for use
	 * with views. it should map to the default URL i.e. "/"
	 */

	/*
	 * Define a handler method which will read the Note data from request parameters
	 * and save the note by calling the addNote() method of NoteRepository class.
	 * Please note that the createdAt field should always be auto populated with
	 * system time and should not be accepted from the user. Also, after saving the
	 * note, it should show the same along with existing notes. Hence, reading notes
	 * has to be done here again and the retrieved notes object should be sent back
	 * to the view using ModelMap. This handler method should map to the URL
	 * "/saveNote".
	 */

	/*
	 * Define a handler method to delete an existing note by calling the
	 * deleteNote() method of the NoteRepository class This handler method should
	 * map to the URL "/deleteNote"
	 */

}
package com.stackroute.keepnote.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.keepnote.controller.NoteController;
import com.stackroute.keepnote.repository.NoteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class NoteControllerTest {

	private MockMvc mockMvc;
	@Mock
	private NoteRepository noteRepository;
	@InjectMocks
	private NoteController noteController = new NoteController(noteRepository);

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(noteController).build();
	}

	@Test
	public void testGetAllNotes() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"))
				.andExpect(forwardedUrl("index"));
	}

	@Test
	public void testAddNote() throws Exception {
		mockMvc.perform(post("/saveNote").param("noteId", "1").param("noteTitle", "Technology")
				.param("noteContent", "Spring").param("noteStatus", "Completed")).andExpect(forwardedUrl("index"));
	}

	@Test
	public void testDeleteNote() throws Exception {
		when(noteRepository.deleteNote(1)).thenReturn(true);
		mockMvc.perform(get("/deleteNote").param("noteId", "1")).andExpect(redirectedUrl("/"));
	}

	@Test
	public void testAddNoteEmptyTitleFailure() throws Exception {
		mockMvc.perform(post("/saveNote").param("noteId", "1").param("noteTitle", "").param("noteContent", "Spring")
				.param("noteStatus", "Completed")).andExpect(status().isOk()).andExpect(view().name("index"));
	}

	@Test
	public void testAddNoteEmptyContentFailure() throws Exception {
		mockMvc.perform(post("/saveNote").param("noteId", "1").param("noteTitle", "Technology").param("noteContent", "")
				.param("noteStatus", "Completed")).andExpect(status().isOk()).andExpect(view().name("index"));
	}

	@Test
	public void testAddNoteEmptyStatusFailure() throws Exception {
		mockMvc.perform(post("/saveNote").param("noteId", "1").param("noteTitle", "Technology")
				.param("noteContent", "Spring").param("noteStatus", "")).andExpect(status().isOk())
				.andExpect(view().name("index"));
	}
}
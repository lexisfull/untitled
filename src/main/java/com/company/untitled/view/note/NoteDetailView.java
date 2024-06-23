package com.company.untitled.view.note;

import com.company.untitled.entity.Note;
import com.company.untitled.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "notes/:id", layout = MainView.class)
@ViewController("Note.detail")
@ViewDescriptor("note-detail-view.xml")
@EditedEntityContainer("noteDc")
public class NoteDetailView extends StandardDetailView<Note> {
}
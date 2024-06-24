package com.company.untitled.security;

import com.company.untitled.entity.Note;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;

import io.jmix.security.role.annotation.RowLevelRole;


@RowLevelRole(name = "RowUserNoteRedactorRole", code = RowUserNoteRedactorRole.CODE)
public interface RowUserNoteRedactorRole {
    String CODE = "row-user-note-redactor";

    @JpqlRowLevelPolicy(entityClass = Note.class, where = "{E}.redactor.username = :current_user_username")
    void note();

}
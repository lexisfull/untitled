package com.company.untitled.security;

import com.company.untitled.entity.Note;
import com.company.untitled.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.security.model.RowLevelBiPredicate;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.role.annotation.JpqlRowLevelPolicy;
import io.jmix.security.role.annotation.PredicateRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import org.springframework.context.ApplicationContext;

@RowLevelRole(name = "RowUserNoteRedactorRole", code = RowUserNoteRedactorRole.CODE)
public interface RowUserNoteRedactorRole {
    String CODE = "row-user-note-redactor";

    @PredicateRowLevelPolicy(entityClass = Note.class, actions = {RowLevelPolicyAction.READ, RowLevelPolicyAction.CREATE, RowLevelPolicyAction.UPDATE, RowLevelPolicyAction.DELETE})
    default RowLevelBiPredicate<Note, ApplicationContext> notePredicate() {
        return (note, applicationContext) -> {
            CurrentAuthentication authentication = applicationContext.getBean(CurrentAuthentication.class);
            User currentUser = (User) authentication.getUser();
            return currentUser.equals(currentUser.getUsername());
        };
    }

    @JpqlRowLevelPolicy(entityClass = Note.class, where = "{E}.user.note = :current_user_note")
    void note();
}
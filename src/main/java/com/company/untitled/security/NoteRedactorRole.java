package com.company.untitled.security;

import com.company.untitled.entity.Note;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "NoteRedactorRole", code = NoteRedactorRole.CODE)
public interface NoteRedactorRole extends UiMinimalRole{
    String CODE = "note-redactor";

    @MenuPolicy(menuIds = "Note.list")
    @ViewPolicy(viewIds = "Note.list")
    void screens();

    @EntityAttributePolicy(entityClass = Note.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Note.class, actions = EntityPolicyAction.ALL)
    void note();
}
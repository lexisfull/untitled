package com.company.untitled.security;

import com.company.untitled.entity.Note;
import com.company.untitled.entity.User;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "NoteRedactorRole", code = NoteRedactorRole.CODE)
public interface NoteRedactorRole extends UiMinimalRole{
    String CODE = "note-redactor-role";

    @MenuPolicy(menuIds = "Note.list")
    @ViewPolicy(viewIds = {"Note.list", "User.list", "Note.detail", "User.detail"})
    void screens();

    @EntityAttributePolicy(entityClass = Note.class, attributes = {"redactor", "text", "name"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Note.class, attributes = "id", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Note.class, actions = EntityPolicyAction.ALL)
    void note();

    @EntityAttributePolicy(entityClass = User.class, attributes = "username", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.READ)
    void user();


}
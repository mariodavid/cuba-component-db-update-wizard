package de.diedavids.cuba.dbupdatewizard.web.screens

import com.haulmont.cuba.gui.components.ListComponent
import de.diedavids.cuba.dbupdatewizard.wizard.Message

class MessageTypeIconProvider implements ListComponent.IconProvider<Message> {
    @Override
    String getItemIcon(Message entity) {
        entity.type.icon
    }
}
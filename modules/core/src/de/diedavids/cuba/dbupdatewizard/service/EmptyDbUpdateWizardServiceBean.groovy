package de.diedavids.cuba.dbupdatewizard.service

import com.haulmont.cuba.core.global.Metadata;
import de.diedavids.cuba.dbupdatewizard.wizard.Message
import de.diedavids.cuba.dbupdatewizard.wizard.MessageType;
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(DbUpdateWizardService.NAME)
class EmptyDbUpdateWizardServiceBean implements DbUpdateWizardService {

    @Inject
    Metadata metadata

    @Override
    boolean isUpdateAvaliable() {
        false
    }

    @Override
    String getDbUpdateWizardStartMessage() {
        return ""
    }

    @Override
    Collection<Message> validatePreconditions() {
//        normal:
        []

//        sample:
//        createSampleMessages()

    }

    @Override
    Collection<Message> executeUpdate() {
//        normal:
        []

//        sample:
//        createSampleMessages()
    }

    Collection<Message> createSampleMessages() {
        def msg = metadata.create(Message)
        msg.type = MessageType.ERROR
        msg.message = "hallo123"
        [msg]
    }
}
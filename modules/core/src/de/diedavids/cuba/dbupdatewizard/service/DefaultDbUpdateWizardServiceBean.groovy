package de.diedavids.cuba.dbupdatewizard.service

import de.diedavids.cuba.dbupdatewizard.wizard.Message
import org.springframework.stereotype.Service

@Service(DbUpdateWizardService.NAME)
class DefaultDbUpdateWizardServiceBean implements DbUpdateWizardService {


    @Override
    boolean isUpdateAvaliable() {
        false
    }

    @SuppressWarnings('GetterMethodCouldBeProperty')
    @Override
    String getDbUpdateWizardStartMessage() {
        null
    }

    @Override
    Collection<Message> validatePreconditions() {
        null
    }

    @Override
    Collection<Message> executeUpdate() {
        null
    }
}
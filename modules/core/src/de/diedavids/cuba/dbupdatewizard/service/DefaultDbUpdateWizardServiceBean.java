package de.diedavids.cuba.dbupdatewizard.service;

import de.diedavids.cuba.dbupdatewizard.wizard.Message;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service(DbUpdateWizardService.NAME)
class DefaultDbUpdateWizardServiceBean implements DbUpdateWizardService {


    @Override
    public boolean isUpdateAvaliable() {
        return false;
    }

    @Override
    public String getDbUpdateWizardStartMessage() {
        return null;
    }

    @Override
    public Collection<Message> validatePreconditions() {
        return null;
    }

    @Override
    public Collection<Message> executeUpdate() {
        return null;
    }
}
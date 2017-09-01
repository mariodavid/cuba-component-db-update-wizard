package de.diedavids.cuba.dbupdatewizard.service;


import de.diedavids.cuba.dbupdatewizard.wizard.Message;

import java.util.Collection;

public interface DbUpdateWizardService {

    String NAME = "ddcduw_DbUpdateWizardService";

    boolean isUpdateAvaliable();

    String getDbUpdateWizardStartMessage();

    Collection<Message> validatePreconditions();

    Collection<Message> executeUpdate();
}
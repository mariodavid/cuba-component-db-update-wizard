package de.diedavids.cuba.dbupdatewizard.web.screens;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.data.impl.CustomCollectionDatasource;
import de.diedavids.cuba.dbupdatewizard.service.DbUpdateWizardService;
import de.diedavids.cuba.dbupdatewizard.wizard.Message;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class PreconditionsValidationDatasource extends CustomCollectionDatasource<Message, UUID> {

    private DbUpdateWizardService dbUpdateWizardService = AppBeans.get(DbUpdateWizardService.NAME);

    @Override
    protected Collection<Message> getEntities(Map params) {
        return dbUpdateWizardService.validatePreconditions();
    }
}
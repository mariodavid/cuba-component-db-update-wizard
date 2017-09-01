package de.diedavids.cuba.dbupdatewizard.web.screens;

import com.haulmont.cuba.gui.data.impl.CustomCollectionDatasource;
import de.diedavids.cuba.dbupdatewizard.wizard.Message;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class UpdateResultsDatasource extends CustomCollectionDatasource<Message, UUID> {


    @Override
    protected Collection<Message> getEntities(Map params) {
        return (Collection<Message>) params.get("results");
    }
}
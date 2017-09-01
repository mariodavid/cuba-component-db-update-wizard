package de.diedavids.cuba.dbupdatewizard;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.Default;

@Source(type = SourceType.DATABASE)
public interface DbUpdateWizardConfiguration extends Config {

    @Property("db-update-wizard.executed")
    @Default("false")
    Boolean getExecuted();

    void setExecuted(Boolean executed);

}

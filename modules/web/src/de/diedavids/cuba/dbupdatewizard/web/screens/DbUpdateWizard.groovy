package de.diedavids.cuba.dbupdatewizard.web.screens

import com.haulmont.cuba.gui.components.*
import com.haulmont.cuba.gui.data.CollectionDatasource
import de.diedavids.cuba.dbupdatewizard.DbUpdateWizardConfiguration
import de.diedavids.cuba.dbupdatewizard.service.DbUpdateWizardService
import de.diedavids.cuba.dbupdatewizard.wizard.Message

import javax.inject.Inject

class DbUpdateWizard extends AbstractWindow {

    public static final String WIZARD_STEP_2 = 'step2'
    public static final String WIZARD_STEP_1 = 'step1'
    public static final String WIZARD_STEP_3 = 'step3'


    @Inject
    CollectionDatasource<Message, UUID> preconditionValidationDs

    @Inject
    CollectionDatasource<Message, UUID> updateResultsDs

    @Inject
    Accordion wizardAccordion

    @Inject
    Table preconditionValidationTable

    @Inject
    Table updateResultsTable

    @Inject
    Button executeUpdateBtn

    @Inject
    Button closeWizard

    @Inject
    DbUpdateWizardService dbUpdateWizardService

    @Inject
    Label dbUpdateWizardErrorMessage

    @Inject
    Label dbUpdateAvailableMessage

    @Inject
    Label dbUpdateWizardStartMessage

    @Inject
    Action startWizardAction

    @Inject
    DbUpdateWizardConfiguration dbUpdateWizardConfiguration
    
    @Override
    void init(Map<String, Object> params) {

        def iconProvider = new MessageTypeIconProvider()
        preconditionValidationTable.iconProvider = iconProvider
        updateResultsTable.iconProvider = iconProvider


        if (dbUpdateWizardService.updateAvaliable) {

            if (!dbUpdateWizardConfiguration.executed) {
                enableDbUpdateWizard()
            } else {
                showAlreadyExecutedMessage()
            }
        }
        else {
            dbUpdateWizardErrorMessage.value = formatMessage('noDbUpdateAvailableMessage')
        }
    }

    void showAlreadyExecutedMessage() {
        dbUpdateWizardErrorMessage.value = formatMessage('dbUpdateWizardAlreadyExecutedMessage')

    }

    void enableDbUpdateWizard() {
        dbUpdateWizardErrorMessage.visible = false

        dbUpdateAvailableMessage.visible = true

        dbUpdateWizardStartMessage.value = dbUpdateWizardService.dbUpdateWizardStartMessage
        dbUpdateWizardStartMessage.visible = true

        startWizardAction.enabled = true
    }

    void executeUpdate() {

        def results = dbUpdateWizardService.executeUpdate()
        dbUpdateWizardConfiguration.executed = true
        updateResultsDs.refresh([results: results])
        progressToStep3()
    }

    void startWizard() {
        if (preconditionValidationDs.items.any { it.type == de.diedavids.cuba.dbupdatewizard.wizard.MessageType.ERROR }) {
            executeUpdateBtn.enabled = false
        }
        progressToStep2()
    }

    protected void progressToStep3() {
        wizardAccordion.getTab(WIZARD_STEP_3).enabled = true
        wizardAccordion.tab = WIZARD_STEP_3
        closeWizard.enabled = true

        Accordion.Tab step2 = wizardAccordion.getTab(WIZARD_STEP_2)
        step2.caption = "$step2.caption $check"
        step2.enabled = false
    }

    protected void progressToStep2() {
        wizardAccordion.getTab(WIZARD_STEP_2).enabled = true
        wizardAccordion.tab = WIZARD_STEP_2
        closeWizard.enabled = true

        Accordion.Tab step1 = wizardAccordion.getTab(WIZARD_STEP_1)
        step1.caption = "$step1.caption $check"
        step1.enabled = false
    }

    protected String getCheck() {
        formatMessage('check')
    }

    void cancelWizard() {
        close(CLOSE_ACTION_ID)
    }

    void closeWizard() {
        close(CLOSE_ACTION_ID)
    }

}
[![license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
[![Build Status](https://travis-ci.org/mariodavid/cuba-component-db-update-wizard.svg?branch=master)](https://travis-ci.org/mariodavid/cuba-component-db-update-wizard)

# CUBA Platform Component - DB-Update Wizard

This application component can be used for creating one-off custom DB updates that should be executed by the administrator through the UI.

## Installation
Currently you have to [download](https://github.com/mariodavid/cuba-component-db-update-wizard/archive/master.zip) the app-component manually and import it into Studio. After opening it in studio, you have to execute "Run > Install app component". After that you can go into your project and add the dependency to you project through "Project Properties > Edit > custom components (+) > cuba-component-runtime-diagnose".

Note: This manual installation step will probably simplify with Version 6.6 of CUBA and studio.

## Usage
To create a custom DB-Update in your code, where you want to connect to another Database or doing some other crazy stuff, that is not really possible through the normal Update scripts of CUBA, you can create a class in your application that will extend `DefaultDbUpdateWizardService` like this:

    class MyCustomDbUpdateWizardServiceBean extends DefaultDbUpdateWizardServiceBean {
    
        @Override
        public boolean isUpdateAvaliable() {
            return true;
        }
    
        @Override
        public String getDbUpdateWizardStartMessage() {
            return "my start message";
        }
    
        @Override
        public Collection<Message> validatePreconditions() {
            // do pre-condition checks and return a Collection of Messages that will be displayed in the UI
            // If it contains a Message with MessageType.ERROR, the UI will not allow the user to proceed
            
            return null;
        }
    
        @Override
        public Collection<Message> executeUpdate() {
            // do the actual update and return a Collection of Messages that will be displayed in the UI
            
            return null;
        }
    }
 
In order to make the db wizard aware of your bean, you have to register it in the `spring.xml` of the core module of your application like this:
  
     <bean id="ddcduw_DbUpdateWizardService" class="com.company.myapp.core.MyCustomDbUpdateWizardServiceBean" />

## DB Update Wizard

The UI that the User can use to run the custom DB Update is placed under "Administration" > "DB-Update Wizard".


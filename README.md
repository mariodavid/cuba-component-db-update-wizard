[![license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
[![Build Status](https://travis-ci.org/mariodavid/cuba-component-db-update-wizard.svg?branch=master)](https://travis-ci.org/mariodavid/cuba-component-db-update-wizard)

# CUBA Platform Component - DB-Update Wizard

This application component can be used for creating one-off custom DB updates that should be executed by the administrator through the UI.


## Installation

1. Add the following maven repository `https://dl.bintray.com/mariodavid/cuba-components` to the build.gradle of your CUBA application:


    buildscript {
        
        //...
        
        repositories {
        
            // ...
        
            maven {
                url  "https://dl.bintray.com/mariodavid/cuba-components"
            }
        }
        
        // ...
    }

2. Select a version of the add-on which is compatible with the platform version used in your project:

| Platform Version | Add-on Version |
| ---------------- | -------------- |
| 6.6.x            | 0.2.x          |
| 6.5.x            | 0.1.x          |


The latest version is: `0.2.0`

Add custom application component to your project:

* Artifact group: `de.diedavids.cuba.runtimediagnose`
* Artifact name: `runtime-diagnose-global`
* Version: *add-on version*

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


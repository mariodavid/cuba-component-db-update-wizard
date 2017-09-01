package de.diedavids.cuba.dbupdatewizard.wizard;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum MessageType implements EnumClass<String> {

    ERROR("ERROR", "font-icon:EXCLAMATION"),
    WARNING("WARNING", "font-icon:INFO"),
    SUCCESS("SUCCESS", "font-icon:CHECK");

    private String id;

    private String icon;

    MessageType(String value, String icon) {
        this.id = value;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public String getIcon() {
        return icon;
    }

    @Nullable
    public static MessageType fromId(String id) {
        for (MessageType at : MessageType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
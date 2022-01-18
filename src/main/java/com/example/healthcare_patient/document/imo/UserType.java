package com.example.healthcare_patient.document.imo;


public enum UserType {
    PATIENT("PATIENT");

    private final String label;

    UserType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static UserType getByLabel(String label) {
        for (UserType userType : values()) {
            if (userType.getLabel().equals(label)) {
                return userType;
            }
        }
        return null;
    }
}
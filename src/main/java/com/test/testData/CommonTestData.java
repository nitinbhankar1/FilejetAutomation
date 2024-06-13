package com.test.testData;

/**
 * This class contains common test data which require throughout the framework
 */
public class CommonTestData {

    /**
     * This enum contains left navigation bar links
     */
    public static enum NavigationLinks {

        PARTNERS("Partners"), CLIENTS("Clients"), ENTITIES("Entities"), ORDERS("Orders");

        private final String navigationLink;

        NavigationLinks(String navigationLink) {
            this.navigationLink = navigationLink;
        }

        public String getNavigationLink() {
            return navigationLink;
        }
    }

    /**
     * This enum contains partner page fields
     */
    public static enum AddPartnerFormFields {
        Name("name"), EMAIL("email"),
        PHONE("phone"), FAX("fax"),
        Address("address"), City("city"),
        ZIP("zip"), STATE("State"),

        EMAIL_ADDRESS("Email Address"), PHONE_NUMBER("Phone number"),
        FAX_NUMBER("Fax number"), ZIP_CODE("Zip Code"), PLATFORM_PLAN("Platform Plan"),
        EMAIL_address("Email address");

        private final String addPartnerFormFields;

        AddPartnerFormFields(String PartnerPageField) {
            this.addPartnerFormFields = PartnerPageField;
        }

        public String getPartnerPageField() {
            return addPartnerFormFields;
        }
    }

    public static enum States {
        ALABAMA("Alabama"), ALASKA("Alaska"),
        MS("Mississippi");

        private final String states;

        States(String states) {
            this.states = states;
        }

        public String getState() {
            return states;
        }
    }

    /**
     * This enum contains Group page fields in partner portal
     */
    public static enum AddGroupFormFields {
        Name("group-name"), PRIMARY_CONTACT("primary-contact"),
        EMAIL("group-email"), PHONE("group-phone"),

        PRIMARY_CONTACT_SAVED("Primary Contact"),
        EMAIL_SAVED("Email"), PHONE_SAVED("Phone");
        private final String addGroupFormFields;

        AddGroupFormFields(String GroupPageField) {
            this.addGroupFormFields = GroupPageField;
        }

        public String getAddGroupFormFields() {
            return addGroupFormFields;
        }
    }

    /**
     * This enum contains left navigation bar links in partner portal
     */
    public static enum NavigationLinksPartner {

        ENTITIES("Entities"), GROUPS("Groups"), CALENDAR("Calendar");

        private final String navigationLinkPartner;

        NavigationLinksPartner(String navigationLinkPartner) {
            this.navigationLinkPartner = navigationLinkPartner;
        }

        public String getNavigationLink() {
            return navigationLinkPartner;
        }
    }

    /**
     * This enum contains Entity page fields in partner portal
     */
    public static enum AddEntityFormFields {
        FORMATIONTYPE("formation_type"), STATE("entity_state"),
        ENTITYTYPE("entity_type");

        private final String addEntityFormFields;

        AddEntityFormFields(String EntityPageField) {
            this.addEntityFormFields = EntityPageField;
        }

        public String getAddEntityFormFields() {
            return addEntityFormFields;
        }
    }


    public static enum EntityType {

        LLC("LLC"), PROFIT("Profit Corporation"), LLP("LLP");

        private final String entityType;

        EntityType(String entityType) {
            this.entityType = entityType;
        }

        public String getEntityType() {
            return entityType;
        }
    }
}
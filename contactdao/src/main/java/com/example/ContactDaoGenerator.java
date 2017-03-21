package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class ContactDaoGenerator {
    public static final String PROJECT_DIR = System.getProperty("user.dir");
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.flipkart.contacts.db");
        schema.enableKeepSectionsByDefault();

        addContact(schema);

        try {
            /* Use forward slashes if you're on macOS or Unix, i.e. "/app/src/main/java"  */
            new DaoGenerator().generateAll(schema, PROJECT_DIR + "/app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addContact(Schema schema){
        Entity contact = schema.addEntity("Contact");
        contact.addIdProperty().notNull().primaryKey();
        contact.addStringProperty("firstName");
        contact.addStringProperty("lastName");
        contact.addStringProperty("email");
        contact.addStringProperty("phoneNumber");
        contact.addStringProperty("profilePic");
        contact.addStringProperty("favorite");
        contact.addStringProperty("createdAt");
        contact.addStringProperty("updatedAt");
    }


}

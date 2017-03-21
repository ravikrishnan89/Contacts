package com.flipkart.contacts.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.flipkart.contacts.db.Contact;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CONTACT".
*/
public class ContactDao extends AbstractDao<Contact, Long> {

    public static final String TABLENAME = "CONTACT";

    /**
     * Properties of entity Contact.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property FirstName = new Property(1, String.class, "firstName", false, "FIRST_NAME");
        public final static Property LastName = new Property(2, String.class, "lastName", false, "LAST_NAME");
        public final static Property Email = new Property(3, String.class, "email", false, "EMAIL");
        public final static Property PhoneNumber = new Property(4, String.class, "phoneNumber", false, "PHONE_NUMBER");
        public final static Property ProfilePic = new Property(5, String.class, "profilePic", false, "PROFILE_PIC");
        public final static Property Favorite = new Property(6, String.class, "favorite", false, "FAVORITE");
        public final static Property CreatedAt = new Property(7, String.class, "createdAt", false, "CREATED_AT");
        public final static Property UpdatedAt = new Property(8, String.class, "updatedAt", false, "UPDATED_AT");
    };


    public ContactDao(DaoConfig config) {
        super(config);
    }
    
    public ContactDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CONTACT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"FIRST_NAME\" TEXT," + // 1: firstName
                "\"LAST_NAME\" TEXT," + // 2: lastName
                "\"EMAIL\" TEXT," + // 3: email
                "\"PHONE_NUMBER\" TEXT," + // 4: phoneNumber
                "\"PROFILE_PIC\" TEXT," + // 5: profilePic
                "\"FAVORITE\" TEXT," + // 6: favorite
                "\"CREATED_AT\" TEXT," + // 7: createdAt
                "\"UPDATED_AT\" TEXT);"); // 8: updatedAt
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CONTACT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Contact entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String firstName = entity.getFirstName();
        if (firstName != null) {
            stmt.bindString(2, firstName);
        }
 
        String lastName = entity.getLastName();
        if (lastName != null) {
            stmt.bindString(3, lastName);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(4, email);
        }
 
        String phoneNumber = entity.getPhoneNumber();
        if (phoneNumber != null) {
            stmt.bindString(5, phoneNumber);
        }
 
        String profilePic = entity.getProfilePic();
        if (profilePic != null) {
            stmt.bindString(6, profilePic);
        }
 
        String favorite = entity.getFavorite();
        if (favorite != null) {
            stmt.bindString(7, favorite);
        }
 
        String createdAt = entity.getCreatedAt();
        if (createdAt != null) {
            stmt.bindString(8, createdAt);
        }
 
        String updatedAt = entity.getUpdatedAt();
        if (updatedAt != null) {
            stmt.bindString(9, updatedAt);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Contact readEntity(Cursor cursor, int offset) {
        Contact entity = new Contact( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // firstName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // lastName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // email
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // phoneNumber
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // profilePic
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // favorite
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // createdAt
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // updatedAt
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Contact entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setFirstName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLastName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setEmail(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPhoneNumber(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setProfilePic(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setFavorite(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCreatedAt(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setUpdatedAt(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Contact entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Contact entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
package com.bakalarka.silvia.bakalarka.entities;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.DataQueryBuilder;
import com.backendless.BackendlessUser;
import com.backendless.geo.GeoPoint;

import java.util.List;

public class User {

        private String surname;
        private java.util.Date updated;
        private String name;
        private String objectId;
        private String password;
        private String username;
        private String ownerId;
        private java.util.Date created;
        public String getSurname()
        {
            return surname;
        }

        public void setSurname( String surname )
        {
            this.surname = surname;
        }

        public java.util.Date getUpdated()
        {
            return updated;
        }

        public String getName()
        {
            return name;
        }

        public void setName( String name )
        {
            this.name = name;
        }

        public String getObjectId()
        {
            return objectId;
        }

        public String getPassword()
        {
            return password;
        }

        public void setPassword( String password )
        {
            this.password = password;
        }

        public String getUsername()
        {
            return username;
        }

        public void setUsername( String username )
        {
            this.username = username;
        }

        public String getOwnerId()
        {
            return ownerId;
        }

        public java.util.Date getCreated()
        {
            return created;
        }


        public User save()
        {
            return Backendless.Data.of( User.class ).save( this );
        }

        public void saveAsync( AsyncCallback<User> callback )
        {
            Backendless.Data.of( User.class ).save( this, callback );
        }

        public Long remove()
        {
            return Backendless.Data.of( User.class ).remove( this );
        }

        public void removeAsync( AsyncCallback<Long> callback )
        {
            Backendless.Data.of( User.class ).remove( this, callback );
        }

        public static User findById( String id )
        {
            return Backendless.Data.of( User.class ).findById( id );
        }

        public static void findByIdAsync( String id, AsyncCallback<User> callback )
        {
            Backendless.Data.of( User.class ).findById( id, callback );
        }

        public static User findFirst()
        {
            return Backendless.Data.of( User.class ).findFirst();
        }

        public static void findFirstAsync( AsyncCallback<User> callback )
        {
            Backendless.Data.of( User.class ).findFirst( callback );
        }

        public static User findLast()
        {
            return Backendless.Data.of( User.class ).findLast();
        }

        public static void findLastAsync( AsyncCallback<User> callback )
        {
            Backendless.Data.of( User.class ).findLast( callback );
        }

        public static List<User> find(DataQueryBuilder queryBuilder )
        {
            return Backendless.Data.of( User.class ).find( queryBuilder );
        }

        public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<User>> callback )
        {
            Backendless.Data.of( User.class ).find( queryBuilder, callback );
        }
    
}

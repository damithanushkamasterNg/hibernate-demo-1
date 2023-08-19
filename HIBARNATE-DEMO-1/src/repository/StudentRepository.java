package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.StudentEntity;
import util.SessionFactoryConfiguration;

public class StudentRepository {

    Session session = SessionFactoryConfiguration.getInstance().getSession();

    /** Save a student entity to the database */
    public Integer saveStudent(StudentEntity studentEntity) {
        Transaction transaction = session.beginTransaction();
    
        try {
            // Persist the studentEntity object and get the generated ID
            Integer id = (Integer) session.save(studentEntity);
            transaction.commit(); // Commit the transaction
            return id;
    
        } catch (Exception e) {
            transaction.rollback(); // Rollback the transaction on exception
            return -1;
        }
    }
    
    /** Retrieve a student entity by ID from the database */
    public StudentEntity getStudent(int id) {
        // Fetch the student entity using the session's get() method
        StudentEntity entity = session.get(StudentEntity.class, id);
        return entity;
    }
    
    /** Update a student entity in the database */
    public void updateStudent(StudentEntity studentEntity) {
        Transaction transaction = session.beginTransaction();
        try {
            // Update the studentEntity object
            session.update(studentEntity);
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            transaction.rollback(); // Rollback the transaction on exception
            throw e; // Re-throw the exception
        }
    }
    
    /** Delete a student entity by studentEntity from the database */
    public void deleteStudent(StudentEntity studentEntity) {
        Transaction transaction = session.beginTransaction();
        try {
            // Delete the student entity using the session's delete() method
            if (studentEntity != null) {
                session.delete(studentEntity);
            }
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            transaction.rollback(); // Rollback the transaction on exception
            throw e; // Re-throw the exception
        }
    }
    
}

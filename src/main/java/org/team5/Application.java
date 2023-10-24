package org.team5;

import org.team5.dao.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Application {

    public static void main(String[] args) {

        EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        try{

        }catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }



    }
}

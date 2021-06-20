package by.tms.dao;

import by.tms.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Address address){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(address);
    }

    public Address findByAddress(String street, String home){
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Address where street = : street and home = : home", Address.class)
                .setParameter("street", street)
                .setParameter("home", home)
                .getSingleResult();
    }

    public boolean contains(String street, int home){
        Session currentSession = sessionFactory.getCurrentSession();
        Long indicator = (Long) currentSession
                .createQuery("select count (*) from Address where street =: street and home = : home")
                .setParameter("street", street)
                .setParameter("home", home)
                .uniqueResult();
        return indicator >0L;
    }

}

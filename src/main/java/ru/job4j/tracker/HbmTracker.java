package ru.job4j.tracker;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private static final Logger LOG = LoggerFactory.getLogger(HbmTracker.class.getName());

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public void init() {

    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        boolean successful = false;
        try {
            Item itemToUpdate = session.get(Item.class, Integer.parseInt(id));
            itemToUpdate.setName(item.getName());
            session.update(itemToUpdate);
            session.getTransaction().commit();
            successful = true;
        } catch (HibernateException e) {
            LOG.error("Replacing went wrong", e);
        } finally {
            session.close();
        }
        return successful;

    }

    @Override
    public boolean delete(String id) {
        Session session = sf.openSession();
        session.beginTransaction();
        boolean successful = false;
        try {
            session.delete(session.get(Item.class, Integer.parseInt(id)));
            session.getTransaction().commit();
            successful = true;
        } catch (HibernateException e) {
            LOG.error("Deleting went wrong", e);
        } finally {
            session.close();
        }
        return successful;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }


    //
    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        Criteria criteria;
        criteria = session.createCriteria(Item.class)
                .add(Restrictions.like("name", key));
        List<Item> items = criteria.list();
        session.getTransaction().commit();
        session.close();
        return items;
    }

    @Override
    public Item findById(String id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, Integer.parseInt(id));
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    public void deleteAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Item> instances = session.createCriteria(Item.class).list();
        for (Object obj : instances) {
            session.delete(obj);
        }
        session.getTransaction().commit();
        session.close();
    }
}

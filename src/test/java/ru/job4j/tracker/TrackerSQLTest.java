package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TrackerSQLTest {
    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
        }
    }


    @Test
    public void replaceItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("desc");
            tracker.add(item);
            tracker.replace(String.valueOf(item.getId()), new Item("replaced"));
            assertThat(tracker.findById(String.valueOf(item.getId())).getName(), is("replaced"));
        }
    }

    @Test
    public void deleteItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("desc");
            tracker.add(item);
            tracker.delete(String.valueOf(item.getId()));
            assertThat(tracker.findByName("desc").size(), is(0));
        }
    }

    @Test
    public void findAll() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item(Integer.parseInt("1"), "desc-1"));
            tracker.add(new Item(Integer.parseInt("2"), "desc-2"));
            tracker.add(new Item(Integer.parseInt("3"), "desc-3"));
            assertThat(tracker.findAll().size(), is(5));
        }
    }

    @Test
    public void findByName() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item(Integer.parseInt("1"), "desc-1"));
            assertThat(tracker.findByName("desc-1").size(), is(1));
        }
    }

    @Test
    public void findById() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("desc");
            tracker.add(item);
            assertThat(tracker.findById( String.valueOf(item.getId())).getName(), is("desc"));
        }
    }




}


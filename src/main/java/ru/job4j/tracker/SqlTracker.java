package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SqlTracker implements Store {
    private static final Logger LOG = LoggerFactory.getLogger(SqlTracker.class);
    private Connection cn;

    private static final String INSERT_REQUEST = "insert into items(name) values(?) returning id;";
    private static final String UPDATE_REQUEST = "update items set name = ? where id = ?;";
    private static final String DELETE_REQUEST = "delete from items where id = ?;";
    private static final String FINDALL_REQUEST = "select * from items;";
    private static final String FINDBYNAME_REQUEST = "select * from items where name like ?;";
    private static final String FINDBYID_REQUEST = "select * from items where id = ?;";



    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        LOG.debug("Insert data, name: {}", item.getName());
            try (PreparedStatement ps = cn.prepareStatement(INSERT_REQUEST)) {
                ps.setString(1, item.getName());
                try (ResultSet result = ps.executeQuery()) {
                    if (result.next()) {
                        LOG.debug("Inserting complete");
                        item.setId(String.valueOf(result.getInt(1)));
                        LOG.debug("Generated id: {}", item.getId());
                    } else {
                        LOG.debug("Inserting is fallen");
                    }
                }
            } catch (Exception e) {
                LOG.debug("Something went wrong", e);
            }
            return item;
    }


    @Override
    public boolean replace(String id, Item item) {
        LOG.debug("Replace data, id {}, name: {}", id, item.getName());
        boolean rs = false;
        try (PreparedStatement ps = cn.prepareStatement(UPDATE_REQUEST)) {
            ps.setNString(1, item.getName());
            ps.setInt(2, Integer.parseInt(id));
            rs = ps.executeUpdate() > 0;
            LOG.debug("Replace complete. Result: {}", rs);
        } catch (SQLException e) {
            LOG.error("Something goes wrong", e);
            rs = false;
        }
        return rs;
    }

    @Override
    public boolean delete(String id) {
        LOG.debug("Delete data, id {}", id);
        boolean rs = false;
        try (PreparedStatement ps = cn.prepareStatement(DELETE_REQUEST)) {
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeUpdate() > 0;
            LOG.debug("Delete complete. Result: {}", rs);
        } catch (SQLException e) {
            LOG.error("Something goes wrong", e);
            rs = false;
        }
        return rs;
    }

    @Override
    public List<Item> findAll() {
        LOG.debug("Find all");
        List<Item> items = null;
        try (PreparedStatement ps = cn.prepareStatement(FINDALL_REQUEST)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                items.add(new Item(String.valueOf(rs.getInt("id")), rs.getString("name")));
            }
            LOG.debug("Selecting complete. Found items: {}", items.size());
        } catch (SQLException e) {
            LOG.error("Something goes wrong", e);
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) throws Exception {
        LOG.debug("Find by name {}", key);
        List<Item> items = null;
        try (PreparedStatement ps = cn.prepareStatement(FINDBYNAME_REQUEST)) {
            ps.setNString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                items.add(new Item(String.valueOf(rs.getInt("id")), rs.getString("name")));
            }
            LOG.debug("Selecting complete. Found items: {}", items.size());
        } catch (SQLException e) {
            LOG.error("Something goes wrong", e);
        }
        LOG.debug("Found {} items", items.size());
        return items;
    }

    @Override
    public Item findById(String id) throws Exception {
        LOG.debug("find by ID {}", id);
        Item item = null;
        try (PreparedStatement ps = cn.prepareStatement(FINDBYID_REQUEST)) {
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            item = new Item(String.valueOf(rs.getInt("id")), rs.getString("name"));
        } catch (SQLException e) {
            LOG.error("Something goes wrong", e);
        }
        LOG.debug("The item is found id {}, name {}", item.getId(), item.getName());
        return item;
    }
}
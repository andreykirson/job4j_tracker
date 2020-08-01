package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SqlTracker implements Store {
    private static final Logger log = LoggerFactory.getLogger(SqlTracker.class);
    private Connection cn;

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
        Connection conn = null;
        PreparedStatement statement = null;
        String SQL = "insert into items (name) values (?)";
        SqlTracker sqlTracker = new SqlTracker();
        sqlTracker.init();
        try {
            conn = sqlTracker.cn;
            statement = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            statement.setNString(1, item.getName());
            ResultSet rs = statement.executeQuery();
            rs.close();
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        Connection conn = null;
        PreparedStatement statement = null;
        String SQL = "update items set name = ? where id = ?";
        SqlTracker sqlTracker = new SqlTracker();
        sqlTracker.init();
        boolean rs = false;
        int findId = Integer.parseInt(id);
        try {
            conn = sqlTracker.cn;
            statement.setNString(findId, item.getName());
            statement = conn.prepareStatement(SQL);
            statement.executeUpdate();
            statement.close();
            rs = true;
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            rs = false;
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
        return rs;
    }

    @Override
    public boolean delete(String id) {
        Connection conn = null;
        PreparedStatement statement = null;
        String SQL = "delete from items where id = ?";
        SqlTracker sqlTracker = new SqlTracker();
        sqlTracker.init();
        boolean rs = false;
        int findId = Integer.parseInt(id);
        try {
            conn = sqlTracker.cn;
            statement.setInt(1, findId);
            statement = conn.prepareStatement(SQL);
            statement.executeUpdate();
            statement.close();
            rs = true;
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            rs = false;
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
        return rs;
    }

    @Override
    public List<Item> findAll() {
        Connection conn = null;
        PreparedStatement statement = null;
        String SQL = "select name from items";
        SqlTracker sqlTracker = new SqlTracker();
        sqlTracker.init();
        List<Item> item = null;
        try {
            conn = sqlTracker.cn;
            statement = conn.prepareStatement(SQL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                item.add(new Item(rs.getString("name")));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
        return item;
    }

    @Override
    public List<Item> findByName(String key) {
        String findName = key;
        Connection conn = null;
        PreparedStatement statement = null;
        String SQL = "SELECT name from items where name = ?";
        SqlTracker sqlTracker = new SqlTracker();
        sqlTracker.init();
        List<Item> item = null;
        try {
            conn = sqlTracker.cn;
            statement = conn.prepareStatement(SQL);
            statement.setNString(1, findName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                item.add(new Item(rs.getString("name")));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
        return item;
    }

    @Override
    public Item findById(String id) throws SQLException {
        int findId = Integer.parseInt(id);
        Connection conn = null;
        PreparedStatement statement = null;
        String SQL = "SELECT name from items where id = ?";
        SqlTracker sqlTracker = new SqlTracker();
        sqlTracker.init();
        Item item = null;
        try {
            conn = sqlTracker.cn;
            statement = conn.prepareStatement(SQL);
            statement.setInt(1, findId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                item = new Item(rs.getString("name"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
        return item;
    }
}
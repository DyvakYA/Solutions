package mysql1.dao;

import mysql1.entity.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClientDAO2 extends AbstractDAO<Client> implements ClientDAO {
    Connection conn;

    public ClientDAO2(Connection conn, String table) {
        super(conn, table);
        this.conn = conn;
    }

    @Override
    public List<Client> getAll() throws InstantiationException, IllegalAccessException {
        Class<?> cls = Client.class;
        return super.getAll((Class<Client>) cls);
    }

    @Override
    public Client findById(int id) throws InstantiationException, IllegalAccessException {
        Class<?> cls = Client.class;
        return super.findById((Class<Client>) cls, id);
    }

    @Override
    public void create(Client client) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        Class<?> cls = Client.class;
        super.create((Class<Client>) cls, client);
    }

    @Override
    public void update(Client client) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        Class<?> cls = Client.class;
        super.update((Class<Client>) cls, client, client.getId());
    }

    @Override
    public void delete(long id) throws SQLException {
        super.delete(id);
    }
}

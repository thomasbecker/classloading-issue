import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jolbox.bonecp.BoneCPDataSource;

// ========================================================================
// Copyright (c) 2009-2009 Mort Bay Consulting Pty. Ltd.
// ------------------------------------------------------------------------
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// and Apache License v2.0 which accompanies this distribution.
// The Eclipse Public License is available at
// http://www.eclipse.org/legal/epl-v10.html
// The Apache License v2.0 is available at
// http://www.opensource.org/licenses/apache2.0.php
// You may elect to redistribute this code under either of these licenses.
// ========================================================================

/* ------------------------------------------------------------ */
/**
 */
public class ClassUsingMySQL
{
    public ClassUsingMySQL()
    {
        ApplicationContext context =
            new ClassPathXmlApplicationContext(new String[] {"spring.xml"});

        Connection connection = null;
        try
        {
            // Load the JDBC driver
            String driverName = "com.mysql.jdbc.Driver";
            // Class.forName(driverName);

            // Create a connection to the database
            String serverName = "localhost";
            String mydatabase = "operative";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";
            String password = "";

            BoneCPDataSource ds = new BoneCPDataSource();
            ds.setDriverClass(driverName);
            ds.setJdbcUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);

            connection = ds.getConnection();

            Statement stmt = connection.createStatement();
            @SuppressWarnings("unused")
            ResultSet rs = stmt.executeQuery("SELECT 1");
            System.out.println("Connection established to mysql: " + connection);
            // } catch (ClassNotFoundException e) {
            // System.err.println(e);
            // e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.err.println(e);
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (connection != null)
                    connection.close();
            }
            catch (SQLException e)
            {
                System.err.println("Couldn't close connection. This might result in a connection leak.");
                e.printStackTrace();
            }
        }
    }
}

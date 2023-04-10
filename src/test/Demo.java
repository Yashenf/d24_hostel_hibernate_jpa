package test;

import com.yashen.d24_hostel.dao.db.FactoryConfiguration;
import org.hibernate.Session;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        Session session = FactoryConfiguration.getSessionFactory().getSession();
    }
}

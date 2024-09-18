package NameGenerator.config;

import NameGenerator.data.Suffix;
import NameGenerator.data.Affix;
import NameGenerator.data.Prefix;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
        static SessionFactory sessionFactory;

      public static SessionFactory getSession(){
            Configuration configuration =new Configuration()
                    .addAnnotatedClass(Prefix.class)
                    .addPackage("NameGenerator")
                    .addAnnotatedClass(Affix.class)
                    .addAnnotatedClass(Suffix.class);
            ServiceRegistry registry = (ServiceRegistry) new StandardServiceRegistryBuilder().build();

            sessionFactory= configuration.buildSessionFactory((org.hibernate.service.ServiceRegistry) registry);
            return sessionFactory;
        }
}

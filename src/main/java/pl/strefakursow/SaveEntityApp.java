package pl.strefakursow;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.entity.Employee;

public class SaveEntityApp {

    public static void main(String[] args) {

        // stworzyć obiekt configuration
        Configuration conf = new Configuration();
        // wczytać plik configuracyjny
        conf.configure("hibernate.cfg.xml");
        // wczytanie adnotacji
        conf.addAnnotatedClass(Employee.class);
        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        // pobieranie sesji
        Session session = factory.getCurrentSession();
        // stworzenie obiektu
        Employee employee = new Employee();
        employee.setIdEmployee(1);
        employee.setFirstName("Jan");
        employee.setLastName("Kowalski");
        employee.setSalary(10000);
        // rozpoczęcie transakcji
        session.beginTransaction();
        // zapisanie pracownika
        session.save(employee);
        // zakończenie transakcji
        session.getTransaction().commit();
        // zakmknięcie obiektu SessioFactory
        factory.close();
    }
}

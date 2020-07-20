import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.entity.Employee;

public class PrimaryKeyApp {

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
        // stworzenie 3 obiektów
        Employee employee = new Employee();
        employee.setIdEmployee(1);
        employee.setFirstName("Krzysztof");
        employee.setLastName("Nowak");
        employee.setSalary(10000);

        Employee employee1 = new Employee();
        employee1.setIdEmployee(1);
        employee1.setFirstName("Janina");
        employee1.setLastName("Kowalska");
        employee1.setSalary(10000);

        Employee employee2 = new Employee();
        employee2.setIdEmployee(1);
        employee2.setFirstName("Andrzej");
        employee2.setLastName("Ziemkiewicz");
        employee2.setSalary(10000);

        // rozpoczęcie transakcji
        session.beginTransaction();
        // zapisanie 3 pracowników
        session.save(employee);
        session.save(employee1);
        session.save(employee2);
        // zakończenie transakcji
        session.getTransaction().commit();
        // zakmknięcie obiektu SessioFactory
        factory.close();
    }
}

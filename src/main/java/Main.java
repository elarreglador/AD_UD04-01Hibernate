import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        if ( session != null ) {
        	System.out.println("Sesion abierta");
        } else {
        	System.out.println("Excepcion al abrir la sesion");
        }
        System.out.println("FIN");
    }
}

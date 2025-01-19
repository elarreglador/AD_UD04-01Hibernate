import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import ud04_01Hibernate.entity.Authors;
import ud04_01Hibernate.entity.Books;

public class Main {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        if ( session != null ) {
        	System.out.println("Sesion abierta");
        } else {
        	System.out.println("Excepcion al abrir la sesion");
        }
        
        System.out.println("---------------------------");
        showAuthors(session);
        System.out.println("---------------------------");
        showBooks(session);
        System.out.println("---------------------------");
        
        System.out.println("FIN");
    }
    
    // Muestra los libros y su autor
    public static void showBooks(Session session) {
    	Query<Books> q = session.createQuery("from Books", Books.class);
    	List<Books> results = q.getResultList();
    	System.out.println("Showing books data: ");
    	
    	for (Books result : results) {
    		System.out.println(
    				result.getId() + ": " + result.getTitle() + ", by " + (
    						result.getAuthors() != null 
    							?result.getAuthors().getName()
    							: "Anonimous"
    				)
    		);
    	}
    }
    
    
    // Muestra los autores y sus libros
    public static void showAuthors(Session session) {
    	Query<Authors> q = session.createQuery("from Authors", Authors.class);
    	List<Authors> results = q.list();
    	System.out.println("Showing authors data: ");
    	
    	for (Authors result : results) {
    		System.out.println("The author " + result.getCod() + " with name " + result.getName() + " has written:");
    		result.getBookses().forEach(e -> 
    		System.out.println("- " + ((Books) e).getTitle())
    		);
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

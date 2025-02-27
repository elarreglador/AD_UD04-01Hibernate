package ud04_01Hibernate.entity;
// Generated 19 ene 2025 12:52:36 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Entidad books de la BD biblio
@Entity
@Table(name = "books", catalog = "biblio")
public class Books implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	// Definicion de las columnas de la tabla
	private int id;
	private Authors authors;
	private String title;

	// Constructor 
	public Books() {
	}

	// Constructor con argumentos
	public Books(int id) {
		this.id = id;
	}

	// Constructor con argumentos
	public Books(int id, Authors authors, String title) {
		this.id = id;
		this.authors = authors;
		this.title = title;
	}

	// Definicion de la columna
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Define la relacion ManyToOne entre books y author
	// FetchType.LAZY carga el autor cuando se accede a la propiedad codauthor
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codauthor")
	public Authors getAuthors() {
		return this.authors;
	}

	public void setAuthors(Authors authors) {
		this.authors = authors;
	}

	// Definicion de la columna
	@Column(name = "title", length = 60)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

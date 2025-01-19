package ud04_01Hibernate.entity;
// Generated 19 ene 2025 12:52:36 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authors", catalog = "biblio")
public class Authors implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "cod", unique = true, nullable = false, length = 5)
	private String cod;
	@Column(name = "name", length = 60)
	private String name;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "authors")
	private Set<Books> bookses = new HashSet<Books>(0);

	public Authors() {
	}

	public Authors(String cod) {
		this.cod = cod;
	}

	public Authors(String cod, String name, Set<Books> bookses) {
		this.cod = cod;
		this.name = name;
		this.bookses = bookses;
	}

	@Id

	@Column(name = "cod", unique = true, nullable = false, length = 5)
	public String getCod() {
		return this.cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	@Column(name = "name", length = 60)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "authors")
	public Set<Books> getBookses() {
	    return this.bookses;
	}

	public void setBookses(Set<Books> bookses) {
		this.bookses = bookses;
	}

}

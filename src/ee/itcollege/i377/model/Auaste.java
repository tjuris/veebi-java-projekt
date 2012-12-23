package ee.itcollege.i377.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
    @NamedQuery(name="Auaste.findAll", query="SELECT g FROM Auaste g WHERE g.suletud = NULL"),
    @NamedQuery(name="Auaste.findById", query="SELECT g FROM Auaste g WHERE g.id = :id")
})
@Entity
public class Auaste implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/*
	id - bigint
	kood - varchar(255)
	nimetus - varchar(255)
	tüüp - string
	version - integer
	*/
	
	private String kood;
	private String nimetus;
	
	private String tyyp;
	private int version;
	
	private String avaja;
	private String muutja;
	private String sulgeja;
	
	private Date avatud;
	private Date muudetud;
	private Date suletud;

	@OneToMany(mappedBy="auaste")
	private Collection<PiirivalvurAuaste> piirivalvurAuastes;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKood() {
		return kood;
	}

	public void setKood(String kood) {
		this.kood = kood;
	}

	public String getNimetus() {
		return nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}

	public String getTyyp() {
		return tyyp;
	}

	public void setTyyp(String tyyp) {
		this.tyyp = tyyp;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getAvaja() {
		return avaja;
	}

	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}

	public String getMuutja() {
		return muutja;
	}

	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}

	public String getSulgeja() {
		return sulgeja;
	}

	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

	public Date getAvatud() {
		return avatud;
	}

	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}

	public Date getMuudetud() {
		return muudetud;
	}

	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}

	public Date getSuletud() {
		return suletud;
	}

	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}

}

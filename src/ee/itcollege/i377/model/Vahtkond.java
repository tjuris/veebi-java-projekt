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
    @NamedQuery(name="Vahtkond.findAll", query="SELECT g FROM Vahtkond g WHERE g.suletud = NULL"),
    @NamedQuery(name="Vahtkond.findById", query="SELECT g FROM Vahtkond g WHERE g.id = :id")
})
@Entity
public class Vahtkond implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/*
	id - bigint
	kommentaar - varchar(255)
	kood - varchar(255)
	nimetus - varchar(255)
	version - integer
	piiripunkt_id string
	vaeosa_id string
	*/
	
	private String kood;
	private String kommentaar;
	private String nimetus;
	
	private int version;
	
	private String piiripunkt_id;
	private String vaeosa_id;
	
	private String avaja;
	private String muutja;
	private String sulgeja;
	
	private Date avatud;
	private Date muudetud;
	private Date suletud;

	@OneToMany(mappedBy="vahtkond")
	private Collection<VahtkonnaLiige> vahtkonnaLiiges;
	
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

	public String getPiiripunkt_id() {
		return piiripunkt_id;
	}

	public void setPiiripunkt_id(String piiripunkt_id) {
		this.piiripunkt_id = piiripunkt_id;
	}

	public String getVaeosa_id() {
		return vaeosa_id;
	}

	public void setVaeosa_id(String vaeosa_id) {
		this.vaeosa_id = vaeosa_id;
	}

	public String getKommentaar() {
		return kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
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

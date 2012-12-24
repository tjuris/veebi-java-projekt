package ee.itcollege.i377.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.format.annotation.DateTimeFormat;

@NamedQueries({
    @NamedQuery(name="VahtkonnaLiige.findAll", query="SELECT g FROM VahtkonnaLiige g WHERE g.suletud = NULL"),
    @NamedQuery(name="VahtkonnaLiige.findById", query="SELECT g FROM VahtkonnaLiige g WHERE g.id = :id")
})
@Entity
public class VahtkonnaLiige implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/*
	id - bigint
	alates - timestamp
	kuni - timestamp
	kommentaar - string
	version - integer
	vahtkond_id - long
	piirivalvur_id - long
	*/
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date alates;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date kuni;
	private String kommentaar;
	
	private int version;
	
	@ManyToOne
	@JoinColumn(name="vahtkond_id")
	private Vahtkond vahtkond;
	
	@ManyToOne
	@JoinColumn(name="piirivalvur_id")
	private Piirivalvur piirivalvur;
	
	
	private String avaja;
	private String muutja;
	private String sulgeja;
	
	private Date avatud;
	private Date muudetud;
	private Date suletud;

	public Long getId() {
		return id;
	}

	public Vahtkond getVahtkond() {
		return vahtkond;
	}

	public void setVahtkond(Vahtkond vahtkond) {
		this.vahtkond = vahtkond;
	}

	public Piirivalvur getPiirivalvur() {
		return piirivalvur;
	}

	public void setPiirivalvur(Piirivalvur piirivalvur) {
		this.piirivalvur = piirivalvur;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public Date getAlates() {
		return alates;
	}

	public void setAlates(Date alates) {
		this.alates = alates;
	}

	public Date getKuni() {
		return kuni;
	}

	public void setKuni(Date kuni) {
		this.kuni = kuni;
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

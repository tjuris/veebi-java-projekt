package ee.itcollege.i377.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(name="Piirivalvur.findAll", query="SELECT g FROM Piirivalvur g WHERE g.suletud = NULL"),
    @NamedQuery(name="Piirivalvur.findById", query="SELECT g FROM Piirivalvur g WHERE g.id = :id")
})
@Entity
public class Piirivalvur implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/*
	id - bigint
	aadress - varchar(255)
	eesnimi - varchar(255)
	email - varchar(255)
	isikukood - varchar(255)
	kommentaar - varchar(255)
	perekonnanimi - varchar(255)
	sodurikood - varchar(255)
	sugu - integer
	telefon - varchar(255)
	version - integer
	*/
	
	private String aadress;
	private String eesnimi;
	private String email;
	private String isikukood;
	private String kommentaar;
	private String perekonnanimi;
	private String sodurikood;
	private String telefon;

	private int sugu;
	private int version;
	
	private String avaja;
	private String muutja;
	private String sulgeja;
	
	private Date avatud;
	private Date muudetud;
	private Date suletud;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAadress() {
		return aadress;
	}

	public void setAadress(String aadress) {
		this.aadress = aadress;
	}

	public String getEesnimi() {
		return eesnimi;
	}

	public void setEesnimi(String eesnimi) {
		this.eesnimi = eesnimi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsikukood() {
		return isikukood;
	}

	public void setIsikukood(String isikukood) {
		this.isikukood = isikukood;
	}

	public String getKommentaar() {
		return kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public String getPerekonnanimi() {
		return perekonnanimi;
	}

	public void setPerekonnanimi(String perekonnanimi) {
		this.perekonnanimi = perekonnanimi;
	}

	public String getSodurikood() {
		return sodurikood;
	}

	public void setSodurikood(String sodurikood) {
		this.sodurikood = sodurikood;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public int getSugu() {
		return sugu;
	}

	public void setSugu(int sugu) {
		this.sugu = sugu;
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

package dto;

import java.io.Serializable;


public class ActorDto extends CommonProperty implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String birthYear;
	private String deathYear;
	private String primaryProfession;
	private String knownForTitles;
	
	
	public ActorDto() {
		this.name = "";
		this.birthYear = "";
		this.deathYear = "";
		this.primaryProfession = "";
		this.knownForTitles = null;
	 }


	
	
	public ActorDto(String id, String name, String birthYear, String deathYear, String primaryProfession,
			String knownForTitles) {
		super(id);
		this.name = name;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.primaryProfession = primaryProfession;
		this.knownForTitles = knownForTitles;
	}




	public ActorDto( String name, String birthYear, String deathYear,
			String primaryProfession, String knownForTitles) {
		this.name = name;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.primaryProfession = primaryProfession;
		this.knownForTitles = knownForTitles;
	}


	@Override
	public String toString() {
		return  "\t\t" + name .toUpperCase()+  "\n\n\t\tDogum Tarihi\t : " + birthYear + "\n\t\tOlum Tarihi \t : "
				+ deathYear + "\n\t\tBirincil Meslek  : " + primaryProfession.toUpperCase() +"\n\t\tOynadigi Filmler :" ;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	


	public String getBirthYear() {
		return birthYear;
	}


	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}


	public String getDeathYear() {
		return deathYear;
	}


	public void setDeathYear(String deathYear) {
		this.deathYear = deathYear;
	}


	public String getPrimaryProfession() {
		return primaryProfession;
	}


	public void setPrimaryProfession(String primaryProfession) {
		this.primaryProfession = primaryProfession;
	}


	public String getKnownForTitles() {
		return knownForTitles;
	}


	public void setKnownForTitles(String knownForTitles) {
		this.knownForTitles = knownForTitles;
	}
	
	
	
	
}

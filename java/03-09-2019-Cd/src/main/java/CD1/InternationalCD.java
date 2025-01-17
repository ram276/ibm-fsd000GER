package CD1;


import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("international_cd")
public class InternationalCD extends CD {
	private String languages;
	private int region;

	public InternationalCD() {
	}

	public InternationalCD(String title, String artist, Date purchaseDate, double cost, String language, int region) {
		super(title, artist, purchaseDate, cost);
		languages = language;
		this.region = region;
	}

	public InternationalCD(String languages, int region) {
		super();
		this.languages = languages;
		this.region = region;
	}

	public void setLanguages(String s) {
		languages = s;
	}

	public String getLanguages() {
		return languages;
	}

	public void setRegion(int i) {
		region = i;
	}

	public int getRegion() {
		return region;
	}
	
}
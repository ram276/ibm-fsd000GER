package CD1;

import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("special_edition_cd")
public class SpecialEditionCD extends CD {
	private String newfeatures;

	public SpecialEditionCD() {
	}

	public SpecialEditionCD(String title, String artist, Date purchaseDate, double cost, String features) {
		super(title, artist, purchaseDate, cost);
		newfeatures = features;
	}

	public void setNewfeatures(String s) {
		newfeatures = s;
	}

	public String getNewfeatures() {
		return newfeatures;
	}
}

    



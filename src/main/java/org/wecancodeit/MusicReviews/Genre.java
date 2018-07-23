package org.wecancodeit.MusicReviews;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue
	private Long id;
	private String genreType;
	
	@OneToMany(mappedBy = "genre")
	private Collection<Albums> albums;
	
	public Genre() {}

	public Genre(String genreType) {
		this.genreType = genreType;
	}

	public Long getId() {
		return id;
	}

	public String getGenreType() {
		return genreType;
	}

//	public Collection<Albums> getArtist() {
//		return albums;
//	}

	@Override
	public String toString() {
		return  genreType;
	}
	
	
	
}

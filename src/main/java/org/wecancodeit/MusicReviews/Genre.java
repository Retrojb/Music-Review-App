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
	private String Genre;
	
	@OneToMany(mappedBy = "genre")
	private Collection<Albums> albums;
	
	public Genre() {}

	public Genre(String genre) {
		Genre = genre;
	}

	public Long getId() {
		return id;
	}

	public String getGenre() {
		return Genre;
	}

	public Collection<Albums> getArtist() {
		return albums;
	}

	@Override
	public String toString() {
		return  Genre;
	}
	
	
	
}

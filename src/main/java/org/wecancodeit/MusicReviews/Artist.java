package org.wecancodeit.MusicReviews;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String recordLabel;

	@OneToMany(mappedBy = "artist")
	private Collection<Albums> albums;
	
	@OneToMany(mappedBy = "artist")
	private Collection<Songs> songs;

	public Artist() {
	}

	public Artist(String name, String recordLabel) {
		this.name = name;
		this.recordLabel = recordLabel;;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRecordLabel() {
		return recordLabel;
	}

	public Collection<Albums> getAlbums() {
		return albums;
	}

	public Collection<Songs> getSongs() {
		// TODO Auto-generated method stub
		return songs;
	}

//	public Albums getAlbumByName(Albums album) {
//	}

}

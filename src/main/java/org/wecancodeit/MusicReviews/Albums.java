package org.wecancodeit.MusicReviews;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Albums {

		@Id
		@GeneratedValue
		private Long id;
		
		private String albumName;
		private String releaseDate;
		private String coverImage;
		
		
		@ManyToOne
		private Artist artist;
	
		@ManyToOne
		private Genre genre;

		@OneToMany(mappedBy = "albums")
		private Collection<Songs> songs;
		
		public Albums() {}
		
		public Albums(String albumName, String releaseDate, String coverImage, Artist artist) {
			this.albumName = albumName;
			this.releaseDate = releaseDate;
			this.coverImage = coverImage;
			this.artist = artist;
			this.genre = genre;
			
		}

		public Long getId() {
			return id;
		}

		public String getAlbumName() {
			return albumName;
		}

		public String getReleaseDate() {
			return releaseDate;
		}

		public Collection<Songs> getSongs() {
			return songs;
		}
//		public Genre getGenre() {
//			return genre;
//		}
//		public Artist getArtist() {
//			return artist;
//		}
		public String getCoverImage() {
			return coverImage;
		}

		@Override
		public String toString() {
			return albumName;
		}
		
		
		
}

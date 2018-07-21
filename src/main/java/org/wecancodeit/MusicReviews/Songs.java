package org.wecancodeit.MusicReviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Songs {
	
		@Id
		@GeneratedValue
		private Long id;

		private String songName;
		private Double length;
		
		@Lob
		private String lyrics;
		private String rating;
		
		@ManyToOne
		private Albums albums;
		
		@ManyToOne
		private Artist artist;
		
		public Songs() {}

		public Songs(String songName, Double length, String lyrics, String rating, Albums albums, Artist artist) {
			this.songName = songName;
			this.length = length;
			this.lyrics = lyrics;
			this.rating = rating;
			this.albums = albums;
			this.artist = artist;
		}

		public String getSongName() {
			return songName;
		}

		public Double getLength() {
			return length;
		}

		public String getLyrics() {
			return lyrics;
		}

		public String getRating() {
			return rating;
		}
		
		public Albums getAlbums() {
			return albums;
		}
		
		public Artist getArtist() {
			return artist;
		}
		
		@Override
		public String toString() {
			return songName + length + lyrics + rating;
		}
		
		
}

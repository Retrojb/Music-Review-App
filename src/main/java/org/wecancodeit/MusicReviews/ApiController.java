package org.wecancodeit.MusicReviews;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	AlbumsRepository albumsRepo;

	@Autowired
	ArtistRepository artistRepo;

	@Autowired
	SongsRepository songRepo;

	// Links the artist
	@RequestMapping("/artists")
	public Collection<Artist> getArtists() {
		return (Collection<Artist>) artistRepo.findAll();
	}

	// Links the artist --> album
	@RequestMapping("artists/{name}/albums")
	public Collection<Albums> getArtistAlbums(@PathVariable(name = "name") String name) {
		return (Collection<Albums>) artistRepo.findByName(name).getAlbums();
	}

	// Links the Artist --> album --> song
	@RequestMapping("artists/{name}/albums/{albumName}")
	public Collection<Songs> getArtistAlbumSong(@PathVariable(name = "name") String name,
			@PathVariable(name = "albumName") String albumName, @PathVariable(name = "songName") String songName) {
		return (Collection<Songs>) albumsRepo.findByAlbumName(albumName).getSongs();
	}

	// Allows the user to ADD/POST an Artist into the DB
	@RequestMapping(value = "/artists/", method = RequestMethod.POST)
	public Collection<Artist> addArtist(@RequestParam(value = "name") String name,
			@RequestParam(value = "recordLabel") String recordLabel) {
			// Prevents the artist from being double entered by user.
		if (artistRepo.findByName(name) == null) {
			artistRepo.save(new Artist(name, recordLabel));
		}

		return (Collection<Artist>) artistRepo.findAll();
	}

	// Returns the Artist page with the addition
	@RequestMapping(value = "/artist/{name}", method = RequestMethod.GET)
	public Artist returnArtist(@PathVariable(name = "name") String name) {
		return artistRepo.findByName(name);
	}
	
	// Allows the user to ADD/POST an Artist into the DB
		@RequestMapping(value = "/albums", method = RequestMethod.POST)
		public Collection<Albums> addAlbum(@RequestParam(value = "name") String name,
				@RequestParam(value = "albumName") String albumName,
				@RequestParam(value = "genre") String genre ,
				@RequestParam(value = "releaseDate") String releaseDate,
				@RequestParam(value = "coverImgUrl") String coverImgUrl) {
				// Prevents the artist from being double entered by user.
			if (artistRepo.findByName(name) == null) {
				artistRepo.save(new Artist(name, albumName));
			}

			return (Collection<Albums>) albumsRepo.findAll();
		}
}

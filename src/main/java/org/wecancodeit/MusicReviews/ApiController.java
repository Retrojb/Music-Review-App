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

	@Autowired
	GenreRepository genreRepo;

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
			@RequestParam(value = "recordLabel") String recordLabel,
			@RequestParam(value = "albumName") String albumName, @RequestParam(value = "genre") String genreType,
			@RequestParam(value = "releaseDate") String releaseDate,
			@RequestParam(value = "coverImgUrl") String coverImgUrl) {

		// Prevents the artist from being double entered by user.
		Artist artist = artistRepo.findByName(name);
		if (artist == null) {
			artist = new Artist(name, recordLabel);
			artistRepo.save(artist);
		}

		// Adds Genre with the album, leaving the Artist away from a specific genre
		Genre genre = genreRepo.findByGenreType(genreType);
		if (genre == null) {
			genre = new Genre(genreType);
			genreRepo.save(genre);
		}

		albumsRepo.save(new Albums(albumName, releaseDate, coverImgUrl, genre, artist));

		return (Collection<Albums>) albumsRepo.findAll();
	}

	@RequestMapping(value = "/albums", method = RequestMethod.GET)
	public Albums returnAlbum(@PathVariable(name = "albumName") String albumName) {
		return albumsRepo.findByAlbumName(albumName);
	}

	// Allows the user to ADD/POST an Song into the DB
	@RequestMapping(value = "/album/{album.albumName}", method = RequestMethod.POST)
	public Collection<Songs> addSongs(@RequestParam(value = "name") String name,
			@RequestParam(value = "albumName") String albumName, @RequestParam(value = "songName") String songName,
			@RequestParam(value = "length") Double length, @RequestParam(value = "lyrics") String lyrics,
			@RequestParam(value = "rating") String rating) {

		Artist artist = artistRepo.findByName(name);
		if (artist == null) {
			artist = new Artist(name, albumName);

			Albums albums = albumsRepo.findByAlbumName(albumName);

			if (albumName == null) {
				albums = new Albums();
			}

			albumsRepo.save(albums);
			artistRepo.save(artist);
		}

		Songs song = songRepo.findBySongName(songName);

		if (song == null) {
			song = new Songs(songName, length, lyrics, rating, albumsRepo.findByAlbumName(albumName), artist);
		}
		songRepo.save(song);

		return (Collection<Songs>) songRepo.findAll();
	}

	@RequestMapping(value = "/album/{album.albumName}", method = RequestMethod.GET)
	public Songs returnSong(@PathVariable(name = "songName") String songName) {
		return songRepo.findBySongName(songName);
	}
}

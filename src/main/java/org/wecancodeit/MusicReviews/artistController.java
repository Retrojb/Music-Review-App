package org.wecancodeit.MusicReviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class artistController {

	@Autowired
	ArtistRepository artistRepo;

	@Autowired
	AlbumsRepository albumRepo;

	@Autowired
	SongsRepository songRepo;

	//Index currently a place holding page 
	@RequestMapping("/")
	public String home() {
		return "index";
	}

	//Artist
	// Hits the ARTISTS page. 
	@RequestMapping("/artists")
	public String getArtists(Model model) {
		model.addAttribute("artists", artistRepo.findAll());
		return "artists";
	}

	//Allows user to go to a SPECIFIC ARTIST in the list of ARTISTS
	@RequestMapping("/artist/{name}")
	public String getArtist(@PathVariable(name = "name") String name, Model model) {
		model.addAttribute("artist", artistRepo.findByName(name));
		return "artist";
	}
	
	
	//Albums
	// Hits ALBUMS page, does not link to the Artist.
	@RequestMapping("/albums/")
	public String getAlbums(Model model) {
		model.addAttribute("albums", albumRepo.findAll());
		return "albums";
	}
	
	//Hits a ALBUM by an ARTIST
	@RequestMapping("/artist/{name}/album/{albumName}")
	public String getOneAlbum(@PathVariable(name = "name") String name,
							  @PathVariable(name = "albumName") String albumName, Model model) {
		model.addAttribute("album", albumRepo.findByAlbumName(albumName));
		return "album";
	}
	// hits am album from the collection of albums
	@RequestMapping("/albums/{albumName}")
	public String getAnAlbumFromAlbums(@PathVariable(name = "albumName") String albumName, Model model) {
		model.addAttribute("album", albumRepo.findByAlbumName(albumName));
		return "album";
	}
		
	//Songs
	//Hits SONGS page list of all SONGS
	@RequestMapping("/songs")
	public String getSongs(Model model) {
		model.addAttribute("songs", songRepo.findAll());
		return "songs";
	}
	
	//Gets a SONG
	@RequestMapping("/song/{songName}")
	public String getASong(@PathVariable(name = "songName") String songName, Model model) {
		model.addAttribute("song", songRepo.findBySongName(songName));
		return "song";
	}
	
//	//Gets a SONG from an ALBUM
//	@RequestMapping("album/{albumName}/song/{songName}")
//	public String getASongFromAnAlbum(@PathVariable(name = "songName") String songName, Model model) {
//		model.addAttribute("song", songRepo.findBySongName(songName));
//		return "song";
//	}
//	
	//gets a SONG from SONGS by an ALBUM from an ARTIST
	@RequestMapping("/artist/{name}/album/{albumName}/song/{songName}")
	public String getOneSong(@PathVariable(name = "name") String name,
							@PathVariable(name = "albumName") String albumName, 
							@PathVariable(name = "songName") String songName,
							Model model) {
		model.addAttribute("song", songRepo.findBySongName(songName));
		return "song";
	}
	

//	//gets a List of all songs by an ARTIST
//	@RequestMapping("artist/{name}/album/{albumName}/songs")
//	public String getSongsFromAlbum(@PathVariable(name = "name") String name,
//									@PathVariable(name = "albumName") String albumName, Model model) {
//		model.addAttribute("songs", songRepo.findAll());
//		return "songs";
//	}

	
	

}

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
	
	@RequestMapping("/index")
	public String home() {
		return "index";
	}

	@RequestMapping("/artists")
	public String getArtists(Model model) {
		model.addAttribute("artists", artistRepo.findAll());
		return "artists";
	}
	
	@RequestMapping("/albums")
	public String getAlbums(Model model) {
		model.addAttribute("albums", albumRepo.findAll());
		return "albums";
	}
	
	@RequestMapping("/songs")
	public String getSongs(Model model) {
		model.addAttribute("songs", songRepo.findAll());
		return "songs";
	}
	
	@RequestMapping("/album/{albumName}")
	public String getAlbum(@PathVariable(name = "albumName") String albumName, Model model) {
		model.addAttribute("album", albumRepo.findByAlbumName(albumName));
		return "album";
	}
	
	@RequestMapping("/artist/{name}")
	public String getArtist(@PathVariable(name = "name") String name, Model model) {
		model.addAttribute("artist", artistRepo.findByName(name));
		return "artist";	
	}
	
	@RequestMapping("/album/{albumName}/song/{songName}")
	public String getSong(@PathVariable(name = "songName") String songName, Model model) {
		model.addAttribute("song", songRepo.findBySongName(songName));
		return "song";	
	}
	
	@RequestMapping("/album/{albumName}/songs/{songs}")
	public String getSongsFromAlbum(@PathVariable(name = "albumName") String albumName,
									@PathVariable (name = "songName") String songName, Model model) {
		model.addAttribute("songs", songRepo.findAll());
		return "songs";
	}
	
	@RequestMapping(value = "/artists", method = RequestMethod.POST)
	public String addArtist(String name, String recordLabel) {
		Artist artist = artistRepo.findByName(name);
		if (artist != null) {
			artistRepo.save(new Artist(name, recordLabel));
		}
		return "redirect:/artists" + name;
	}
	
	@RequestMapping("/artist/{name}/album/{albumName}")
	public String getAlbumByName(@PathVariable(name = "name") String name,
								@PathVariable(name = "albumName") String albumName, Model model) {
		model.addAttribute("album", albumRepo.findByAlbumName(albumName));
		return "album";
	}
	@RequestMapping("artist/{name}/album/{albumName}/song/{song}")
	public String getOneSong(@PathVariable(name = "name") String name,
							@PathVariable(name = "albumName")String albumName,
							@PathVariable(name = "songName") String songName, Model model) {
		model.addAttribute("song", songRepo.findBySongName(songName));
		return "song";
	}
		
	
}

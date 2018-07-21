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
		
		@RequestMapping("/artists")
		public Collection<Artist> getArtists(){
			return(Collection<Artist>) artistRepo.findAll();
		}
		
		//this takes the artist to the album
		@RequestMapping("artists/{name}/albums")
		public Collection<Albums> getArtistAlbums(@PathVariable(name = "name") String name) {
			return (Collection<Albums>) artistRepo.findByName(name).getAlbums();
		}
		
		//this takes the album to the song
		@RequestMapping("artists/{name}/albums/{albumName}")
		public Collection<Songs> getArtistAlbumSong(@PathVariable(name = "name") String name, 
													@PathVariable(name = "albumName") String albumName,
													@PathVariable(name = "songName") String songName){
			return (Collection<Songs>) albumsRepo.findByAlbumName(albumName).getSongs();	
		}
		
		@RequestMapping(value = "/artists" , method = RequestMethod.POST)
		public Collection<Artist> addArtist(@RequestParam(value = "name") String name,
											@RequestParam(value = "recordLabel") String recordLabel) {
			if (artistRepo.findByName(name) == null) {
				artistRepo.save(new Artist(name, recordLabel));
			}
			
			return (Collection<Artist>) artistRepo.findAll();
		}
		
		@RequestMapping(value = "/artist/{name}", method = RequestMethod.GET)
		public Artist returnArtist(@PathVariable(name = "name") String name) {
			return artistRepo.findByName(name);
		}
}

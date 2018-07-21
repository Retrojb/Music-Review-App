package org.wecancodeit.MusicReviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

//@Service
public class Populator implements CommandLineRunner {

	@Autowired
	ArtistRepository artistRepo;

	@Autowired
	AlbumsRepository albumRepo;

	@Autowired
	SongsRepository songRepo;

	@Autowired
	GenreRepository genreRepo;

	@Override
	public void run(String... args) throws Exception {
//		Artist tupac = artistRepo.save(new Artist("Tupac", "Death Row Records"));
//		
//		Genre gangstaRap = genreRepo.save(new Genre("Gangsta Rap"));
//		
//		Albums makaveli = albumRepo.save(new Albums("Makaveli", "1996",
//				"google.com", tupac ,gangstaRap));
//
//				
//				
//		Songs hailMary = songRepo.save(new Songs("Hail Mary", 4.33, "Hail Mary one, two, three", "7/10", makaveli, tupac));
//		Songs ToLive = songRepo.save(new Songs("To live & Die in LA", 4.54, "To live or die in LA is the place to be", "10/10", makaveli, tupac));





	}

}

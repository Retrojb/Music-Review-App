package org.wecancodeit.MusicReviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class AlbumsController {

	@Autowired
	private AlbumsRepository albumRepo;

//	@Autowired
//	ArtistRepository artistRepo;

	@RequestMapping(value = "/albums")
	public String getAlbums(Model model) {
		model.addAttribute("albums", albumRepo.findAll());
		return "albums";
	}
	

}

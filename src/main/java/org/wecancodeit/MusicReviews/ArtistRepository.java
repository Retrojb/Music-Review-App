package org.wecancodeit.MusicReviews;

import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

	Artist findByName(String name);

}

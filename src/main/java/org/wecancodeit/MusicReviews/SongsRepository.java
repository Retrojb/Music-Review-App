package org.wecancodeit.MusicReviews;

import org.springframework.data.repository.CrudRepository;

public interface SongsRepository extends CrudRepository<Songs, Long> {

	Songs findBySongName(String songName);


}

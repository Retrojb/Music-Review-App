package org.wecancodeit.MusicReviews;

import org.springframework.data.repository.CrudRepository;

public interface AlbumsRepository extends CrudRepository<Albums, Long> {

	Albums findByAlbumName(String albumName);


}

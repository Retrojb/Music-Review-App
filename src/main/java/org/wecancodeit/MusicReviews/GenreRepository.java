package org.wecancodeit.MusicReviews;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {

	Genre findByGenreType(String genreType);

}

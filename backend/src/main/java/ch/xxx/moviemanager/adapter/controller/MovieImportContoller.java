/**
 *    Copyright 2019 Sven Loesekann
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package ch.xxx.moviemanager.adapter.controller;

import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.xxx.moviemanager.domain.model.dto.MovieDto;
import ch.xxx.moviemanager.usecase.service.MovieService;

@RestController
@RequestMapping("rest/movie/import")
public class MovieImportContoller {
	private final MovieService service;

	public MovieImportContoller(MovieService service) {
		this.service = service;
	}

	@RequestMapping(value = "/{searchStr}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MovieDto> getMovieImportSearch(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String bearerStr,
			@PathVariable("searchStr") String searchStr) throws InterruptedException, GeneralSecurityException {
		List<MovieDto> movies = this.service.findImportMovie(searchStr, bearerStr);
		return movies;
	}

	@RequestMapping(value = "/movieid/{movieId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> getMovieImport(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String bearerStr,
			@PathVariable("movieId") int movieId) throws InterruptedException, GeneralSecurityException {
		boolean success = this.service.importMovie(movieId, bearerStr);
		return success ? new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK)
				: new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.NOT_ACCEPTABLE);
	}
}

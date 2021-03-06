package com.SearchEngine.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface Resource<T> {
	@GetMapping("/search/{Country}/{id}/{searchText}/{Erase}/{isImage}")
	ResponseEntity<Page<T>> findAll(Pageable pageable,@PathVariable String Country, @PathVariable int id,@PathVariable String searchText,@PathVariable int Erase,@PathVariable int isImage);


}

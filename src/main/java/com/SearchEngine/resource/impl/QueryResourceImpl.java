package com.SearchEngine.resource.impl;

import com.SearchEngine.domain.SearchQuery;
import com.SearchEngine.resource.Resource;
import com.SearchEngine.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class QueryResourceImpl implements Resource<SearchQuery> {
	
	@Autowired
	private IService<SearchQuery> searchQueryIService;
	//for searching by query
	@Override
	public ResponseEntity<Page<SearchQuery>> findAll(Pageable pageable,String Country,int id, String searchText,int isImage,int Erase) {
		return new ResponseEntity<>(searchQueryIService.findAll(pageable,Country,id, searchText,isImage,Erase), HttpStatus.OK);
	}

}

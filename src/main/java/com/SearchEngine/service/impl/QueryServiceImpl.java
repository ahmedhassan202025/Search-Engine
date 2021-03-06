package com.SearchEngine.service.impl;

import com.SearchEngine.CR_IND_QP_RK.ImageProcessorWI;
import com.SearchEngine.CR_IND_QP_RK.QueryProcessorForWI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SearchEngine.domain.SearchQuery;
import com.SearchEngine.repository.QueryRepository;
import com.SearchEngine.service.IService;

import java.io.IOException;

@Service
public class QueryServiceImpl implements IService<SearchQuery> {

	@Autowired
	private QueryRepository queryRepository;

	@Override
	public Page<SearchQuery> findAll(Pageable pageable,String Country,int id, String searchText,int isImage,int Erase) {
		System.out.println(Erase);

		if(isImage==0){
		QueryProcessorForWI x = new QueryProcessorForWI(searchText,Country,id,Erase);
		try {
			x.Processor();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Search Query Finished");}
		else if(isImage==1){
			ImageProcessorWI y = new ImageProcessorWI(searchText,id,Country,Erase);
			y.Processor_Image();
			System.out.println("Search Image Finished");
		}
		return queryRepository.findAllUrls(pageable,id,searchText,isImage);
	}
	}

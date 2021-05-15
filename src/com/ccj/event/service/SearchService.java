package com.ccj.event.service;

import com.ccj.event.controller.Search;
import com.ccj.event.entity.Article;

import java.util.List;

public interface SearchService {
    public List<Article> getSearchResult(String tips);
}

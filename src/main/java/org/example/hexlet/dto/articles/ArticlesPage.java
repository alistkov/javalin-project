package org.example.hexlet.dto.articles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.model.Article;

import java.util.List;

@AllArgsConstructor
@Getter
public class ArticlesPage {
    private List<Article> articles;
}


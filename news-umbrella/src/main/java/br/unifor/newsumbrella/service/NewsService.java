package br.unifor.newsumbrella.service;

import br.unifor.newsumbrella.model.News;
import br.unifor.newsumbrella.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News save(News item) {
        return newsRepository.save(item);
    }

    public List<News> getAll() {
        return newsRepository.findAll();
    }

    public News getOne(int id) {
        return newsRepository.findOne(id);
    }

    public News update(int id, News item){
        News news = newsRepository.findOne(id);
        news.setText(item.getText());
        news.setTitle(item.getTitle());
        return newsRepository.save(news);
    }

    public void delete(int id) {
        News news = newsRepository.findOne(id);
        newsRepository.delete(news);
    }

    public List<News> searchByTitle(String title){
        return newsRepository.findByTitle(title);
    }
}
package br.unifor.newsumbrella.controller.admin;

import br.unifor.newsumbrella.model.News;
import br.unifor.newsumbrella.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/news")
public class NewsController {

    private NewsService newsService;
    static int id = 1;
    static List<News> newsDatabase = new ArrayList<>();


    public NewsController(NewsService newsService){
        this.newsService = newsService;
    }
    @GetMapping
    public ResponseEntity<List<News>> getAll(){

        List<News> newsList = newsService.getAll();
        return new ResponseEntity<>(newsList, HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<News> getOne(@PathVariable("id") int id){

        try {
            News news = newsService.getOne(id);
            System.out.println(news.getTitle());
            return new ResponseEntity<>(news, HttpStatus.OK);
        } catch (Exception ex){
            return ResponseEntity.notFound().build();
        }
    }
    // POST /news
    @PostMapping
    public ResponseEntity<News> add(@RequestBody News noticia) throws URISyntaxException {
        News noticiaSalva = newsService.save(noticia);
        System.out.println(noticia);
        System.out.println("salvou " + noticiaSalva);
        return new ResponseEntity<>(noticiaSalva, HttpStatus.CREATED);
    }

    // PUT /news/{news-id}
    @PutMapping("/{id}")
    public ResponseEntity<News> update(@PathVariable("id") int id, @RequestBody News noticia){
        News noticiaAtualizada = newsService.update(id, noticia);
        return new ResponseEntity<>(noticiaAtualizada, HttpStatus.OK);

    }
    // DELETE /news/{news-id}
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        newsService.delete(id);
        return new ResponseEntity("Success", HttpStatus.OK);
    }
}

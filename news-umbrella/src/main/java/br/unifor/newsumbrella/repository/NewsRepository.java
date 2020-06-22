package br.unifor.newsumbrella.repository;

import br.unifor.newsumbrella.model.Image;
import br.unifor.newsumbrella.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    @Query(value = "SELECT * FROM news", nativeQuery = true)
    List<News> findAll();

    @Query(value = "SELECT * FROM news WHERE id = ?1", nativeQuery = true)
    News findOne(int id);

    @Query(value = "SELECT n FROM News n WHERE n.title LIKE %:title%")
    List<News> findByTitle(String title);

    @Query(value = "select * from image where news_id = ?1", nativeQuery = true)
    List<Image> listNewImages(int input_id);
}

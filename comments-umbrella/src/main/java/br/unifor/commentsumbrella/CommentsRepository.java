package br.unifor.commentsumbrella;

import java.util.List;
import java.util.Map;

public interface CommentsRepository {

    void save(Comment comment);
    Map<Integer, List<Comment>> findAll();
    List<Comment> findById(int id);
    void update(Comment comment);
    void delete(String id);
}

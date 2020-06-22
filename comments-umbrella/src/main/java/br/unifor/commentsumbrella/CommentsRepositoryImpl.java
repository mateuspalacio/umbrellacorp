package br.unifor.commentsumbrella;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CommentsRepositoryImpl implements CommentsRepository {

    HashOperations<String, Integer, List<Comment>> hashOperations;

    public CommentsRepositoryImpl(RedisTemplate<String, Comment> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Comment comment) {
        List<Comment> currentComments = hashOperations.get("COMMENT", comment.getId());

        if (currentComments == null) {
            List<Comment> commentList = new ArrayList<>();
            commentList.add(comment);
            hashOperations.put("COMMENT", comment.getId(), commentList);

        } else {
            currentComments.add(comment);
            hashOperations.put("COMMENT", comment.getId(), currentComments);
        }

        System.out.println(String.format("User with ID %s saved", comment.getId()));
    }

    @Override
    public Map<Integer, List<Comment>> findAll() {
        return hashOperations.entries("COMMENT");
    }

    @Override
    public List<Comment> findById(int id) {
        return hashOperations.get("COMMENT", id);
    }

    @Override
    public void update(Comment comment) {
        save(comment);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("COMMENT", id);
    }
}
package br.unifor.commentsumbrella;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentsRepository commentRepository;

    @PostMapping()
    public List<Comment> add(@RequestBody Map<String, String> body) {

        commentRepository.save(
                new Comment(
                        Integer.parseInt(body.get("id")),
                        body.get("text")
                ));

        return commentRepository.findById(Integer.parseInt(body.get("id")));
    }

    @GetMapping()
    public Map<Integer, List<Comment>> findAll() {
        System.out.println(commentRepository.findAll());
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Comment> getById(@PathVariable int id) {
        return commentRepository.findById(id);
    }


}
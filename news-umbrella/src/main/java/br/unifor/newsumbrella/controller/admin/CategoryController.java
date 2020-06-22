package br.unifor.newsumbrella.controller.admin;

import br.unifor.newsumbrella.model.Category;
import br.unifor.newsumbrella.model.News;
import br.unifor.newsumbrella.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/categories")
public class CategoryController {

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    private CategoryService categoryService;
    static int id = 1;
    static List<News> categoriesDabatase = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Category> add(@RequestBody Category body) {
        try {
            var category = categoryService.save(body);
            return ResponseEntity.status(201).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    // READ ALL - GET http://localhost:8081/category
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        try {
            var category = categoryService.getAll();
            return ResponseEntity.status(200).body(category);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    // READ ONE - GET http://localhost:8081/category/id
    @GetMapping("/{id}")
    public ResponseEntity<Category> getOne(@PathVariable("id") int id) {
        try {
            var category = categoryService.getOne(id);
            return ResponseEntity.status(200).body(category);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }

    // UPDATE - PUT http://localhost:8081/category/id
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") int id, @RequestBody Category body) {
        try {
            var category = categoryService.update(id, body);
            return ResponseEntity.status(200).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }

    // DELETE - DEL http://localhost:8081/category/id
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteOne(@PathVariable("id") int id) {
        try {
            categoryService.delete(id);
            return ResponseEntity.status(200).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }
}

package com.telusko.quizapp.controller;

import com.telusko.quizapp.Question;
import com.telusko.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getAllQuestionByCategory(@PathVariable String category){
        return questionService.getAllQuestionsCategory(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("update/{id}")
    public Question updateById(@RequestBody Question question, @PathVariable Integer id){
        return questionService.updateById(question, id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable Integer id){
        questionService.deleteById(id);
        return "Deleted Successfully";
    }
}

package com.telusko.quizapp.service;

import com.telusko.quizapp.Question;
import com.telusko.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getAllQuestionsCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Success";
    }

    public Question updateById(Question question, Integer id) {

        Question ques = questionDao.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));

        ques.setQuestionTitle(question.getQuestionTitle());
        ques.setOption1(question.getOption1());
        ques.setOption2(question.getOption2());
        ques.setOption3(question.getOption3());
        ques.setOption4(question.getOption4());
        ques.setRightAnswer(question.getRightAnswer());

        return questionDao.save(ques);
    }

    public void deleteById(Integer id){

        Question ques = questionDao.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));

        questionDao.delete(ques);
    }
}


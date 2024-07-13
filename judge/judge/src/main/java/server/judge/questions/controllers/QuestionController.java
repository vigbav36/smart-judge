package server.judge.questions.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.judge.questions.models.Question;
import server.judge.questions.services.QuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
        Question createdQuestion =  questionService.createQuestion(question);
        return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
    }
    @GetMapping(path="/{questionId}"  ,produces = "application/json")
    public ResponseEntity<Question> getQuestion(@PathVariable Long questionId) {
        Question question =  questionService.getQuestionWithId(questionId);
        if(question != null)
            return new ResponseEntity<>(question, HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        Question updatedQuestion = questionService.updateQuestion(question);
        return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
    }
}


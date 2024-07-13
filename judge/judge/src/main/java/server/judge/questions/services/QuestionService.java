package server.judge.questions.services;



import com.sun.xml.messaging.saaj.packaging.mime.util.QEncoderStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.judge.questions.dao.QuestionDAO;
import server.judge.questions.models.Question;

@Service
public class QuestionService {

    @Autowired
    private QuestionDAO questionDAO;

    public Question createQuestion(Question question){
        return questionDAO.insertQuestion(question);
    }

    public Question getQuestionWithId(Long questionId){
        return questionDAO.getQuestion(questionId);
    }

    public Question updateQuestion(Question question){
        Long questionId = question.getQuestionId();
        Question existingQuestion = questionDAO.getQuestion(questionId);
        if(question.getDescription() != null)
            existingQuestion.setDescription(question.getDescription());
        if(question.getTitle() != null)
            existingQuestion.setTitle(question.getTitle());
        if(question.getBoilerPlateCode() != null)
            existingQuestion.setBoilerPlateCode(question.getBoilerPlateCode());
        questionDAO.updateQuestion(existingQuestion);
        return existingQuestion;
    }
}

package server.judge.questions.dao;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import server.judge.questions.models.Question;

import static com.example.generated.tables.Question.QUESTION;

@Repository
@RequiredArgsConstructor
public class QuestionDAO {

    @Autowired
    private final DSLContext dslContext;

    public Question insertQuestion(Question question){
        Record questionRecord = dslContext.insertInto(QUESTION)
                .columns(QUESTION.DESCRIPTION, QUESTION.TITLE)
                .values(question.getDescription(), question.getTitle())
                .returning(QUESTION.QUESTION_ID)
                .fetchOne();

        Long questionId = questionRecord.getValue(QUESTION.QUESTION_ID, Long.class);
        if(questionId == null)
            return null;
        return getQuestion(questionId);
    }

    public Question getQuestion(Long questionId){
        return dslContext.select(QUESTION.QUESTION_ID, QUESTION.DESCRIPTION, QUESTION.TITLE)
                .from(QUESTION)
                .fetchOneInto(Question.class);
    }

    public void updateQuestion(Question question){
        dslContext.update(QUESTION)
                .set(QUESTION.DESCRIPTION, question.getDescription())
                .set(QUESTION.TITLE, question.getTitle())
                .set(QUESTION.BOILER_PLATE_CODE, question.getBoilerPlateCode())
                .where(QUESTION.QUESTION_ID.eq(question.getQuestionId()))
                .execute();
    }
}


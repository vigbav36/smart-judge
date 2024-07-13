package server.judge.questions.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Long questionId;
    private String title;
    private String description;
    private String boilerPlateCode;
}

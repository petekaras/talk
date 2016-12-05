package talk.answers

import spock.lang.Specification

/**
 * Created by peter on 12/5/16.
 */
class AnswersTest extends Specification {
    def "get an answer"(int score,String answer) {
        expect:
        Answers answers = new Answers();
        answers.getResponse(score) == answer;

        where:
        score | answer
        -1    | "boo hoo"
        0     | "OK"
        1     | "great"
    }
}

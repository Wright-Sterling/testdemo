package com.swvllc.QuizTest;

import com.swvllc.Quiz.Question;
import com.swvllc.Quiz.Quiz;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class QuizTest {

    @Test
    public void readJsonFileShouldReturnTrue() {
        Quiz testQuiz = new Quiz();
        assertEquals(true,testQuiz.readJsonFile("quiz.json"));
    }

    @Test
    //This also tests Question.java and the population of the object in Quiz.java
    //Probably  not the best way to do it but, hey, I'm learning!
    public void getRandomQuestionShouldReturnValidQuestion() {
        Quiz testQuiz = new Quiz();
        testQuiz.readJsonFile("quiz.json");
        Question testQuestion = testQuiz.getRandomQuestion();
        String testString;
        ArrayList testArrayList;

        testString = testQuestion.getCategory();
        assertTrue(testQuestion.getCategory() == "music" ||
                testString == "movies" ||
                testString == "sports" ||
                testString == "books");
        assertTrue(testQuestion.getQuestion().length() > 10);
        assertTrue(testQuestion.getAnswer().length() > 1);
        testArrayList = testQuestion.getOptions();
        assertTrue(testArrayList.size()==4);
        for (int i=0; i<4; i++) {
            assertTrue(testArrayList.get(i).toString().length() > 1);
        }
    }
}
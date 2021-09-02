package com.test.interviewer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private final String exitCommand = "5 \n";

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }


    @Test
    public void addNewInterviewer() {
        final String interviewerName = "Interviewer Name";
        final String interviewerLastName = "Interviewer Lastname";
        final String interviewerEmail = "Interviewer Email";
        final String addNewInterviewerCommand = "1 \n " + interviewerName + " \n " + interviewerLastName + " \n " + interviewerEmail + " \n 1 \n" + exitCommand;
        provideInput(addNewInterviewerCommand);

        Menu.main(new String[0]);
        final String output = getOutput();

        assertTrue(output.contains(interviewerName));
        assertTrue(output.contains(interviewerLastName));
        assertTrue(output.contains(interviewerEmail));
    }

    @Test
    public void getInterviewer() {
        final String interviewerName = "Interviewer Name";
        final String interviewerLastName = "Interviewer Lastname";
        final String interviewerEmail = "interviewer@mail.com";
        final String addNewInterviewerCommand = "1 \n " + interviewerName + " \n " + interviewerLastName + " \n " + interviewerEmail + " \n 1 \n";
        final String getInterviewerCommand = "2 \n " + interviewerEmail + "\n ";
        provideInput(addNewInterviewerCommand + getInterviewerCommand + exitCommand);

        Menu.main(new String[0]);
        final String output = getOutput();

        assertTrue(output.contains(interviewerName));
        assertTrue(output.contains(interviewerLastName));
        assertTrue(output.contains(interviewerEmail));
    }


}

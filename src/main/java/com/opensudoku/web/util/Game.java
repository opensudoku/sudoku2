/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensudoku.web.util;

import com.opensudoku.util.Solver;
import com.opensudoku.util.Sudoku;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.inject.Named;

/**
 *
 * @author mark
 */
//@Stateful
// FINDING: 3/4/2014, by Mark, Stateful is not working for this case. Must be Singleton!!!
// HOW ABOUT FOR 2 AND MORE USERS???
@Singleton
@Named
public class Game {

    private final Solver solver;
    SudokuHtml sh;
    
     private String firstname;
     
    public String getFirstname() {
        return firstname;
    }
 
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Game() throws CloneNotSupportedException {
        this.solver = new Solver();
//        solver.runCommand("sample1");
        sh = new SudokuHtml();
//        solver.runCommand("sample1");

    }

    public void init() throws CloneNotSupportedException {
     //   solver.runCommand("sample1");
        System.out.print(" ... init ");
    }

    public void demo() throws CloneNotSupportedException {
        solver.runCommand("sample1");
        System.out.print(" ... demo ");
    }

    public String getStatus() {
        return solver.getCore().getStatus();
    }

    public void autorun() throws CloneNotSupportedException {
        System.out.print(" ******************* autorun ");
        solver.runCommand("autorun");
        System.out.print(solver.getCore().getAnswer().toString());
    }

    public String getQuestionRow(int k) {
        sh.setData(solver.getCore().getQuestion().toString());

        return sh.getRowString(k);
    }

    public String getAnswerRow(int k) {
        sh.setData(solver.getCore().getAnswer().toString());

        return sh.getRowString(k);
    }

    public String getAnswer() {
        return solver.getCore().getAnswer().toString();

    }

    public String getQuestion() {
//        SudokuHtml html = new SudokuHtml();
//        html.setData(solver.getCore().getQuestion().toString());
//        return html.toString();
//        sh.setData(solver.getCore().getQuestion().toString());
//
//        return sh.toString();
        return solver.getCore().getQuestion().toString();

    }
}

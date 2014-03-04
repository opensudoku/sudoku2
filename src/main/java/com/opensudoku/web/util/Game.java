/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensudoku.web.util;

import com.opensudoku.util.Solver;
import com.opensudoku.util.Sudoku;
import javax.ejb.Stateful;
import javax.inject.Named;

/**
 *
 * @author mark
 */
@Stateful
@Named
public class Game {

    private Solver solver;
    SudokuHtml sh;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Game() throws CloneNotSupportedException {
        this.solver = new Solver();
//        solver.runCommand("sample1");
        sh = new SudokuHtml();
        solver.runCommand("sample1");

    }

    public void demo() throws CloneNotSupportedException {
//        solver.runCommand("sample1");
        System.out.print(" ... demo ");
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

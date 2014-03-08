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

    public Game() {
    }
    
    private final Solver solver=new Solver();
    SudokuHtml sh=new SudokuHtml();

    private String firstname;
    //private String[] row = new String[9];
    private String rowA;
    private String rowB;
    private String rowC;
    private String rowD;
    private String rowE;
    private String rowF;
    private String rowG;
    private String rowH;
    private String rowI;

//    public Game() {
//        this.solver = new Solver();
//    }

    public String getRowA() {
        return rowA;
    }

    public void setRowA(String rowA) {
        this.rowA = rowA;
    }

    public String getRowB() {
        return rowB;
    }

    public void setRowB(String rowB) {
        this.rowB = rowB;
    }

    public String getRowC() {
        return rowC;
    }

    public void setRowC(String rowC) {
        this.rowC = rowC;
    }

    public String getRowD() {
        return rowD;
    }

    public void setRowD(String rowD) {
        this.rowD = rowD;
    }

    public String getRowE() {
        return rowE;
    }

    public void setRowE(String rowE) {
        this.rowE = rowE;
    }

    public String getRowF() {
        return rowF;
    }

    public void setRowF(String rowF) {
        this.rowF = rowF;
    }

    public String getRowG() {
        return rowG;
    }

    public void setRowG(String rowG) {
        this.rowG = rowG;
    }

    public String getRowH() {
        return rowH;
    }

    public void setRowH(String rowH) {
        this.rowH = rowH;
    }

    public String getRowI() {
        return rowI;
    }

    public void setRowI(String rowI) {
        this.rowI = rowI;
    }
    
    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
//    public Game() throws CloneNotSupportedException {
////        this.solver = new Solver();
////        solver.runCommand("sample1");
////        sh = new SudokuHtml();
////        solver.runCommand("sample1");
//
//    }

    public void init()  {
        //   solver.runCommand("sample1");
        
        System.out.print(" ... init ");
    }

    public void demo()  {
        solver.runCommand("sample1...");
        System.out.print(" ... demo ");
    }

    public String getStatus() {
        return solver.getCore().getStatus();
    }

    public void autorun() {
          System.out.print(" ******************* rowA " + getRowA());
        System.out.print(" ******************* rowB " + getRowB());
        System.out.print(" ******************* rowC " + getRowC());
        System.out.print(" ******************* rowD " + getRowD());
        System.out.print(" ******************* rowE " + getRowE());
        System.out.print(" ******************* rowF " + getRowF());
        System.out.print(" ******************* rowG " + getRowG());
        System.out.print(" ******************* rowH " + getRowH());
        System.out.print(" ******************* rowI " + getRowI());

//        solver.getCore().getQuestion().setData(firstname);
        String str = rowA + rowB + rowC + rowD + rowE + rowF + rowG + rowH + rowI;
//            solver.runCommand("sample1");
        
        solver.getCore().getQuestion().setData(str);

//        Sudoku saveQuestion=new Sudoku();
//        saveQuestion.setData(firstname);
        System.out.print(" ******************* autorun ");
        solver.runCommand("autorun");

      
        solver.getCore().getQuestion().setData(str);

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

    class SudokuHtml extends Sudoku {

        public String getRowString(int k) {
            StringBuilder sb = new StringBuilder();

            int id = 0;
            for (int n = 1; n <= 9; n++) {
                id = 9 * (k - 1) + n;
                if (getData(id) == 0) { // empty
                    sb.append(' ').append('.');

                } else {
                    sb.append(' ').append(getData(id));
                }
            }
            return sb.toString();
        }

//    public String toString() {
////        String str="DOING SudokuHtml toString..."+super.toString();
//        String str = "DOING SudokuHtml toString...\n";
//        int id = 0;
//        int[] member = this.getData();
//        for (int m = 1; m <= 9; m++) {
//            for (int n = 1; n <= 9; n++) {
//                id = 9 * (m - 1) + n;
//                str += member[id];
//            }
//            str += "<br>";
//        }
//
//        return str;
//    }
    }

}

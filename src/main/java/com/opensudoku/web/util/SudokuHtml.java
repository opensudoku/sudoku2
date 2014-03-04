/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opensudoku.web.util;

import com.opensudoku.util.Sudoku;

/**
 *
 * @author mark
 */
public class SudokuHtml extends Sudoku {

    public String getRowString(int k) {
        StringBuilder sb = new StringBuilder();

        int id = 0;
        for (int n = 1; n <= 9; n++) {
            id = 9 * (k - 1) + n;
            if (getData(id)==0){ // empty
            sb.append(' ').append('.');
                
            }else{
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

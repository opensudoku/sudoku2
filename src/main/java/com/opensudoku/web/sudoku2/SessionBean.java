/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensudoku.web.sudoku2;

import com.opensudoku.util.Solver;
import javax.ejb.Stateful;
import javax.inject.Named;

/**
 *
 * @author mark
 */
@Stateful
@Named
public class SessionBean {
    private Solver solver;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public SessionBean() throws CloneNotSupportedException {
        this.solver = new Solver();
        solver.runCommand("sample1");
        
    }
    public String getQuestion(){
        return solver.getCore().getQuestion().toString();
    }
}

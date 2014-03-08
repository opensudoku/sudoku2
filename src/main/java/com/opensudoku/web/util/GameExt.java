/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opensudoku.web.util;

import javax.ejb.Stateless;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

/**
 *
 * @author mark
 */

@Named
@Stateless
public class GameExt {
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

 
    
}

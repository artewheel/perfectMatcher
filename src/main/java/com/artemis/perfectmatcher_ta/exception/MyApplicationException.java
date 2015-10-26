/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artemis.perfectmatcher_ta.exception;

/**
 *
 * @author artemis
 */import java.io.Serializable;
 
public class MyApplicationException extends Exception implements Serializable
{
    private static final long serialVersionUID = 1L;
    public MyApplicationException() {
        super();
    }
    public MyApplicationException(String msg)   {
        super(msg);
    }
    public MyApplicationException(String msg, Exception e)  {
        super(msg, e);
    }
}
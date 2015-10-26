/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artemis.perfectmatcher_ta.rest;

//import com.artemis.perfectmatcher_ta.exception.MyApplicationException;
import com.artemis.perfectmatcher_ta.model.Boy;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
//import javax.ws.rs.Consumes;
import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;
import utils.Helper;

//http://localhost:8084/perfectmatcher_TA/rest/
@Path("/app")

public class PerfectMatchRestService {

    Boy boy=new Boy();
    Helper help = new Helper();
    
        
    @BadgerFish	
    @GET
    @Path("/{param:[A-Z]{1}+[a-z]*}") 
    @Produces("application/json")
    public Boy PerfectMatcher(@PathParam("param") String name)
    {
            boy.setName(name); 
            Numberizer(boy.getName());
            Nummatcher(boy.getCode());
            return boy; 
    }
    	
    
    @GET
    @Path("/name/{myname:[A-Z]{1}+[a-z]*}")
    public int Numberizer(@PathParam("myname") String name) {
            boy.setCode(help.stringToAscii(name));      
            return boy.getCode();
        }

    @GET
    @Path("code/{mycode:[0-9]*}")
    public String Nummatcher(@PathParam("mycode") int code)
    {
        boy.setMate(help.selectGirl(code));
        return boy.getMate();
    }
    
}

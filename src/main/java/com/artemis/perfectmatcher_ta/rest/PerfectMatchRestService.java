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

//http://localhost:8084/perfectmatcher_TA/rest/
@Path("/app")

public class PerfectMatchRestService {

    Boy boy=new Boy();

    public int stringToAscii(String name) {
        if (name == null) {
            return 0;
        }
        int len = name.length();
        int count = 0;
        Character[] array = new Character[len];
        for (int i = 0; i < len; i++) {
            array[i] = new Character(name.charAt(i));
            count += name.charAt(i);
          //  count += word;
        }
        return count;
    }

    public String selectGirl(int code) {
        String girl;
      
        if (code < 800) {
            girl = "Maria.";
        } else if ((code > 799) & (code < 1200)) {
            girl = "Elena.";
        } else if ((code > 1199) & (code < 1600)) {
            girl = "Marina.";
        } else  {
            girl = "Nancy.";
        }
        
        return girl;

    }

   
    
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
            boy.setCode(stringToAscii(name));      
            return boy.getCode();
        }

    @GET
    @Path("code/{mycode:[0-9]*}")
    public String Nummatcher(@PathParam("mycode") int code)
    {
        boy.setMate(selectGirl(code));
        return boy.getMate();
    }
    
}

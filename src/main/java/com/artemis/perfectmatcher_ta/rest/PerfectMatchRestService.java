/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artemis.perfectmatcher_ta.rest;

import com.artemis.perfectmatcher_ta.exception.MyApplicationException;
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
      
        if ((code > 0) & (code < 800)) {
            girl = "Maria!";
        } else if ((code > 799) & (code < 1200)) {
            girl = "Elena!";
        } else if ((code > 1199) & (code < 1600)) {
            girl = "Marina!";
        } else  {
            girl = "Nancy!";
        }
        
        return girl;

    }

   
    
    @BadgerFish	
    @GET
    @Path("/{param:[A-Z]{1}+[a-z]*}") 
    @Produces("application/json")
    public Response PerfectMatcher(@PathParam("param") String name) throws MyApplicationException
    {
            boy.setName(name); 
            Numberizer(boy.getName());
            return Response.status(200).entity(boy).build(); 
    }
    
    @BadgerFish	
    @GET
    @Path("/name/{myname:[A-Z]{1}+[a-z]*}")
    @Produces("application/json")
    public Response Numberizer(@PathParam("myname") String name) {
        if (boy.getName()==null){
            boy.setName(name);
        }
            boy.setCode(stringToAscii(name));  
            Nummatcher(boy.getCode());
           return Response.status(200).entity(boy).build();     
        }

    @BadgerFish	
    @GET
    @Path("code/{mycode:[0-9]*}")
   // @Consumes("application/json")
    @Produces("application/json")
    public Response Nummatcher(@PathParam("mycode") int code) //throws MyApplicationException
    {
        if (boy.getCode()==0){
            boy.setCode(code);
        }
        boy.setMate(selectGirl(code));
        return Response.status(200).entity(boy).build(); 
    }
    
}

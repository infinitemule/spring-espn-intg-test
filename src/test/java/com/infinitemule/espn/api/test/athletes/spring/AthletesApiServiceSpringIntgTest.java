/*
 * Spring ESPN
 */
package com.infinitemule.espn.api.test.athletes.spring;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.infinitemule.espn.api.athletes.Athlete;
import com.infinitemule.espn.api.athletes.AthletesApiRequest;
import com.infinitemule.espn.api.athletes.AthletesApiResponse;
import com.infinitemule.espn.api.athletes.spring.AthletesApiServiceSpring;
import com.infinitemule.espn.api.sports.League;
import com.infinitemule.espn.api.sports.Sport;
import com.infinitemule.espn.api.test.AbstractApiServiceSpringIntgTest;
import com.infinitemule.espn.common.api.Leagues;
import com.infinitemule.espn.common.api.Sports;

public class AthletesApiServiceSpringIntgTest extends AbstractApiServiceSpringIntgTest {

  @Autowired
  private AthletesApiServiceSpring srv;
  
  @After
  public void tearDown() {
    try { Thread.sleep(3000); } catch(Exception e) {};
  }
  
  @Test
  public void sport() {
    
    AthletesApiRequest request = new AthletesApiRequest() 
      .sport(Sports.Golf);
    
    output(srv.call(request));
    
  }
  
  @Test
  public void sportAndLeague() {
    
    AthletesApiRequest request = new AthletesApiRequest() 
      .sport(Sports.Racing)
      .league(Leagues.NASCAR);
      
    output(srv.call(request));    
  }
  
  
  @Test
  public void athlete() {
    
    AthletesApiRequest request = new AthletesApiRequest()        
       .sport(Sports.Racing)
       .league(Leagues.NASCAR)
       .id(70);
              
    output(srv.call(request));    
  }

  private void output(AthletesApiResponse resp) {
    
    for(Sport sport : resp.getSports()) {
      for(League league : sport.getLeagues()) {
        for(Athlete athlete : league.getAthletes()) {
          System.out.printf("  -- %s %s\n", athlete.getFirstName(), athlete.getLastName());
        }
      }
    }
    
  }    
}

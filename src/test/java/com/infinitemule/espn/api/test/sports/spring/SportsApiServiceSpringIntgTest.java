/*
 * Spring ESPN
 */
package com.infinitemule.espn.api.test.sports.spring;

import static com.infinitemule.espn.common.lang.Console.printfn;
import static com.infinitemule.espn.common.lang.Console.println;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.infinitemule.espn.api.sports.League;
import com.infinitemule.espn.api.sports.Sport;
import com.infinitemule.espn.api.sports.SportsApiRequest;
import com.infinitemule.espn.api.sports.SportsApiResponse;
import com.infinitemule.espn.api.sports.SportsApiService;
import com.infinitemule.espn.api.test.AbstractApiServiceSpringIntgTest;
import com.infinitemule.espn.common.api.Leagues;
import com.infinitemule.espn.common.api.Sports;

/**
 * 
 */
public class SportsApiServiceSpringIntgTest extends AbstractApiServiceSpringIntgTest {
  
  @Autowired
  private SportsApiService srv = null;
  
  @Test
  public void all() {
    
    SportsApiRequest req = new SportsApiRequest()
         .allSports();
    
    output(srv.call(req));
  }
  

  @Test
  public void bySport() {
    
    SportsApiRequest req = new SportsApiRequest()
        .sport(Sports.Baseball);

    output(srv.call(req));
  }

  
  @Test
  public void bySportAndLeague() {
    
    SportsApiRequest req = new SportsApiRequest()
        .sport(Sports.Baseball).league(Leagues.MLB);
    
    output(srv.call(req));
  }
  
  
  private void output(SportsApiResponse resp) {
    
    for(Sport sport : resp.getSports()) {
      printfn("%s - %s", sport.getId(), sport.getName());
      
      printfn("  Leagues");      
      for(League league : sport.getLeagues()) {
        printfn("    %s - %s", league.getId(), league.getName());  
      }
            
      
      printfn("  API Links");
      printfn("  - Sports:   \t%s", sport.getLinks().getApi().getSportsUrl());
      printfn("  - News:     \t%s", sport.getLinks().getApi().getNewsUrl());
      printfn("  - Notes:    \t%s", sport.getLinks().getApi().getNotesUrl());
      printfn("  - Headlines:\t%s", sport.getLinks().getApi().getHeadlinesUrl());
      printfn("  - Events:   \t%s", sport.getLinks().getApi().getEventsUrl());      
      
      println();
    }
    
    if(resp.getLinks() != null) {
      printfn("---");
      printfn("Links:");    
      printfn("  API");     
      printfn("    News:     \t%s", resp.getLinks().getApi().getNewsUrl());
      printfn("    Headlines:\t%s", resp.getLinks().getApi().getHeadlinesUrl());
      printfn("    Notes:    \t%s", resp.getLinks().getApi().getNotesUrl());
      printfn("    Events:   \t%s", resp.getLinks().getApi().getEventsUrl());
      
      printfn("---");
      printfn("Success:  \t%s", resp.getStatus());
      printfn("Timestamp:\t%s", resp.getTimestamp());
    }
    
  }

}

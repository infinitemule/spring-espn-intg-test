/*
 * Spring ESPN
 */
package com.infinitemule.espn.api.test.teams.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.infinitemule.espn.api.sports.League;
import com.infinitemule.espn.api.sports.Sport;
import com.infinitemule.espn.api.teams.Team;
import com.infinitemule.espn.api.teams.TeamOption;
import com.infinitemule.espn.api.teams.TeamsApiRequest;
import com.infinitemule.espn.api.teams.TeamsApiResponse;
import com.infinitemule.espn.api.teams.TeamsApiService;
import com.infinitemule.espn.api.test.AbstractApiServiceSpringIntgTest;
import com.infinitemule.espn.common.api.Leagues;
import com.infinitemule.espn.common.api.Sports;

/**
 * 
 */
public class TeamsApiServiceSpringIntgTest extends AbstractApiServiceSpringIntgTest {

  
  @Autowired
  private TeamsApiService srv = null;
  
  @Test
  public void teamsBySportAndLeagueNfl() {
        
    TeamsApiRequest request = new TeamsApiRequest()
      .sport(Sports.Football)
      .league(Leagues.NFL);    
    
    output(srv.call(request));
                  
  }

  
  @Test
  public void teamsBySportAndLeagueMlb() {
        
    TeamsApiRequest request = new TeamsApiRequest()
      .sport(Sports.Baseball)
      .league(Leagues.MLB);    
    
    output(srv.call(request));
                  
  }
  
  
  @Test
  public void teamsBySportAndLeagueNhl() {
        
    TeamsApiRequest request = new TeamsApiRequest()
      .sport(Sports.Hockey)
      .league(Leagues.NHL);    
    
    output(srv.call(request));
                  
  }
  
  
  @Test
  public void teamsBySportAndLeagueAndGroupNfl() {
        
    TeamsApiRequest request = new TeamsApiRequest()
      .sport(Sports.Football)
      .league(Leagues.NFL)
      .group(1);
    
    output(srv.call(request));
                  
  }
  
  
  @Test
  public void teamsBySportAndLeagueAndGroupMlb() {
        
    TeamsApiRequest request = new TeamsApiRequest()
      .sport(Sports.Baseball)
      .league(Leagues.MLB)
      .group(1);
    
    output(srv.call(request));
                  
  }

  
  @Test
  public void teamsWithOptionsVenues() {
    
    TeamsApiRequest request = new TeamsApiRequest()
      .sport(Sports.Football)
      .league(Leagues.NFL)
      .options(TeamOption.Venues);    
  
    output(srv.call(request));
                                               
  }

  
  private void output(TeamsApiResponse resp) {

    for(Sport sport : resp.getSports()) {
      for(League league : sport.getLeagues()) {
        for(Team team : league.getTeams()) {
          System.out.printf("  -- %s\t%s\t%s %s\n", 
              team.getUid(), team.getId(), team.getLocation(), team.getName());          
        }
      }
    }

  }
}

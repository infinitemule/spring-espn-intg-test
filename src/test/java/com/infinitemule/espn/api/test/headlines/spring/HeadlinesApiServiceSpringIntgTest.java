/*
 * Spring ESPN
 */
package com.infinitemule.espn.api.test.headlines.spring;

import static com.infinitemule.espn.common.lang.Console.printfn;
import static com.infinitemule.espn.common.lang.Console.println;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.infinitemule.espn.api.headlines.Headline;
import com.infinitemule.espn.api.headlines.HeadlinesApiRequest;
import com.infinitemule.espn.api.headlines.HeadlinesApiResponse;
import com.infinitemule.espn.api.headlines.spring.HeadlinesApiServiceSpring;
import com.infinitemule.espn.api.test.AbstractApiServiceSpringIntgTest;
import com.infinitemule.espn.common.api.City;
import com.infinitemule.espn.common.api.FantasySport;

public class HeadlinesApiServiceSpringIntgTest extends AbstractApiServiceSpringIntgTest {

  @Autowired
  private HeadlinesApiServiceSpring srv;

    
  @Test
  public void newsAllCities() {
    
    HeadlinesApiRequest req = new HeadlinesApiRequest()
        .news().forCities();
        
    output(srv.call(req));    
  }
  
  
  @Test
  public void headlinesAllCities() {
    
    HeadlinesApiRequest req = new HeadlinesApiRequest()
        .headlines().forCities();
        
    output(srv.call(req));    
  }
  
  
  @Test
  public void newsByCity() {
    
    HeadlinesApiRequest req = new HeadlinesApiRequest()
        .news()
        .forCity(City.Boston);
        
    output(srv.call(req));    
  }

  
  @Test
  public void headlinesByCity() {
    
    HeadlinesApiRequest req = new HeadlinesApiRequest()
        .headlines()
        .forCity(City.Boston);
        
    output(srv.call(req));    
  }
  
  
  @Test
  public void newsByDate() {
    
    HeadlinesApiResponse response = srv.call(
        new HeadlinesApiRequest()
          .news()
          .forCities()
          .date("2012-07-24"));
    
    output(response);    
  }
  
  /*
   * 
   */
  
  @Test
  public void newsForEspnW() {
    
    HeadlinesApiRequest req = new HeadlinesApiRequest()
        .headlines()
        .forEspnW();
    
    output(srv.call(req));    
  }


  @Test
  public void newsForAllFantasy() {
    
    HeadlinesApiRequest req = new HeadlinesApiRequest()
        .headlines()
        .forFantasySports();

    output(srv.call(req)); 
  }
  
  
  @Test
  public void newsForFantasySport() {
    
    HeadlinesApiRequest req = new HeadlinesApiRequest()
      .headlines()
      .forFantasySport(FantasySport.Baseball);

    output(srv.call(req)); 
  }
  
  
  @Test
  public void newsForMagazine() {
    
    HeadlinesApiRequest req = new HeadlinesApiRequest()
        .headlines()
        .forEspnMagazine();

    output(srv.call(req)); 
  }
  
  
  private void output(HeadlinesApiResponse response) {
    
    for(Headline headline : response.getHeadlines()) {
      println("----------------------------------------");
      printfn("%s (%s)", headline.getHeadline(), headline.getId());

      println("  - Description:");
      printfn("      %s - %s", headline.getPublished(), headline.getType());
      printfn("      %s", headline.getTitle());
      printfn("      %s", headline.getDescription());

    }
  }
}

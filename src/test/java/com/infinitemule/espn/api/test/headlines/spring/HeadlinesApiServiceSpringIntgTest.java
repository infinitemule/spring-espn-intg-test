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

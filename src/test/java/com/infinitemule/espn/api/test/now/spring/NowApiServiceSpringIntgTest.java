package com.infinitemule.espn.api.test.now.spring;

import static com.infinitemule.espn.common.lang.Console.printfn;
import static com.infinitemule.espn.common.lang.Console.println;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.infinitemule.espn.api.now.Feed;
import com.infinitemule.espn.api.now.NowApiRequest;
import com.infinitemule.espn.api.now.NowApiResponse;
import com.infinitemule.espn.api.now.NowApiService;
import com.infinitemule.espn.api.now.NowLeague;
import com.infinitemule.espn.api.test.AbstractApiServiceSpringIntgTest;
import com.infinitemule.espn.common.api.Image;
import com.infinitemule.espn.common.api.Language;
import com.infinitemule.espn.common.api.NewsCategory;
import com.infinitemule.espn.common.api.Teams;
import com.infinitemule.espn.common.api.Video;

public class NowApiServiceSpringIntgTest extends AbstractApiServiceSpringIntgTest {

  @Autowired
  private NowApiService srv = null;
  
  @Test
  public void latest() {
    
    NowApiRequest request = new NowApiRequest()
      .latest();

      output(srv.call(request));
    
  }

  @Test
  public void top() {
    
    NowApiRequest request = new NowApiRequest()
      .top();

    output(srv.call(request));
    
  }
  

  @Test
  public void popular() {
    
    NowApiRequest request = new NowApiRequest()
      .popular();

    output(srv.call(request));
    
  }

  @Test
  public void limit() {
    
    NowApiRequest request = new NowApiRequest()
      .top()
      .limit(5);
        
    output(srv.call(request));
    
  }

  @Test
  public void nowLeague() {
    
    NowApiRequest request = new NowApiRequest()
      .latest()
      .league(NowLeague.NFL);
        
    output(srv.call(request));
  }
  

  @Test
  public void nowLeagueTeam() {
    
    NowApiRequest request = new NowApiRequest()
      .latest()
      .league(NowLeague.MLB)
      .teams(Teams.MLB.BOS);
        
    output(srv.call(request));
  }
  
  
  @Test
  public void nowLanguage() {
    
    NowApiRequest request = new NowApiRequest()
      .latest()      
      .language(Language.Spanish);
        
    output(srv.call(request));
  }
  

  
  private void output(NowApiResponse resp) {
    
    for(Feed breaking : resp.getBreakingNews()) {
      println("********** BREAKING NEWS **********");
      printfn("%s (%s)", breaking.getHeadline(), breaking.getId());
      println("  - Description:");
      printfn("      %s - %s - %s", breaking.getPublished(), breaking.getType(), breaking.getSection());
      printfn("      %s", breaking.getDescription());      
      println();
      println();
    }
    
    
    for(Feed feed : resp.getFeed()) {
      println("----------------------------------------");
      printfn("%s (%s)", feed.getHeadline(), feed.getId());
      
      println("  - Description:");
      printfn("      %s - %s - %s", feed.getPublished(), feed.getType(), feed.getSection());
      printfn("      %s", feed.getDescription());
      
      println("  - Links:");
      printfn("      Web:    %s", feed.getLinks().getWebUrl());
      printfn("      Mobile: %s", feed.getLinks().getMobileUrl());
      
      
      println("  - Categories:");
      
      for(NewsCategory cat : feed.getCategories()) {
        printfn("      %s (%s)", cat.getDescription(), cat.getType());
      }

      
      println("  - Images:");
      
      for(Image image : feed.getImages()) {
        printfn("      %s (%sx%s) - %s", image.getName(), image.getHeight(), image.getWidth(), image.getUrl());       
      }
         

      println("  - Videos:");
      
      for(Video video : feed.getVideo()) {
        printfn("      %s - %s", video.getTitle(), video.getLinks().getWeb().getHref());       
      }
      
      println();
    }
    
    printfn("Status:    %s", resp.getStatus());
    printfn("Timestamp: %s", resp.getTimestamp());
  }

}

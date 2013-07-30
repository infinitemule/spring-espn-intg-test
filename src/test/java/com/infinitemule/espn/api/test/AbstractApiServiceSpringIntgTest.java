/*
 * Spring ESPN
 */
package com.infinitemule.espn.api.test;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.infinitemule.espn.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public abstract class AbstractApiServiceSpringIntgTest {

  @After
  public void tearDown() {
    // Done to avoid rate limiting
    try { Thread.sleep(2000); } catch(Exception e) {};
  }
  
}

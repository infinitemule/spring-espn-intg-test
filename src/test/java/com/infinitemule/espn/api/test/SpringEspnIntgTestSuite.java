/*
 * Spring ESPN
 */
package com.infinitemule.espn.api.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.infinitemule.espn.api.test.athletes.spring.AthletesApiServiceSpringIntgTest;
import com.infinitemule.espn.api.test.headlines.spring.HeadlinesApiServiceSpringIntgTest;
import com.infinitemule.espn.api.test.now.spring.NowApiServiceSpringIntgTest;
import com.infinitemule.espn.api.test.sports.spring.SportsApiServiceSpringIntgTest;
import com.infinitemule.espn.api.test.teams.spring.TeamsApiServiceSpringIntgTest;


@RunWith(Suite.class)
@SuiteClasses({ 
  AthletesApiServiceSpringIntgTest.class,
  HeadlinesApiServiceSpringIntgTest.class,
  NowApiServiceSpringIntgTest.class,
  SportsApiServiceSpringIntgTest.class,
  TeamsApiServiceSpringIntgTest.class
})
public class SpringEspnIntgTestSuite {

}

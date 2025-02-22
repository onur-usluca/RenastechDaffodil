package code.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", //This is to connect feature files with Runner so that Cucumber can identify them
        //path from content root
        glue = "code/stepDefinitions", //this is to connect steps definitions with cucumber
        //path from source root
<<<<<<< HEAD
        tags = "@Regression", //Without tags it will run everything that is present under feature files. When you put tags it will only
=======
        tags = "@Maventest", //Without tags it will run everything that is present under feature files. When you put tags it will only
>>>>>>> 8fcc00fa86cb60460f2b568b9e155390d5dfdd9b
        //run tagged ones
        dryRun = false, //This will give you undefined steps directly without running existing steps in a scenario or feature file.
        plugin={
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
}

)
public class TestRunner {
}

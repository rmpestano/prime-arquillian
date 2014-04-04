package org.primefaces.test.bdd;

import com.google.common.util.concurrent.MoreExecutors;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jboss.arquillian.jbehave.core.ArquillianInstanceStepsFactory;

import static org.jbehave.core.reporters.Format.*;

/**
 * Created with IntelliJ IDEA.
 * User: rmpestano
 * Date: 10/31/13
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 *
 * Classe base dos testes BDD com arquillian
 */

public abstract class BaseBdd extends JUnitStory{
	private Object[] steps;
	

    public BaseBdd() {
        configuredEmbedder().useExecutorService(MoreExecutors.sameThreadExecutor());
    }

    @Override
    public Configuration configuration()
    {
        Configuration configuration = new MostUsefulConfiguration()
                .useStoryPathResolver(new UnderscoredCamelCaseResolver())
                .useParameterControls(new ParameterControls().useDelimiterNamedParameters(true))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(CONSOLE, TXT, HTML, XML)
                        .withFailureTrace(true));
        return configuration;
    }

    @Override
    public InjectableStepsFactory stepsFactory()
    {
        return new ArquillianInstanceStepsFactory(configuration(), getSteps());
    }


    private Object[] getSteps(){
    	if(getClass().isAnnotationPresent(Steps.class)){
    		if(steps == null){
    			steps = initializeSteps();
    		}
    		return steps;
    	}
    	else{
    		throw new RuntimeException("provide steps annotation to run jbehave tests");
    	}
    }

	private Object[] initializeSteps() {
		Class[] stepsCandidates = getClass().getAnnotation(Steps.class).value();
		steps = new Object[stepsCandidates.length];
		for (int i = 0;i< stepsCandidates.length;i++) {
			try {
				steps[i] = stepsCandidates[i].newInstance();
			} catch (InstantiationException  e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
		return steps;
	}



}

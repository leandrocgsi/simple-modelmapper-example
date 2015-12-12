package br.com.semeru.modelmapper.converter;

import br.com.semeru.modelmapper.converter.ModelMapperParser;
import br.com.semeru.modelmapper.mocks.MockInputObject;
import br.com.semeru.modelmapper.objects.OutputObject;

import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Before;
import org.junit.Test;

public class ModelMapperParserTest {

    MockInputObject inputObject;

    @Before
    public void setUp() {
		configureLogger();
        inputObject = new MockInputObject();
    }

	private void configureLogger() {
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.INFO);
		rootLogger.addAppender(new ConsoleAppender(new PatternLayout("%-6r [%p] %c - %m%n")));
	}

    @Test
    public void parseObjectInputToObjectOutputTest() {
        OutputObject output = ModelMapperParser.parseObjectInputToObjectOutput(inputObject.mockInput(), OutputObject.class);
        Assert.assertEquals("Name Test", output.getName());
        Assert.assertEquals("Old City", output.getAddress().getTown());
        Assert.assertTrue(output.getAge() == 21);
    }

    @Test
    public void parserListObjectInputToObjectOutputTest() {
        List<OutputObject> output = ModelMapperParser.parserListObjectInputToObjectOutput(inputObject.mockInputList(), OutputObject.class);
        Assert.assertEquals("Name Test 2", output.get(0).getName());
        Assert.assertEquals("Old City", output.get(0).getAddress().getTown());
        Assert.assertTrue(output.get(0).getAge() == 22);
    }
}
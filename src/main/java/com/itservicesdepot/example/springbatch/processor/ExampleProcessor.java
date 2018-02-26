package com.itservicesdepot.example.springbatch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.itservicesdepot.example.springbatch.model.SoccerPlayerEntry;

public class ExampleProcessor implements ItemProcessor<SoccerPlayerEntry, String> {
	private static Logger logger = LoggerFactory.getLogger(ExampleProcessor.class);
	
	public String process(SoccerPlayerEntry item) throws Exception {
		logger.info("Processing 'Number {}'", item);
		return item.toString();
	}

}

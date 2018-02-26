package com.itservicesdepot.example.springbatch.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itservicesdepot.example.springbatch.dao.SoccerPlayerDao;
import com.itservicesdepot.example.springbatch.entity.SoccerPlayerEntity;

public class ExampleWriter implements ItemWriter<String> {
	private static Logger logger = LoggerFactory.getLogger(ExampleWriter.class);
	
	@Autowired
	private SoccerPlayerDao soccerPlayerDao;
	
	private Long importTrackingId;
	
	@Transactional
	public void write(List<? extends String> items) throws Exception {
		for (String item : items) {
			SoccerPlayerEntity soccerPlayer = new SoccerPlayerEntity();
			soccerPlayer.setName(item);
			soccerPlayer.setImportTrackingId(importTrackingId);
			this.soccerPlayerDao.save(soccerPlayer);
		}
	}

	public void setImportTrackingId(Long importTrackingId) {
		this.importTrackingId = importTrackingId;
	}
	
	
}

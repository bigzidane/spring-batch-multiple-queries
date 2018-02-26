package com.itservicesdepot.example.springbatch.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itservicesdepot.example.springbatch.dao.SoccerPlayerDao;
import com.itservicesdepot.example.springbatch.entity.SoccerPlayerImportTrackingEntity;

public class ExampleJobListener implements JobExecutionListener {

	@Autowired
	private SoccerPlayerDao soccerPlayerDao;
	
	private Long importTrackingId;
	
	@Transactional
	public void afterJob(JobExecution arg0) {
		SoccerPlayerImportTrackingEntity soccerPlayerImportTrackingEntity = this.soccerPlayerDao.getSoccerImportTrackingEntityById(this.importTrackingId);
		soccerPlayerImportTrackingEntity.setEndDate(new Date());
		this.soccerPlayerDao.updateTracking(soccerPlayerImportTrackingEntity);
	}

	@Transactional
	public void beforeJob(JobExecution arg0) {
		SoccerPlayerImportTrackingEntity soccerPlayerImportTrackingEntity = new SoccerPlayerImportTrackingEntity();
		soccerPlayerImportTrackingEntity.setStartDate(new Date());
		this.importTrackingId = this.soccerPlayerDao.saveTracking(soccerPlayerImportTrackingEntity);
		
		arg0.getExecutionContext().put("importTrackingId", this.importTrackingId);
	}

}

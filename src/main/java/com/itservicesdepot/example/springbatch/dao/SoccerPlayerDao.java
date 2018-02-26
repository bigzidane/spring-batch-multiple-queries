package com.itservicesdepot.example.springbatch.dao;

import com.itservicesdepot.example.springbatch.entity.SoccerPlayerEntity;
import com.itservicesdepot.example.springbatch.entity.SoccerPlayerImportTrackingEntity;

public interface SoccerPlayerDao {
	long save(SoccerPlayerEntity soccerPlayer);
	long saveTracking(SoccerPlayerImportTrackingEntity soccerPlayerImportTrackingEntity);
	long updateTracking(SoccerPlayerImportTrackingEntity soccerPlayerImportTrackingEntity);
	public SoccerPlayerImportTrackingEntity getSoccerImportTrackingEntityById(long id);
}

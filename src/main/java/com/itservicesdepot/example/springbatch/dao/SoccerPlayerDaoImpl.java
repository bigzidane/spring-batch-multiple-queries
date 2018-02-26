package com.itservicesdepot.example.springbatch.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.itservicesdepot.example.springbatch.entity.SoccerPlayerEntity;
import com.itservicesdepot.example.springbatch.entity.SoccerPlayerImportTrackingEntity;

public class SoccerPlayerDaoImpl implements SoccerPlayerDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public long save(SoccerPlayerEntity soccerPlayer) {
		this.entityManager.persist(soccerPlayer);
		
		return soccerPlayer.getId();
	}

	public long updateTracking(SoccerPlayerImportTrackingEntity soccerPlayerImportTrackingEntity) {
		this.entityManager.merge(soccerPlayerImportTrackingEntity);
		
		return soccerPlayerImportTrackingEntity.getId();
		
	}
	
	public long saveTracking(SoccerPlayerImportTrackingEntity soccerPlayerImportTrackingEntity) {
		this.entityManager.persist(soccerPlayerImportTrackingEntity);
		
		
		return soccerPlayerImportTrackingEntity.getId();
	}
	
	public SoccerPlayerImportTrackingEntity getSoccerImportTrackingEntityById(long id) {
		return this.entityManager.find(SoccerPlayerImportTrackingEntity.class, id);
	}

}

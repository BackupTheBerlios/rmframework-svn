package com.epac.plugin.dbIntegration.jdbc;

import java.math.BigDecimal;

import junit.framework.Assert;
import net.form105.rm.base.query.AbstractRemoteTest;
import net.form105.rm.base.service.IResult;
import net.form105.rm.base.service.ResultStatus;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.epac.plugin.dbIntegration.mapping.AbstractDBEntity;
import com.epac.plugin.dbIntegration.mapping.action.ActionType;
import com.epac.plugin.dbIntegration.query.EntityQuery;
import com.epac.plugin.dbIntegration.service.ExecuteEntityService;

/**
 * Creating an database entity doesn't give an idea over the generated id from
 * the database side. If we want to run a test, 
 * @author heikok
 *
 */
public class UpdateEntryServiceTest extends AbstractRemoteTest<AbstractDBEntity>{
	
	public static Logger logger = Logger.getLogger(UpdateEntryServiceTest.class);
	
	private String elementId ="idTemp001";
	private String changedElementId = "cIdTemp001";
	private String elementType = "tempType";
	private String changedElementType = "cTempType";
	private int elementInteger = 99;
	private int changeElementInteger = 101;
	private BigDecimal elementFloat = new BigDecimal("9.9");
	private BigDecimal changedElementFloat = new BigDecimal("1.01");
	
	@Test
	public void executeTest() {
		insertEntry();
		updateEntry();
	}
	
	public void insertEntry() {
		
		if (selectEntryByElementId(elementId) != null) {
			logger.info("Entry with id("+elementId+") already exists.");
			return;
		}
		
		ExecuteEntityService service = new ExecuteEntityService();
		ExecuteEntityService.ServiceArgument argument = service.getArgument();
		ResourceDBEntityTest entity = new ResourceDBEntityTest();
		argument.actionType = ActionType.INSERT;
		argument.entity = entity;
		entity.setElementId(elementId);
		entity.setElementType(elementType);
		entity.setElementFloat(elementFloat);
		entity.setElementInteger(elementInteger);
		doService(service);
	}
	
	public void updateEntry() {
		
		// Get the entity to work on from the db
		ResourceDBEntityTest entity = (ResourceDBEntityTest) selectEntryByElementId(elementId);
		
		ExecuteEntityService service = new ExecuteEntityService();
		ExecuteEntityService.ServiceArgument argument = service.getArgument();
		
		argument.entity = entity;
		argument.actionType = ActionType.UPDATE;
		
		
		entity.setElementFloat(changedElementFloat);
		
		IResult<AbstractDBEntity> result = doService(service);
		Assert.assertEquals(ResultStatus.SUCCESS, result.getStatus());
	}
	
	public AbstractDBEntity selectEntryByElementId(String elementId) {
		
		ResourceDBEntityTest entity = new ResourceDBEntityTest();
		entity.setConstraint("where dbElementId = '"+elementId+"'");
		
		EntityQuery query = new EntityQuery(entity);
		IResult<AbstractDBEntity> result = doQuery(query);
		
		if (result.getResultList().size() == 0) {
			return null;
		} else {
			return result.getResultList().get(0);
		}
	}
	
	

}

package com.hynix.fdcTest.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hynix.fdcTest.exception.*;
import com.hynix.fdcTest.dto.*;
import com.hynix.fdcTest.mapper.DashBoardMapper;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class DashBoardService {
	private final DashBoardMapper dashBoardMapper;
	
	public List<EquipmentChamberDto> getEqpChamberList() {		
		return dashBoardMapper.getEqpChamberList();
	}
	
	public List<RealTimeTraceGroupDto> getDeltaTraceGroups(String equipId, Long lastOid) {
		return dashBoardMapper.getDeltaTraceGroups(equipId, lastOid);
	} 
}

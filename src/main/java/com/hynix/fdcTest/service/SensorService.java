package com.hynix.fdcTest.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hynix.fdcTest.exception.*;
import com.hynix.fdcTest.dto.*;
import com.hynix.fdcTest.mapper.SensorMapper;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class SensorService {
	private final SensorMapper sensorMapper;
	
	public List<SensorValueList1Dto> getSensorValueList(int txnOid) {
		
		if (txnOid < 0) {
			throw new InvalidSvidFormatException("SVID [" + txnOid + "]가 0보다 작다. " + txnOid);
		}
		
		boolean hasRecipe = true;
		if (! hasRecipe) {
			throw new RecipeNotFoundException("해당 설비에 적용된 Recipe정보가 없습니다.");
		}
				
		return sensorMapper.getSensorValueList(txnOid);
	}
}

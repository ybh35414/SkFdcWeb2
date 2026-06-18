package com.hynix.fdcTest.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hynix.fdcTest.dto.*;

@Mapper
public interface DashBoardMapper {

	List<EquipmentChamberDto> getEqpChamberList();
	
	List<RealTimeTraceGroupDto> getDeltaTraceGroups(String equipId, Long lastOid);
	
}

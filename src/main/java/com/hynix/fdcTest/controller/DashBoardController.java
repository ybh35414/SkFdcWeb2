package com.hynix.fdcTest.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.hynix.fdcTest.service.*;
import com.hynix.fdcTest.dto.*;

@RestController
@RequestMapping("/api/fdc/dashboard")
@RequiredArgsConstructor
public class DashBoardController {

	private final DashBoardService dashBoardService;
	
	@GetMapping("/eqplist")
	List<EquipmentChamberDto> getEqpChamberList() {
		return dashBoardService.getEqpChamberList();				
	}	
	
	
	@GetMapping("/valuelist/{equipId}/{lastOid}")
	List<RealTimeTraceGroupDto> getDeltaTraceGroups(
			@PathVariable("equipId") String equipId,
			@PathVariable("lastOid") Long lastOid)	 {
		return dashBoardService.getDeltaTraceGroups(equipId, lastOid);
	}
		
}

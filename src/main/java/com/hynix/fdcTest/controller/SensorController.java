package com.hynix.fdcTest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.hynix.fdcTest.service.*;
import com.hynix.fdcTest.dto.*;

@RestController
@RequestMapping("/api/fdc/sensor")
@RequiredArgsConstructor
public class SensorController {

	// vs 1.1
	// vs 1.2
	// vs 1.3
	private final SensorService sensorService;
	
	@GetMapping("/valuelist/{txnOid}")
	List<SensorValueList1Dto> getSensorValueList(@PathVariable("txnOid") int txnOid) {
		return sensorService.getSensorValueList(txnOid);
	}	
	
}

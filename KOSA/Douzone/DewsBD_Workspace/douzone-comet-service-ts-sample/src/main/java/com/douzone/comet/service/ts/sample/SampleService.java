package com.douzone.comet.service.ts.sample;

import com.douzone.comet.components.DzCometService;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.enums.CometModule;
import com.douzone.gpd.restful.enums.DzRequestMethod;

@DzApiService(value = "SampleService", module = CometModule.TS, desc = "테스트 서비스")
public class SampleService extends DzCometService{

	@DzApi(url="/test", httpMethod=DzRequestMethod.GET, desc = "샘플 테스트 API입니다.")
	public String hello() throws Exception {
		return "hello, World";
	}
}

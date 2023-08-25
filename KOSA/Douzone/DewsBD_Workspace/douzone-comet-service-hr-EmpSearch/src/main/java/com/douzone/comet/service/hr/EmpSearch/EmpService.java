package com.douzone.comet.service.hr.EmpSearch;
 
import com.douzone.comet.components.DzCometService;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.enums.CometModule;
import java.util.List;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.comet.service.hr.EmpSearch.models.EmpSearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

/** 
  * @description :
  * @Since   : 
  * @Author  :
  * @History :
  */
@DzApiService(value="EmpService", module=CometModule.HR, desc="사원조회서비스")
public class EmpService extends DzCometService {

	@Autowired
	EmpSearchDAO empsearchDAO; 

	@DzApi(url="/empsearch_list", desc="사원 조회 API 입니다.", httpMethod=DzRequestMethod.GET)
	public List<EmpSearchModel> empsearch_list(
		@DzParam(key="dept_cd", desc="부서", paramType = DzParamType.QueryString) String dept_cd
	) throws Exception {
		List<EmpSearchModel> empSearchModelList =  new ArrayList<EmpSearchModel>();
		try {
	 		EmpSearchModel empSearchModel = new EmpSearchModel();
	 		empSearchModel.setDept_cd(dept_cd);
			empSearchModel.setCompany_cd(this.getCompanyCode());
			//empSearchModel.setLang_cd(this.getLanguage().toUpperCase());
	 		empSearchModelList = empsearchDAO.selectEmpSearchModelList(empSearchModel);
	 	} catch(Exception e) {
	        throw new DzApplicationRuntimeException(e);
	    }
	    
	    return empSearchModelList;
 	}
}

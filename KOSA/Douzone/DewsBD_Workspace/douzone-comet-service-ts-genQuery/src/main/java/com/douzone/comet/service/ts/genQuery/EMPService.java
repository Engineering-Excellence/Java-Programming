package com.douzone.comet.service.ts.genQuery;
 
import java.util.List;
import com.douzone.comet.components.DzCometService;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.CometModule;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.gpd.restful.model.DzGridModel;
import com.douzone.comet.service.ts.genQuery.dao.EmpfindDAO;
import com.douzone.comet.service.ts.genQuery.models.EmpfindModel;
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
@DzApiService(value="EMPService", module=CometModule.HR, desc="사원조회서비스")
public class EMPService extends DzCometService {

	@Autowired
	EmpfindDAO empfindDAO; 

	@DzApi(url="/empfind_list", desc="사원조회API - Search", httpMethod=DzRequestMethod.GET)
	public List<EmpfindModel> empfind_list(
		@DzParam(key="dept_cd", desc="부서코드", paramType = DzParamType.QueryString) String dept_cd
	) throws Exception {
		List<EmpfindModel> empfindModelList =  new ArrayList<EmpfindModel>();
		try {
	 		EmpfindModel empfindModel = new EmpfindModel();
	 		empfindModel.setDept_cd(dept_cd);
			//empfindModel.setCompany_cd(this.getCompanyCode());
			//empfindModel.setLang_cd(this.getLanguage().toUpperCase());
	 		empfindModelList = empfindDAO.selectEmpfindModelList(empfindModel);
	 	} catch(Exception e) {
	        throw new DzApplicationRuntimeException(e);
	    }
	    
	    return empfindModelList;
 	}

	@Transactional(rollbackFor = Exception.class)
	@DzApi(url="/empfind_save", desc="사원조회API - Save", httpMethod=DzRequestMethod.POST)
	public void empfind_save(
		@DzParam(key="dataSource", desc="저장 목록", paramType = DzParamType.Body) DzGridModel<EmpfindModel> dataSource
	) throws Exception {	    
	    try {	        	        
	        // update
	        for(EmpfindModel empfindModel : dataSource.getUpdated()) {
	        	empfindDAO.updateEmpfindModel(empfindModel);
	        }
	        
	        // delete
	        for(EmpfindModel empfindModel : dataSource.getDeleted()) {
	        	empfindDAO.deleteEmpfindModel(empfindModel);
	        }
	        
	        // add
	        for(EmpfindModel empfindModel : dataSource.getAdded()) {
	        	empfindDAO.insertEmpfindModel(empfindModel);
	        }
	        
	    } catch (Exception e) {
	        throw new DzApplicationRuntimeException(e);
	    }
	}
}

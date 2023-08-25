package com.douzone.comet.service.hr.EmpSearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.comet.jdbc.mybatis.DzMybatisSupport;
import com.douzone.comet.service.hr.EmpSearch.models.EmpSearchModel;
/** 
  * @description :
  * @Since   : 
  * @Author  :
  * @History :
  */
@Repository
public class EmpSearchDAO  {

	private DzMybatisSupport mybatisSupport;

	@Autowired
	public EmpSearchDAO(DzMybatisSupport mybatisSupport) {
		this.mybatisSupport = mybatisSupport;
	}

	/**
	 * 복수 데이터 목록 조회
	 * @param empSearchModel
	 * @return List<EmpSearchModel>
	 */
	public List<EmpSearchModel> selectEmpSearchModelList(EmpSearchModel empSearchModel) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".selectEmpSearchModelList", empSearchModel);
	}

}

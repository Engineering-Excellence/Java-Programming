package com.douzone.comet.service.ts.genQuery.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.comet.jdbc.mybatis.DzMybatisSupport;
import com.douzone.comet.service.ts.genQuery.models.EmpfindModel;

/** 
  * @description :
  * @Since   : 
  * @Author  :
  * @History :
  */
@Repository
public class EmpfindDAO  {

	private DzMybatisSupport mybatisSupport;

	@Autowired
	public EmpfindDAO(DzMybatisSupport mybatisSupport) {
		this.mybatisSupport = mybatisSupport;
	}

	/**
	 * 복수 데이터 목록 조회
	 * @param empfindModel
	 * @return List<EmpfindModel>
	 */
	public List<EmpfindModel> selectEmpfindModelList(EmpfindModel empfindModel) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".selectEmpfindModelList", empfindModel);
	}

	/**
	 * 단일 데이터 입력 처리
	 * @param empfindModel
	 */
	public void insertEmpfindModel(EmpfindModel empfindModel) throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".insertEmpfindModel", empfindModel);
	}

	/**
	 * 단일 데이터 수정 처리
	 * @param empfindModel
	 */
	public void updateEmpfindModel(EmpfindModel empfindModel) throws Exception {
		this.mybatisSupport.update(this.getClass().getName() + ".updateEmpfindModel", empfindModel);
	}

	/**
	 * 단일 데이터 삭제 처리
	 * @param empfindModel
	 */
	public void deleteEmpfindModel(EmpfindModel empfindModel) throws Exception {
		this.mybatisSupport.delete(this.getClass().getName() + ".deleteEmpfindModel", empfindModel);
	}

}

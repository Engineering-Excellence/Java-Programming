package com.douzone.comet.service.ts.genQuery.models;
 
import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;
 
@DzModel(name = "EmpfindModel", desc = "사원조회API", tableName = "HR_EMP_MST")
public class EmpfindModel extends DzAbstractModel {

	@SerializedName("COMPANY_CD")
	@DzModelField(name="company_cd", desc="회사코드", colName="COMPANY_CD", colSize="7", isKey=false)
	private String company_cd;
	  
	@SerializedName("DEPT_CD")
	@DzModelField(name="dept_cd", desc="부서코드", colName="DEPT_CD", colSize="20", isKey=false)
	private String dept_cd;
	  
	@SerializedName("EMP_NO")
	@DzModelField(name="emp_no", desc="사원번호", colName="EMP_NO", colSize="20", isKey=false)
	private String emp_no;
	  
	@SerializedName("KOR_NM")
	@DzModelField(name="kor_nm", desc="한글명", colName="KOR_NM", colSize="50", isKey=false)
	private String kor_nm;

	public String getCompany_cd() {
		return company_cd;
	}

	public void setCompany_cd(String company_cd) {
		this.company_cd = company_cd;
	}
 
	public String getDept_cd() {
		return dept_cd;
	}

	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
 
	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
 
	public String getKor_nm() {
		return kor_nm;
	}

	public void setKor_nm(String kor_nm) {
		this.kor_nm = kor_nm;
	}
	
    @Override
    public String toString() {
      return
        "company_cd: ["+ company_cd +"]\n"+
        "dept_cd: ["+ dept_cd +"]\n"+
        "emp_no: ["+ emp_no +"]\n"+
        "kor_nm: ["+ kor_nm +"]";
    }
}

package edu.kosa.model;

import java.util.List;

public interface DeptDAO {

    public List listDept();

    public void insertDept(DeptDTO dto);
}

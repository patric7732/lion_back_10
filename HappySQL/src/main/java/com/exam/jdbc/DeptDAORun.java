package com.exam.jdbc;

public class DeptDAORun {
    public static void main(String[] args) {
        DeptDAO deptDAO = new DeptDAO();
        DeptDTO deptDTO = new DeptDTO();
        deptDTO.setDeptno(80);
        deptDTO.setDname("like");
        deptDTO.setLoc("판교");

//        boolean resultFlag = deptDAO.addDept(deptDTO);
//        if(resultFlag)
//            System.out.println("입력성공!!");
//        else
//            System.out.println("입력실패 ㅠㅠ");

        int resultCount = deptDAO.updateDept(deptDTO);
        System.out.println(resultCount);

    }
}

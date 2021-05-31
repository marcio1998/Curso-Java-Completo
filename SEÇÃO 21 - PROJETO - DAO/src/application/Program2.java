package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("=== Test 1 Find By Id Department ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		System.out.println("=== Test 2 Insert Department ===");
		dep = new Department(null, "Drink");
		departmentDao.insert(dep);
		System.out.println("=== Test 3 Update Department ===");
		dep = departmentDao.findById(3);
		dep.setName("Furniture");
		departmentDao.update(dep);
		System.out.println("=== Test 4 Delete Department ===");
		departmentDao.deleteById(1);
		System.out.println("=== Test 4 FindAll Department ===");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
	}

}

package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== Test 1: FindById seller ===");
		Seller seller = sellerDao.findById(3);
		System.out.println("\n=== Test 2: FindByDepartment seller ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		System.out.println("\n=== Test 3: FindAll seller ===");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		System.out.println("\n=== Test 4: Insert seller ===");
		seller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(seller);
		System.out.println("Insert new Id: " + seller.getId());
		System.out.println("\n=== Test 5: Update seller ===");
		seller = sellerDao.findById(1);
		seller.setName("Marthe Wayne");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		System.out.println("\n=== Test 6: Delete seller ===");
		sellerDao.deleteById(2);
		System.out.println("Deleted");
		
		
	}

}

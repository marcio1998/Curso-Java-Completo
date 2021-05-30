package model.dao;

import java.util.List;

import model.entities.Seller;
import model.entities.Seller;

public interface SellerDao {
	void insert(Seller obj); // inserir no banco de dados objeto que vem como entrada
	void update(Seller obj);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
}

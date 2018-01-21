package dao;

public interface DAOInterface <T> {

   void create(T object);

   T getById(int id);

   void update(T object);

   void delete(T object);
}

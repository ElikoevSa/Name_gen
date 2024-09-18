package NameGenerator.data.repository;

import jakarta.data.repository.Delete;
import jakarta.data.repository.Repository;
import jakarta.data.repository.Save;
import jakarta.data.repository.Update;
import org.hibernate.annotations.processing.Find;

import java.util.List;

@Repository
public interface DataRepository<T> {

        @Save
        void save(T t);
        @Save
        void saveAll(List<T> list);
        @Find
        List<T> findAll(Class o);
        @Find
        void findOneById(T t);
        @Update
        void update(T t);
        @Delete
        void delete(T t);

}

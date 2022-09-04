package dat3.carsrus.dto;

public interface DTO<T> {

    T convertToEntity();

    T updateEntity(T entity);
}

package dat3.carsrus.service;

import dat3.carsrus.dto.DTO;
import dat3.carsrus.dto.member.MemberResponse;
import dat3.carsrus.entity.Member;
import org.apache.coyote.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Service<EntityType, RequestType extends DTO<EntityType>, ResponseType, IDENTIFIER> {

    abstract ResponseType getById(IDENTIFIER id);
    abstract List<ResponseType> getAll();
    abstract void addNew(RequestType body);
    abstract void deleteById(IDENTIFIER id);
    abstract void updateById(IDENTIFIER id, RequestType body);

    protected ResponseType getById(IDENTIFIER id, JpaRepository<EntityType, IDENTIFIER> repository, Class<ResponseType> responseTypeClass, Class<EntityType> entityTypeClass) {

        Optional<EntityType> foundEntity = repository.findById(id);

        if (foundEntity.isPresent()) {
            return getResponseType(foundEntity.get(), responseTypeClass, entityTypeClass);
        }
        else {
            return null;
        }
    }

    protected List<ResponseType> getAll(JpaRepository<EntityType, IDENTIFIER> repository, Class<ResponseType> responseTypeClass, Class<EntityType> entityTypeClass) {
        List<EntityType> foundEntities = repository.findAll();
        List<ResponseType> responseEntities = new ArrayList<>();

        for (EntityType entity : foundEntities) {
            responseEntities.add(getResponseType(entity, responseTypeClass, entityTypeClass));
        }

        return responseEntities;
    }

    protected void addNew(RequestType body, JpaRepository<EntityType, IDENTIFIER> repository) {
        repository.save(body.convertToEntity());
    }

    protected void deleteById(IDENTIFIER id, JpaRepository<EntityType, IDENTIFIER> repository) {
        repository.deleteById(id);
    }

    protected void updateById(IDENTIFIER id, RequestType body, JpaRepository<EntityType, IDENTIFIER> repository) {
        Optional<EntityType> foundEntity = repository.findById(id);

        if (foundEntity.isPresent()) {
            repository.save(body.updateEntity(foundEntity.get()));
        }
    }

    private ResponseType getResponseType(EntityType foundEntity, Class<ResponseType> responseTypeClass, Class<EntityType> entityTypeClass){
        try {
            return responseTypeClass.getConstructor(entityTypeClass, Boolean.class).newInstance(foundEntity, false);
        } catch (Exception e) {
            try {
                return responseTypeClass.getConstructor(entityTypeClass).newInstance(foundEntity);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }
}

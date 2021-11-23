package com.telefonica.mssubscriberinformation.model.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Slf4j
@Repository
public class TestRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void testSP() {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("DPH.PK_VAR_SP.SELECCION");

        storedProcedureQuery.registerStoredProcedureParameter("CURSORMEMORIA", void.class, ParameterMode.REF_CURSOR);

        /** Realizamos la llamada al procedimiento**/
        storedProcedureQuery.execute();

        // Obtenemos el resultado del cursos en una lista
        List<Object[]> results = storedProcedureQuery.getResultList();

        log.info(results.toString());


    }
}

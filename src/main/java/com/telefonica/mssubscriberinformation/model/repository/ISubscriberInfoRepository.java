package com.telefonica.mssubscriberinformation.model.repository;

import com.telefonica.mssubscriberinformation.model.entity.SubscriberInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ISubscriberInfoRepository extends JpaRepository<SubscriberInfoEntity, String> {


    @Procedure(name = "SP_PLAN_HOME")
    public Map<String, Object> consumeSP(@Param("P_NUMERO_CUENTA") String pNumeroCuenta,
                                         @Param("P_NUMERO_TELEFONO") Integer pNumeroTelefono,
                                         @Param("P_METODO_BUSQUEDA") Integer pMetodoBusqueda);

    @Procedure(name = "SP_TEST_PK")
    public Map<String, Object> cursor();
}

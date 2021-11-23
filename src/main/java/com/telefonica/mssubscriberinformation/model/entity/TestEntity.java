package com.telefonica.mssubscriberinformation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "SP_TEST_PK",
                // SCHEMA_NAME.PACKAGE_NAME.METHOD_OR_PROCEDURE_NAME
                procedureName = "DPH.PK_VAR_SP.SELECCION",
                resultClasses = TestEntity.class,
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class),
                })
})
public class TestEntity {

    @Id
    @Column(name = "CURSORMEMORIA")
    private String CURSORMEMORIA;
}

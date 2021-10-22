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
                name = "SP_PLAN_HOME",
                // SCHEMA_NAME.PACKAGE_NAME.METHOD_OR_PROCEDURE_NAME
                procedureName = "DPH.SP_ListaProductos",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NUMERO_CUENTA", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NUMERO_TELEFONO", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_METODO_BUSQUEDA", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_AcctCode", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_OwnerPartyRoleId", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_Product", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_ProductType", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_ServiceNumber", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_PaymentReference", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_Status", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_OfferingCode", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_OfferingName", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_IdType", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_IdNumber", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_ContactValue", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_FlagEmail", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_codigoError", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "v_descError", type = String.class)
                })
})
@IdClass(PKSubscriberInfoEntity.class)
public class SubscriberInfoEntity {

    @Id
    @Column(name = "v_OfferingCode")
    private String vOfferingCode;

    @Id
    @Column(name = "v_OfferingName")
    private String vOfferingName;

    @Column(name = "v_AcctCode")
    private String vAcctCode;

    @Column(name = "v_OwnerPartyRoleId")
    private String vOwnerPartyRoleId;

    @Column(name = "v_Product")
    private String vProduct;

    @Column(name = "v_ProductType")
    private String vProductType;

    @Column(name = "v_ServiceNumber")
    private String vServiceNumber;

    @Column(name = "v_PaymentReference")
    private String vPaymentReference;

    @Column(name = "v_Status")
    private String vStatus;

    @Column(name = "v_IdType")
    private String vIdType;

    @Column(name = "v_IdNumber")
    private String vIdNumber;

    @Column(name = "v_ContactValue")
    private String vContactValue;

    @Column(name = "v_FlagEmail")
    private String vFlagEmail;

    @Column(name="v_codigoError")
    private Integer vCodeError;

    @Column(name = "v_descError")
    private String vDescError;













}

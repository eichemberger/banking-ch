package ar.com.bankist.builders;

import ar.com.bankist.entities.Empresa;

import java.time.LocalDateTime;

public class EmpresaBuilder {

    private Empresa empresa;

    public EmpresaBuilder() {
        empresa = new Empresa();
    }

    public EmpresaBuilder conCuit(String cuit) {
        empresa.setCuit(cuit);
        return this;
    }

    public EmpresaBuilder conRazonSocial(String razonSocial) {
        empresa.setRazonSocial(razonSocial);
        return this;
    }

    public EmpresaBuilder conFechaAdhesion(LocalDateTime fechaAdhesion) {
        empresa.setFechaAdhesion(fechaAdhesion);
        return this;
    }

    public static EmpresaBuilder crearGenerico() {
        EmpresaBuilder builder = new EmpresaBuilder();

        builder.conCuit("123456789");
        builder.conRazonSocial("Razon Social");
        builder.conFechaAdhesion(LocalDateTime.now());

        return builder;
    }

    public Empresa crear() {
        return empresa;
    }

}

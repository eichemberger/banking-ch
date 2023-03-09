package ar.com.bankist.services;

import ar.com.bankist.entities.Empresa;
import ar.com.bankist.repositories.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@AllArgsConstructor
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    public Page<Empresa> buscarConTransferenciasEnElUltimoMes(Integer pagina, Integer cantidad) {
        Pageable pageRequest = PageRequest.of(pagina, calcularCantidadDePaginas(cantidad));

        return empresaRepository.buscarConTransferenciasEnElUltimoMes(pageRequest);
    }

    public Page<Empresa> buscarAdheridasMasRecientes(Integer pagina, Integer cantidad) {
        Pageable pageRequest = PageRequest.of(pagina, calcularCantidadDePaginas(cantidad));

        return empresaRepository.buscarAdheridasMasRecientes(pageRequest);
    }

    public Empresa crearEmpresa(Empresa empresa) {
        Assert.hasText(empresa.getCuit(), "Se debe especificar el CUIT");
        Assert.hasText(empresa.getRazonSocial(), "Se debe especificar la razón social");
        Assert.isNull(empresaRepository.findByCuit(empresa.getCuit()), "Ya existe una empresa con el CUIT especificado");

        return empresaRepository.save(empresa);
    }

    private Integer calcularCantidadDePaginas(Integer cantidad) {
        if (cantidad == null) {
            cantidad = Integer.MAX_VALUE;
        }
        return cantidad;
    }

}

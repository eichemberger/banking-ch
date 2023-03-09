package ar.com.bankist.services;

import ar.com.bankist.builders.EmpresaBuilder;
import ar.com.bankist.entities.Empresa;
import ar.com.bankist.repositories.EmpresaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class EmpresaServiceTest {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Test
    void crearTransferencia_sinCuit_lanzaExcepcion() {
        Empresa empresa = EmpresaBuilder.crearGenerico().conCuit(null).crear();

        assertThrows(IllegalArgumentException.class, () -> empresaService.crearEmpresa(empresa));
    }

    @Test
    void crearTransferencia_sinRazonSocial_lanzaExcepcion() {
        Empresa empresa = EmpresaBuilder.crearGenerico().conRazonSocial(null).crear();

        assertThrows(IllegalArgumentException.class, () -> empresaService.crearEmpresa(empresa));
    }

    @Test
    void crearTransferencia_conCuitEnUso_lanzaExcepcion() {
        Empresa empresaExistente = EmpresaBuilder.crearGenerico().crear();
        empresaExistente = empresaRepository.save(empresaExistente);
        Empresa empresa = EmpresaBuilder.crearGenerico().conCuit(empresaExistente.getCuit()).crear();

        assertThrows(IllegalArgumentException.class, () -> empresaService.crearEmpresa(empresa));
    }

    @Test
    void crearEmpresa_conDatosValidos_retornaEmpresa() {
        Empresa empresa = EmpresaBuilder.crearGenerico().crear();

        Empresa result = empresaService.crearEmpresa(empresa);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getFechaAdhesion());
    }
}

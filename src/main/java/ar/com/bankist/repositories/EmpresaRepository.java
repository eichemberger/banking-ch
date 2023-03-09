package ar.com.bankist.repositories;

import ar.com.bankist.entities.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Empresa findByCuit(String cuit);

    @Query(value = "SELECT * " +
            "FROM empresas e " +
            "JOIN transferencias t on t.id_empresa = e.id " +
            "WHERE t.fecha_creacion > CURRENT_DATE - 30 ", nativeQuery = true)
    Page<Empresa> buscarConTransferenciasEnElUltimoMes(Pageable pageRequest);

    @Query("SELECT e FROM Empresas e WHERE e.fechaAdhesion > CURRENT_DATE - 30 ")
    Page<Empresa> buscarAdheridasMasRecientes(Pageable pageRequest);

}

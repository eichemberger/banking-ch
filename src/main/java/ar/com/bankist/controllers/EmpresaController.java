package ar.com.bankist.controllers;

import ar.com.bankist.entities.Empresa;
import ar.com.bankist.services.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/empresas")
public class EmpresaController {

    private EmpresaService empresaService;

    @GetMapping("/transferencias-en-el-ultimo-mes")
    public ResponseEntity<Page<Empresa>> buscarConTransferenciasEnElUltimoMes(@RequestParam(required = false, defaultValue = "0") Integer pagina,
                                                              @RequestParam(required = false) Integer cantidad) {
        return new ResponseEntity<>(empresaService.buscarConTransferenciasEnElUltimoMes(pagina, cantidad), HttpStatus.OK);
    }

    @GetMapping("/adheridas-en-el-ultimo-mes")
    public ResponseEntity<Page<Empresa>> buscarAdheridasMasRecientes(@RequestParam(required = false, defaultValue = "0") Integer pagina,
                                                     @RequestParam(required = false) Integer cantidad) {
        return new ResponseEntity<>(empresaService.buscarAdheridasMasRecientes(pagina, cantidad), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Empresa> crearEmpresa(@RequestBody Empresa empresa) {
        return new ResponseEntity<>(empresaService.crearEmpresa(empresa), HttpStatus.CREATED);

    }

}

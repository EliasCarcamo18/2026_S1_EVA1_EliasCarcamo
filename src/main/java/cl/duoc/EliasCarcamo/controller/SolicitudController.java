package cl.duoc.EliasCarcamo.controller;

import cl.duoc.EliasCarcamo.model.Solicitud;
import cl.duoc.EliasCarcamo.service.SolicitudService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public ResponseEntity<List<Solicitud>> getAllSolicitudes() {
        return ResponseEntity.ok(solicitudService.getAllSolicitudes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSolicitudById(@PathVariable Long id) {
        return solicitudService.getSolicitudById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createSolicitud(@Valid @RequestBody Solicitud solicitud) {
        return ResponseEntity.ok(solicitudService.createSolicitud(solicitud));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSolicitud(@PathVariable Long id, @Valid @RequestBody Solicitud solicitud) {
        return solicitudService.updateSolicitud(id, solicitud)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSolicitud(@PathVariable Long id) {
        return solicitudService.deleteSolicitud(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // Endpoint de transformacion: ordenar por fecha
    @GetMapping("/ordenar/fecha")
    public ResponseEntity<List<Solicitud>> ordenarPorFecha() {
        return ResponseEntity.ok(solicitudService.ordenarPorFechaRegistro());
    }

    // Endpoint de busqueda por especialidad
    @GetMapping("/buscar/especialidad/{especialidad}")
    public ResponseEntity<List<Solicitud>> buscarPorEspecialidad(@PathVariable String especialidad) {
        return ResponseEntity.ok(solicitudService.buscarPorEspecialidad(especialidad));
    }
}
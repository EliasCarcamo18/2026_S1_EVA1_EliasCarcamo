package cl.duoc.EliasCarcamo.service;

import cl.duoc.EliasCarcamo.model.Solicitud;
import cl.duoc.EliasCarcamo.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    public SolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    public List<Solicitud> getAllSolicitudes() {
        return solicitudRepository.findAll();
    }

    public Optional<Solicitud> getSolicitudById(Long id) {
        return solicitudRepository.findById(id);
    }

    public Solicitud createSolicitud(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    public Optional<Solicitud> updateSolicitud(Long id, Solicitud solicitud) {
        if (solicitudRepository.existsById(id)) {
            solicitud.setId(id);
            return Optional.of(solicitudRepository.save(solicitud));
        }
        return Optional.empty();
    }

    public boolean deleteSolicitud(Long id) {
        if (solicitudRepository.existsById(id)) {
            solicitudRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Ordenar solicitudes por fechaRegistro ascendente
    public List<Solicitud> ordenarPorFechaRegistro() {
        return solicitudRepository.findAll().stream()
            .sorted(Comparator.comparing(Solicitud::getFechaRegistro))
            .collect(Collectors.toList());
    }

    // Busqueda por especialidad
    public List<Solicitud> buscarPorEspecialidad(String especialidad) {
        return solicitudRepository.findAll().stream()
            .filter(s -> s.getEspecialidad().equalsIgnoreCase(especialidad))
            .collect(Collectors.toList());
    }
}
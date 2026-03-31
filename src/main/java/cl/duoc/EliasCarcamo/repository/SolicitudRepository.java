package cl.duoc.EliasCarcamo.repository;

import cl.duoc.EliasCarcamo.model.Solicitud;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SolicitudRepository {

    private final Map<Long, Solicitud> solicitudStore = new HashMap<>();

    public List<Solicitud> findAll() {
        return new ArrayList<>(solicitudStore.values());
    }

    public Optional<Solicitud> findById(Long id) {
        return Optional.ofNullable(solicitudStore.get(id));
    }

    public Solicitud save(Solicitud solicitud) {
        solicitudStore.put(solicitud.getId(), solicitud);
        return solicitud;
    }

    public void deleteById(Long id) {
        solicitudStore.remove(id);
    }

    public boolean existsById(Long id) {
        return solicitudStore.containsKey(id);
    }
}
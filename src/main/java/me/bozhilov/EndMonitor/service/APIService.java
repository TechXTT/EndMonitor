package me.bozhilov.EndMonitor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.bozhilov.EndMonitor.repository.APIRepository;
import me.bozhilov.EndMonitor.model.API;

@Service
public class APIService {

    @Autowired
    private APIRepository apiRepository;

    public APIService(APIRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public List<API> findAll() {
        return apiRepository.findAll();
    }

    public API findById(Long id) {
        return apiRepository.findById(id).orElse(null);
    }

    public API save(API api) {
        return apiRepository.save(api);
    }

    public void deleteById(Long id) {
        apiRepository.deleteById(id);
    }

}

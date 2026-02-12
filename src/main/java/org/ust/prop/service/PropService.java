package org.ust.prop.service;

import org.aspectj.apache.bcel.classfile.annotation.RuntimeTypeAnnos;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.ust.prop.model.Prop;
import org.ust.prop.repository.PropRepository;

import java.util.List;

@Service
public class PropService {
    public PropRepository propRepository;

    public PropService(PropRepository propRepository){
        this.propRepository = propRepository;
    }

    public Prop addProp(Prop prop){
        return propRepository.save(prop);
    }

    public List<Prop> getAllProp(){
        return propRepository.findAll();
    }

    public Prop getPropById(Long id){
        return propRepository.findById(id).orElse(null);
    }

    public Prop updateProp(long id, Prop prop) {
        Prop existing = getPropById(id);
        if (prop.getAddress() != null){
            existing.setAddress(prop.getAddress());
        }
        if (prop.getDescription() != null){
            existing.setDescription(prop.getDescription());
        }
        return propRepository.save(existing);
    }

    public void deleteProp(Long id){
        propRepository.deleteById(id);
    }



    }




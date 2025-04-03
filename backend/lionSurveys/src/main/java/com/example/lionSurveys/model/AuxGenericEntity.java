package com.example.lionSurveys.model;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.data.repository.CrudRepository;

import com.utils.ApplicationContextUtil;

public abstract class AuxGenericEntity {
    public void save() throws Exception{
        CrudRepository repository = null;
        try {
            repository= (CrudRepository) ApplicationContextUtil.getApplicationContext().getBean(Class
            .forName(
                "com.example.lionSurveys.repositories." + this.getClass().getSimpleName() + "Repository"
            )
                
            );
        }
        catch (BeansException | ClassNotFoundException e) {
            throw new Exception("Error al obtener el repositorio: " + e.getMessage());
        }
        repository .save(this);
    }
    public void delete() throws Exception {
        CrudRepository  repository = null;
    
        try{
            repository= (CrudRepository) ApplicationContextUtil.getApplicationContext().getBean(Class
            .forName(
                "com.example.lionSurveys.repositories." + this.getClass().getSimpleName() + "Repository"
            ));
        }
        catch (BeansException  | ClassNotFoundException e) {
            throw new Exception("Error al borrar: " + e.getMessage());
        }
        repository.delete(this);
    }
}



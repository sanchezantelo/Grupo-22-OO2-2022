package com.webservice.app.converters;

import org.springframework.stereotype.Component;

import com.webservice.app.entities.Persona;
import com.webservice.app.models.PersonaModel;

@Component("personaModel")

public class PersonaConverter {



	public PersonaModel entityToModel(Persona persona){
        return new PersonaModel(persona.getId(), persona.getNombre(), persona.getApellido(),persona.getTipoDocumento(),String.valueOf(persona.getDni()), persona.getEmail());
    }

    public Persona modelToEntity(PersonaModel personaModel){
        return new Persona(personaModel.getId(),personaModel.getNombre(), personaModel.getApellido() ,personaModel.getTipoDocumento(),Long.valueOf(personaModel.getDni()),personaModel.getEmail());
    }
}



package com.zenika.vhr.maintenance.api;

import com.zenika.vhr.maintenance.application.dto.AjouterInterventionDto;
import com.zenika.vhr.maintenance.application.usecases.AjouterIntervention;
import com.zenika.vhr.maintenance.domaine.intervention.InterventionId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carnets/{id}/interventions")
public class InterventionController {


    private AjouterIntervention ajouterIntervention;

    InterventionController(AjouterIntervention ajouterIntervention){

        this.ajouterIntervention = ajouterIntervention;
    }


    @PostMapping()
    public ResponseEntity<Void> ajouterIntervention(
            @PathVariable("id") String id,
            @RequestBody AjouterInterventionDto dto
    ){
        InterventionId idIntervention = this.ajouterIntervention.ajouter(id, dto);

        //Publisher.execute(COMMAND_AJOUTER_INTERVENTION, dto)

        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "/api/carnets/"+id+"/interventions/"+idIntervention.id)
                .build();
    }

}

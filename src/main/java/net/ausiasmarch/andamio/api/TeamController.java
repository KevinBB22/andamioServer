package net.ausiasmarch.andamio.api;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;
import net.ausiasmarch.andamio.entity.TeamEntity;
import net.ausiasmarch.andamio.service.TeamService;


@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService oTeamService;
 

    @GetMapping("/{id}")
    public ResponseEntity<TeamEntity> get(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<TeamEntity>(oTeamService.get(id), HttpStatus.OK);
    }
    

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable(value = "id") Long id){
        return oTeamService.delete(id);
    }

    @GetMapping("")
    public ResponseEntity<Page<TeamEntity>> getPage(
            @ParameterObject @PageableDefault(page = 0, size = 10, direction = Sort.Direction.DESC) Pageable oPageable) {
        return new ResponseEntity<Page<TeamEntity>>(oTeamService.getPage(oPageable), HttpStatus.OK);
    }


 
    
}
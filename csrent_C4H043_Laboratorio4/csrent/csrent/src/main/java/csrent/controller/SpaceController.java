package csrent.controller;

import csrent.model.Space;
import csrent.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/space")
public class SpaceController {
    @Autowired
    SpaceService service;

    private ArrayList<Space> spaces;

    public SpaceController() {

        //spaces= new ArrayList<Space>();

    }

    @GetMapping
    public ArrayList<Space> getAll(){
        return service.getAll();
        }

    @PostMapping
    public Space postSpace(@RequestBody Space space) {
        return service.add(space);
    }

    @GetMapping("/{id}")
    public Space getSpaceById(@PathVariable int id) {
        return service.search(id);
    }

    @PutMapping
    public Space putSpace(@RequestBody Space space) {
        return service.update(space);
    }

    @DeleteMapping("/{id}")
    public Space deleteSpace(@PathVariable int id) {
        return service.delete(id);
    }

    @PatchMapping
    public Space patchSpace (@RequestBody Space space) {
        return service.edit(space);
    }

    }


package docker.springbootdocker.controller;


import docker.springbootdocker.dto.core.ItemDto;
import docker.springbootdocker.service.ItemService;
import docker.springbootdocker.util.StandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/item")
@CrossOrigin
public class ItemController {

    private final ItemService itemService;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<StandResponse> save(@ModelAttribute ItemDto dto){
//        System.out.println(dto.toString());
    ItemDto save = itemService.save(dto);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",dto), HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandResponse> update(@RequestBody ItemDto dto){
        ItemDto update = itemService.update(dto);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"update",update), HttpStatus.CREATED
        );
    }

    @DeleteMapping(params = {"code"})
    public ResponseEntity<StandResponse> delete(@RequestParam String code){
        itemService.delete(code);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"deleted",null), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "list")
    public ResponseEntity<StandResponse> getAll(){
        List<ItemDto> all = itemService.findAll();
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"saved",all), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "{searchId}")
    public ResponseEntity<StandResponse> get(@PathVariable("searchId") String id){
        ItemDto itemDto = itemService.find(id);
        return new ResponseEntity<StandResponse>(
                new StandResponse(200,"searchId",itemDto), HttpStatus.CREATED
        );

    }
}

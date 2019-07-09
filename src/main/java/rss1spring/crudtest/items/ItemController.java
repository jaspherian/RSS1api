package rss1spring.crudtest.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;


    @PostMapping
    public void addItem(@RequestBody Item item){
        itemService.save(item);
    }

    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable int id){
        return itemService.get(id);
    }

    @PutMapping
    public void updateItem(@RequestBody Item item){
        itemService.save(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id){
        itemService.delete(id);
    }

    @GetMapping("/filter")
    public Page<Item> filterItems(@RequestParam(required = false,value="page") Integer page,
                                  @RequestParam(required = false,value="pageSize") Integer pageSize,
                                  @RequestParam(required = false,value="search") String search,
                                  @RequestParam(required = false,value="sortBy") String sortBy,
                                  @RequestParam(required = false,value="sortOrder") String sortOrder){
        return itemService.filter(page,pageSize,search,sortBy,sortOrder);
    }

    // currently unused
    @GetMapping("/{page}/{size}")
    public List<Item> getItemsByPage(@PathVariable int page,@PathVariable int size){
        return itemService.getPage(page,size);
    }
    // currently unused
    @GetMapping("/count")
    public int getCount(){
        return itemService.getCount();
    }

    // currently unused
    @PostMapping("/addMany")
    public void addItem(@RequestBody List<Item> items){
        itemService.saveAll(items);
    }



}




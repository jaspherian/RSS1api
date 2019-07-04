package rss1spring.crudtest.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;


    @PostMapping("/items")
    public void addItem(@RequestBody Item item){
        itemService.save(item);
    }

    @RequestMapping("/items")
    public List<Item> getAllItems(){
        return itemService.getAll();
    }

    @RequestMapping("/items/{id}")
    public Item getItem(@PathVariable int id){
        return itemService.get(id);
    }

    @PutMapping("/items")
    public void updateItem(@RequestBody Item item){
        itemService.save(item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable int id){
        itemService.delete(id);
    }

    @RequestMapping("/items/{page}/{size}")
    public List<Item> getItemsByPage(@PathVariable int page,@PathVariable int size){
        return itemService.getPage(page,size);
    }

    @RequestMapping("/items/count")
    public int getCount(){
        return itemService.getCount();
    }

    @PostMapping("/items/addMany")
    public void addItem(@RequestBody List<Item> items){
        itemService.saveAll(items);
    }

    @PostMapping("/items/filter")
    public Page<Item> filterItems(@RequestBody Map<String,Object> body){
        return itemService.filter(body);
    }

}




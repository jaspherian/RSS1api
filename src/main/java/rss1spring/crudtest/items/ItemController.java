package rss1spring.crudtest.items;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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



    @ApiOperation(value="Creates an item")
    @ApiResponses(
            value={
                    @ApiResponse(code = 100,message = "100 message."),
                    @ApiResponse(code = 200,message = "200 success message.")

            }
    )
    @PostMapping
    public void addItem(@RequestBody Item item){
        itemService.save(item);
    }



    @ApiOperation(value="Retrieves an item by id")
    @GetMapping("/{id}")
    public Item getItem(@PathVariable int id){
        return itemService.get(id);
    }



    @ApiOperation(value="Updates an item")
    @PutMapping
    public void updateItem(@RequestBody Item item){
        itemService.save(item);
    }



    @ApiOperation(value="Deletes an item by id")
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id){
        itemService.delete(id);
    }



    @ApiOperation(value="Filters through items by pagination,search & sort")
    @GetMapping("/filter")
    public Page<Item> filterItems(@RequestParam(required = false,value="page") Integer page,
                                  @RequestParam(required = false,value="pageSize") Integer pageSize,
                                  @RequestParam(required = false,value="search") String search,
                                  @RequestParam(required = false,value="sortBy") String sortBy,
                                  @RequestParam(required = false,value="sortOrder") String sortOrder){
        return itemService.filter(page,pageSize,search,sortBy,sortOrder);
    }



    // for testing
    @ApiOperation(value="Adds multiple items")
    @PostMapping("/addMany")
    public void addItemMany(@RequestBody List<Item> items){
        itemService.saveAll(items);
    }



    // currently unused
    /*
    @GetMapping("/{page}/{size}")
    public List<Item> getItemsByPage(@PathVariable int page,@PathVariable int size){
        return itemService.getPage(page,size);
    }

    @GetMapping("/count")
    public int getCount(){
        return itemService.getCount();
    }

    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getAll();
    }
    */

}




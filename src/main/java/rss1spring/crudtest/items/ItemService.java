package rss1spring.crudtest.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void save(Item item){
        itemRepository.save(item);
    }

    public List<Item> getAll(){
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::add);
        return items;
    }

    public Item get(int id){
        return itemRepository.findById(id).get();
    }

    public void delete(int id){
        itemRepository.deleteById(id);
    }

    public List<Item> getPage(int page,int size){
        List<Item> items = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size);
        itemRepository.findAll(pageable).forEach(items::add);
        return items;
    }

    public long getCount(){
        return itemRepository.count();
    }

}

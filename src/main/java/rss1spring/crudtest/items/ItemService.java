package rss1spring.crudtest.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import rss1spring.crudtest.utils.Utilities.Util;

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

    public int getCount(){
        return (int)itemRepository.count();
    }

    public void saveAll(List<Item> items){
        itemRepository.saveAll(items);
    }

    public Page<Item> filter(Integer page,Integer pageSize,String search,String sortBy,String sortOrder){
        Sort sorted = Sort.by(Util.String(sortBy,"name"));
        if (sorted != null && ("DESC").equals(sortOrder))
            sorted = sorted.descending();

        return itemRepository.filterItems(search,
                    sorted != null ?
                    PageRequest.of(Util.Int(page,0), Util.Int(pageSize,12),sorted) :
                    PageRequest.of(Util.Int(page,0), Util.Int(pageSize,12))
                );
    }



}

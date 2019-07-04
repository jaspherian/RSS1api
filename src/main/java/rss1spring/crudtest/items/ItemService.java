package rss1spring.crudtest.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rss1spring.crudtest.utils.MapConverter;

import java.util.*;

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

    public Page<Item> filter(Map<String,Object> body){
        final int page          = MapConverter.Utils.getInt(body,"page");
        final int pageSize      = MapConverter.Utils.getInt(body,"pageSize",12);
        final String search     = MapConverter.Utils.getStringNoEmpty(body,"search");
        final String sortColumn = MapConverter.Utils.getStringNoEmpty(body,"sortColumn");
        final String sortBy     = MapConverter.Utils.getStringNoEmpty(body,"sortBy");

        Sort sorted = sortColumn!=null ? Sort.by(sortColumn) : null;
        if (sorted != null && sortBy != null && sortBy.equals("DESC"))
            sorted = sorted.descending();

        return itemRepository.filterItems(search,
                    sorted != null ?
                    PageRequest.of(page, pageSize,sorted) :
                    PageRequest.of(page, pageSize)
                );
    }



}

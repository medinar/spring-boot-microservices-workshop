package com.medinar.spring.moviecatalogservice.resource;

import com.medinar.spring.moviecatalogservice.model.CatalogItem;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rommelmedina
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogItems(@PathVariable("userId") String userId) {      
        return Collections.singletonList(
                new CatalogItem("Transformers", "Transformers Desc", 4)
        );
    }
}

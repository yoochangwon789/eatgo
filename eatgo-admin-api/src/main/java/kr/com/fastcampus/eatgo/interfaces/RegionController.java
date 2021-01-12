package kr.com.fastcampus.eatgo.interfaces;

import kr.com.fastcampus.eatgo.application.RegionService;
import kr.com.fastcampus.eatgo.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/regions")
    public List<Region> list() {
        List<Region> regions = regionService.getRegions();
//        List<Region> regions = new ArrayList<>();
//        regions.add(Region.builder().name("Seoul").build());

        return regions;
    }
}

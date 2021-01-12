package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.Region;
import kr.com.fastcampus.eatgo.domain.RegionRepository;
import kr.com.fastcampus.eatgo.domain.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {

    private RegionRepository regionRepository;

    public List<Region> getRegions() {
        List<Region> regions = regionRepository.findAll();

//        List<Region> regions = new ArrayList<>();
//        regions.add(Region.builder().name("Seoul").build());

        return regions;
    }
}

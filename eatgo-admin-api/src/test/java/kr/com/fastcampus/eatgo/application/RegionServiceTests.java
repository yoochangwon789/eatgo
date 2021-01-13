package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.Region;
import kr.com.fastcampus.eatgo.domain.RegionRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class RegionServiceTests {

    private RegionService regionService;

    @Mock
    private RegionRepository regionRepository;

    @Before
    private void setRegionServiceUp(){
        MockitoAnnotations.initMocks(this);
        regionService = new RegionService(regionRepository);
    }

    @Test
    public void getRegions() {
        setRegionServiceUp();

        List<Region> mpckRegions = new ArrayList<>();
        mpckRegions.add(Region.builder().name("Seoul").build());

        given(regionRepository.findAll()).willReturn(mpckRegions);

        List<Region> regions = regionService.getRegions();

        Region region = regions.get(0);
        assertThat(region.getName(), is("Seoul"));
    }

    @Test
    public void addRegion() {
        setRegionServiceUp();
        Region region = regionService.addRegion("Seoul");

        assertThat(region.getName(), is("Seoul"));
    }
}
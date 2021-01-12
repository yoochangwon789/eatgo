package kr.com.fastcampus.eatgo.application;

import kr.com.fastcampus.eatgo.domain.Region;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class RegionServiceTests {

    private RegionService regionService;

    @Before
    private void setRegionServiceUp(){
        regionService = new RegionService();
    }

    @Test
    public void getRegions() {
        setRegionServiceUp();

        List<Region> regions = regionService.getRegions();

        Region region = regions.get(0);
        assertThat(region.getName(), is("Seoul"));
    }
}
package kr.com.fastcampus.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    @Id
    @GeneratedValue
    @Setter
    private Long id;

    private String name;

    private String address;

    // 임시로 처리해 주는 기능
    @Transient
    private List<MenuItem> menuItems;

    public String getInformation() {
        return name + " in " + address;
    }

    public void setMenuItem(List<MenuItem> menuItems) {
        this.menuItems = new ArrayList<>(menuItems);
    }

    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

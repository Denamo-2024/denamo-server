package daenamoo.homepage.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Study {

    @Id @GeneratedValue
    @Column(name = "study_id")
    private Long id;

    private String name;
    private int headCount;
    private int totalStudyCount;
    private int studyCount;
    private boolean is_book;

    @OneToMany(mappedBy = "study")
    private List<MemberStudy> memberStudies = new ArrayList<>();

    @OneToMany(mappedBy = "study")
    private List<Inventory> inventories = new ArrayList<>();

    //연관관계 메서드
    public void addMemberStudy(MemberStudy memberStudy) {
        memberStudies.add(memberStudy);
        memberStudy.setStudy(this);
    }
}
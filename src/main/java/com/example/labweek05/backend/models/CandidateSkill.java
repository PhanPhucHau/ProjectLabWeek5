package com.example.labweek05.backend.models;

import com.example.labweek05.backend.enums.SkillLevel;
import com.example.labweek05.backend.ids.CandidateSkillId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "candidate_skill")
public class CandidateSkill {
    @EmbeddedId
    private CandidateSkillId id;

    @MapsId("canId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "can_id", nullable = false)
    private com.example.labweek05.backend.models.Candidate can;

    @MapsId("skillId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private com.example.labweek05.backend.models.Skill skill;

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Column(name = "skill_level", nullable = false)
    private SkillLevel skillLevel;

    public CandidateSkill() {
    }

    public CandidateSkill(CandidateSkillId id, Candidate can, Skill skill, String moreInfos, SkillLevel skillLevel) {
        this.id = id;
        this.can = can;
        this.skill = skill;
        this.moreInfos = moreInfos;
        this.skillLevel = skillLevel;
    }
}
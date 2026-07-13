package com.scaler.cart.assignments.models.other_assignments;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class WhatsappGroup {
    @Id
    private Long id;

    private String name;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "members_whatsapp_groups ",
            joinColumns = @JoinColumn(name = "whatsapp_group_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Member> members;

    @OneToMany(mappedBy = "group")
    private List<Message> messages;
}


// WG1 -> hello, how are you, I'm fine (single member M1)
// WG2 - > How was you cricket practice last week ? M2
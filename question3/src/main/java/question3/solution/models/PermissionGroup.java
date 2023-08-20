package question3.solution.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "permission_group")
public class PermissionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    @OneToMany(mappedBy = "permissionGroup")
    private List<Item> items;

    // getters and setters
}


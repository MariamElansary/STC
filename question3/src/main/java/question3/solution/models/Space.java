package question3.solution.models;

@Entity
@Table(name = "space")
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "space")
    private List<Folder> folders;

    // Other fields, getters, setters
}


package question3.solution.models;

@Entity
@Table(name = "folder")
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "space_id")
    private Space space;

    @OneToMany(mappedBy = "folder")
    private List<File> files;

    // Other fields, getters, setters
}


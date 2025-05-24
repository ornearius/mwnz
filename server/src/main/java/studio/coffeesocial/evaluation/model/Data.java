package studio.coffeesocial.evaluation.model;

import org.springframework.lang.Nullable;

public class Data {

    public @Nullable Integer id;

    public @Nullable String name;

    public @Nullable String description;

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

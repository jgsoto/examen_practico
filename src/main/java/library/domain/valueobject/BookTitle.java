package library.domain.valueobject;

import java.util.Objects;

public class BookTitle {

    private final String value;

    public BookTitle(String value) {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Title cannot be empty"
            );
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof BookTitle)) {
            return false;
        }

        BookTitle that = (BookTitle) o;

        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
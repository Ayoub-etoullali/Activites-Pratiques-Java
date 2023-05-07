package metier;

import java.io.IOException;
import java.util.List;

public interface IMetier<T> {

        public T add(T o) throws IOException;
        public List<T> getAll() throws IOException;
        public T findById(long id);
        public void delete(long id) throws IOException;
        public void saveAll() throws IOException, ClassNotFoundException;

        public void afficheSeul(T c);
        public void Affiche(List<T> list);

    }


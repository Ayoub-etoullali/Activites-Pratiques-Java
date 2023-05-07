package metier;
import java.io.IOException;
import java.util.List;

public interface IMetierClient {

    public Client addClient(Client c) throws IOException;
    public List<Client> getAllClients() throws IOException;
    public Client findClientById(String id);
    public void deleteClient(String id) throws IOException;
    public void saveAllClients() throws IOException, ClassNotFoundException;
    public void afficheClt(Client c);
    public void Affiche(List<Client> listClient);
}

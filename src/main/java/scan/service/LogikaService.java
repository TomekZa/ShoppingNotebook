package scan.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogikaService {

    private List<String> dane = new ArrayList<>();

    public List<String> pobierzDane(){
        return new ArrayList<>(dane);
    }

    public List<String> pobierzDanePoId(int id) {
        return new ArrayList<>(id);
    }

    public void dodajDane(String daneNowe){
        dane.add(daneNowe);
    }

}

package Repository;

import Model.PrgState;

import java.util.ArrayList;
import java.util.List;

public class Repo implements IRepo{
    private List<PrgState> repo;

    public Repo(){
        this.repo=new ArrayList<>();
    }

    @Override
    public PrgState getCurrentState() {
        return repo.get(0);
    }

    @Override
    public void add(PrgState state) {
        repo.add(state);
    }
}

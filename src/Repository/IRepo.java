package Repository;

import Model.PrgState;

public interface IRepo {
    public PrgState getCurrentState();
    public void add(PrgState state);
}

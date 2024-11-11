package Controller;

import Model.Exceptions.StackEmptyException;
import Model.PrgState;
import Model.Stmt.IStmt;
import Model.Value.Value;
import Repository.IRepo;
import Utils.IExeStack;
import Model.Exceptions.MyException;
import Utils.IList;

public class Controller {
    private IRepo repo;
    boolean displayFlag = true;

    public Controller(IRepo repo){
        this.repo=repo;
    }

    public PrgState oneStep(PrgState state) throws MyException {
        IExeStack<IStmt> stk = state.getStk();
        if(stk.isEmpty()) throw new StackEmptyException();
        IStmt current_stmt = stk.pop();
        return current_stmt.execute(state);
    }

    public void allStep() throws MyException {
        PrgState prg = repo.getCurrentState();
        if(displayFlag)
            System.out.println(prg);
        while (!prg.getStk().isEmpty()){
            oneStep(prg);
            if(displayFlag)
                System.out.println(prg);
        }
        IList<Value> outy = prg.getOut();
        for(int i=0; i<outy.size();i++){
            System.out.println(outy.get(i));
        }
    }

}

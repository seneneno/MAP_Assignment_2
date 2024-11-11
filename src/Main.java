import Controller.Controller;
import Model.Exceptions.MyException;
import Model.PrgState;
import Model.Stmt.IStmt;
import Model.Value.Value;
import Repository.IRepo;
import Repository.Repo;
import Utils.*;
import View.View;

public class Main {
    public static void main(String[] args) throws MyException {
        IExeStack<IStmt> stack = new MyStack<IStmt>();
        IDictionary<String, Value> dictionary = new MyDictionary<>();
        IList<Value> output = new MyList<>();
        View v = new View();
        IStmt ex = v.choose_example();
        PrgState prg = new PrgState(stack,dictionary, output, ex);
        IRepo repo = new Repo();
        repo.add(prg);
        Controller ctr = new Controller(repo);
        v.display_example(ctr);
    }
}
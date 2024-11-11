package View;

import Controller.Controller;
import Model.Exceptions.InputInvalidException;
import Model.Exceptions.MyException;
import Model.Expression.ArithExp;
import Model.Expression.ValueExp;
import Model.Expression.VarExp;
import Model.PrgState;
import Model.Stmt.*;
import Model.Type.BoolType;
import Model.Type.IntType;
import Model.Value.BoolValue;
import Model.Value.IntValue;
import Model.Value.Value;
import Repository.IRepo;
import Repository.Repo;
import Utils.*;

import java.util.Scanner;

import static java.lang.System.exit;

public class View {
    public IStmt choose_example() throws MyException{
        IStmt ex1= new CompStmt(new VarDeclStmt("v",new IntType()),
                new CompStmt(new AssignStmt("v",new ValueExp(new IntValue(2))), new PrintStmt(new VarExp("v"))));
        IStmt ex2 = new CompStmt( new VarDeclStmt("a",new IntType()),
                new CompStmt(new VarDeclStmt("b",new IntType()),
                        new CompStmt(new AssignStmt("a", new ArithExp(new ValueExp(new IntValue(2)),new
                                ArithExp(new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5)),'*'),'+')),
                                new CompStmt(new AssignStmt("b",new ArithExp(new VarExp("a"), new ValueExp(new
                                        IntValue(1)),'+')), new PrintStmt(new VarExp("b"))))));
        IStmt ex3 = new CompStmt(new VarDeclStmt("a",new BoolType()),
                new CompStmt(new VarDeclStmt("v", new IntType()),
                        new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))),
                                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ValueExp(new
                                        IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new
                                        VarExp("v"))))));
       System.out.println("Welcome! Choose which example to test:\n" +
               "1. int v; v=2; Print(v) \n" +
               "2. int a;int b; a=2+3*5;b=a+1;Print(b)\n" +
               "3. bool a; int v; a=true;(If a Then v=2 Else v=3);Print(v)\n" +
               "0. exit\n" +
               "Your example:");
       Scanner input = new Scanner(System.in);
       String comm = input.nextLine();
       return switch(comm){
           case "1"-> ex1;
           case "2" ->ex2;
           case "3"->ex3;
           case "0"->{exit(0);
               yield new NopStmt();}
           default -> throw new InputInvalidException();
       };

    }
    public void display_example(Controller crt){
        try {
            crt.allStep();
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }

}

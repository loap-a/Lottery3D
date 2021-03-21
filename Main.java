import java.util.*;


enum LotteryType {
SINGLE("Single"),GROUP("Group"),ONED("OneD"),GUESS1D("Guess1D"),SUM("Sum"),TRATOR("Trator"),
    GENERAL("General"),TORD("Tord"),GUESS2D("Guess2D"),SELECTALL("SelectAll"),GUESSBIGORSMALL("GuessBigOrSmall"),
    GUESSTRIPLE("GuessTriple"),GUESSDOUBLESINGLE("GuessDoubleSingle");

    private final String description;

    private LotteryType(String des)
    {
        description=des;
    }

    public String toString()
    {
        return description;
    }


}

public class Main {
    public static void main(String[]args)
    {
      Scanner sc=new Scanner(System.in);
      System.out.println("请输入投注方式");
      String game_mode=sc.nextLine();

      switch(game_mode)
      {
          case "single":
          {
              System.out.println("请输入中奖号码");
              String winNumber=sc.nextLine();
              System.out.println("中奖号为"+winNumber);
              System.out.println("请输入0~999之间的整数");
              String userNumber=sc.nextLine();
              Single on_going_lottery=new Single(winNumber,userNumber);
              System.out.print("您获得的奖金为 ");
              System.out.println(on_going_lottery.getWins());
              break;
          }

          case "OneD":
          {
              System.out.println("请输入中奖号码");
              String winNumber=sc.nextLine();
               System.out.println("中奖号为"+winNumber);
              System.out.println("请输入0~999之间的整数");
              String userNumber=sc.nextLine();
              OneD on_going_lottery=new OneD(winNumber,userNumber);
              System.out.print("您获得的奖金为 ");
              System.out.println(on_going_lottery.getWins());
              break;
          }

          case "Group":
          {
              System.out.println("请输入中奖号码");
              String winNumber=sc.nextLine();
              System.out.println("中奖号为"+winNumber);
              System.out.println("请输入0~999之间的整数");
              String userNumber=sc.nextLine();
              Group on_going_lottery=new Group(winNumber,userNumber);
              System.out.print("您获得的奖金为 ");
              System.out.println(on_going_lottery.getWins());
              break;
          }
          case "Sum":
          {
              System.out.println("请输入中奖号码");
              String winNumber=sc.nextLine();
              System.out.println("中奖号为"+winNumber);
              System.out.println("请输入0~999之间的整数");
              String userNumber=sc.nextLine();
              Sum on_going_lottery=new Sum(winNumber,userNumber);
              System.out.print("您获得的奖金为 ");
              System.out.println(on_going_lottery.getWins());
              break;
          }

          case "Trator":
          {
              System.out.println("请输入中奖号码");
              String winNumber=sc.nextLine();
              System.out.println("中奖号为"+winNumber);
              System.out.println("你在猜拖拉机");
              Trator on_going_lottery=new Trator(winNumber);
              System.out.print("您获得的奖金为 ");
              System.out.println(on_going_lottery.getWins());
              break;
          }

          case "General":
          {
              System.out.println("请输入中奖号码");
              String winNumber=sc.nextLine();
              System.out.println("中奖号为"+winNumber);
              System.out.println("请输入0~999之间的整数");
              String userNumber=sc.nextLine();
              General on_going_lottery=new General(winNumber,userNumber);
              System.out.print("您获得的奖金为 ");
              System.out.println(on_going_lottery.getWins());


              break;
          }

          case "Guess1D":
          {
              System.out.println("请输入中奖号码");
              String winNumber=sc.nextLine();
              System.out.println("中奖号为"+winNumber);
              System.out.println("请输入0~999之间的整数");
              String userNumber=sc.nextLine();
              Guess1D on_going_lottery=new Guess1D(winNumber,userNumber);
              System.out.print("您获得的奖金为 ");
              System.out.println(on_going_lottery.getWins());
              break;
          }

          case "Towd":
          {
              System.out.println("请输入中奖号码");
              String winNumber=sc.nextLine();
              System.out.println("中奖号为"+winNumber);
              System.out.println("请输入0~999之间的整数");
              String userNumber=sc.nextLine();
              Towd on_going_lottery=new Towd(winNumber,userNumber);
              System.out.print("您获得的奖金为 ");
              System.out.println(on_going_lottery.getWins());

              break;
          }
          case "Guess2D":
          {
              System.out.println("请输入中奖号码");
              String winNumber=sc.nextLine();
              System.out.println("中奖号为"+winNumber);
              System.out.println("请输入0~999之间的整数");
              String userNumber=sc.nextLine();
              Guess2D on_going_lottery=new Guess2D(winNumber,userNumber);
              System.out.print("您获得的奖金为 ");
              System.out.println(on_going_lottery.getWins());
              break;
          }
          case "SelectAll":
          {
              System.out.println("请输入中奖号码");
              String winNumber=sc.nextLine();
              System.out.println("中奖号为"+winNumber);
              System.out.println("请输入0~999之间的整数");
              String userNumber=sc.nextLine();
              SelectAll on_going_lottery=new SelectAll(winNumber,userNumber);
              System.out.print("您获得的奖金为 ");
              System.out.println(on_going_lottery.getWins());

              break;
          }
          case "GuessBigOrSmall":
          {
              System.out.println("请输入中奖号码");
              String winNumber=sc.nextLine();
              System.out.println("中奖号为"+winNumber);
              System.out.println("请输入big 或 small ");
              String userNumber=sc.nextLine();
              GuessBigOrSmall on_going_lottery=new GuessBigOrSmall(winNumber,userNumber);
              System.out.print("您获得的奖金为 ");
              System.out.println(on_going_lottery.getWins());

              break;
          }
          case "GuessTriple":
          {
              System.out.println("请输入中奖号码");
              String winNumber=sc.nextLine();
              System.out.println("中奖号为"+winNumber);
              System.out.println("你在猜豹子号");
              GuessTriple on_going_lottery=new GuessTriple(winNumber);
              System.out.print("您获得的奖金为 ");
              System.out.println(on_going_lottery.getWins());
              break;
          }
          case "GuessDoubleSingle":
          {
              System.out.println("请输入中奖号码");
              String winNumber=sc.nextLine();
              System.out.println("中奖号为"+winNumber);
              System.out.println("请输入single 或 double ");
              String userNumber=sc.nextLine();
              GuessDoubleSingle on_going_lottery=new GuessDoubleSingle(winNumber,userNumber);
              System.out.print("您获得的奖金为 ");
              System.out.println(on_going_lottery.getWins());


              break;
          }

          default:System.out.println("您输入的投注方法不存在");
      }
    }
}

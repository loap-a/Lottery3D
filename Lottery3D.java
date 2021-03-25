import java.util.regex.Pattern;
public abstract class Lottery3D {
private int[]userNumber;
protected int[]winNumber;
public String userInput;

public Lottery3D(String win_number)
{
    //if(isAvailable(win_number))
this.winNumber=StringtoIntArray(win_number);
}

public Lottery3D(String win_number, String user_input)
{
this(win_number);
this.userInput=user_input;
if(isAvailable(user_input))
{
userNumber=StringtoIntArray(user_input);
}
else System.out.println("输入错误");
}



public void setUserNumber(String user_input)
{
   if(isAvailable(user_input))
   {
     userNumber=StringtoIntArray(user_input);
   }
}

public int[]getUserNumber()
{
    return userNumber;
}
public int getWins()
{

    return 0;
}
public int[]StringtoIntArray(String s)
{
    int n=s.length();
    int []temp=new int[n];
    for(int i=0;i<n;i=i+1)
    {
        temp[i]=(int)((int)s.charAt(i)-(int)'0');
    }
    return temp;
}
public boolean isAvailable(String s)
{
    return Pattern.compile("\\d{3}").matcher(s).matches();
}

}

class OneD extends Lottery3D
{
    private char[]userNumber;
    public OneD(String win_number) {
        super(win_number);
    }
    public OneD(String win_number,String user_number)
    {
        super(win_number);
        if(isAvailable(user_number))
        userNumber=toCharArray(user_number);
    }
    public char[]toCharArray(String s)
    {
        int n=s.length();
        char []temp=new char[n];
        for(int i=0;i<n;++i)
        {
            temp[i]=s.charAt(i);
        }
        return temp;
    }
    @Override
    public boolean isAvailable(String s)
    {
        int count=0;
        boolean temp=false;int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)>='0'&&s.charAt(i)<='9')temp=true;
            if(s.charAt(i)=='*')count++;
        }

        if(count==2&&temp)return true;
        else return false;
    }

    @Override
    public int getWins() {
        for(int i=0;i<3;i=i+1)
        {
            if(winNumber[i]==(userNumber[i]-'0')&&(userNumber[i]>='0'&&userNumber[i]<='9'))
            {
                return 10;
            }
        }

        return 0;
    }
}

class Sum extends Lottery3D{

    private int[] userNumber;
    public Sum(String win_number) {
        super(win_number);
    }
    public Sum(String win_number,String user_number)
    {
        super(win_number,user_number);
        if(isAvailable(user_number))
        userNumber=StringtoIntArray(user_number);
    }

    @Override
    public boolean isAvailable(String s) {
        if(s.length()==1&&s.charAt(0)>='0'&&s.charAt(0)<='9')return true;
        else return false;
    }

    @Override
    public int getWins() {
        int[]wins={1040,345,172,104,69,49,37,29,23,19,16,15,15,14};
        int sum=0;
        for(int i=0;i<3;i=i+1)
        {
            sum+=winNumber[i];
        }

        if(sum==userNumber[0])
        {
            if(sum<=13)return wins[sum];
            else return wins[27-sum];
        }

        return 0;
    }
}

class Guess1D extends Lottery3D
{
    private int[]userNumber;
    public Guess1D(String win_number) {
        super(win_number);
    }

    public Guess1D(String win_number,String user_number)
    {
        super(win_number,user_number);
        if(isAvailable(user_number))
        userNumber=StringtoIntArray(user_number);
    }

    @Override
    public boolean isAvailable(String s)
    {
        if(s.length()==1&&s.charAt(0)>='0'&&s.charAt(0)<='9')return true;
        else return false;
    }

    @Override
    public int getWins() {
        int count=0;
        for(int i=0;i<3;i=i+1)
        {
            if(userNumber[0]==winNumber[i]){count=count+1;}
        }
        if(count==1)return 2;
        if(count==2)return 12;
        if(count==3)return 230;
        return 0;
    }
}

class Single extends Lottery3D
{
    private int[]userNumber;
    public Single(String win_number)
    {
        super(win_number);
    }
    public Single (String win_number, String user_number)
    {
        super(win_number,user_number);
        if(isAvailable(user_number))
        userNumber=StringtoIntArray(user_number);
    }

    @Override
    public boolean isAvailable(String s) {
        boolean flag=true;
        int n=s.length();
        if(n!=3)return false;

        for(int i=0;i<3;i++)
        {
            if(s.charAt(i)<'0'||s.charAt(i)>'9')
                flag=false;
        }

        return flag;
    }
    @Override
  public int getWins()
    {
        boolean flag=true;
        for(int i=0;i<3;i=i+1)
        {
            if(winNumber[i]!=userNumber[i])flag=false;
        }
        if(flag)return 1040;
        else
        return 0;
    }
}

class Group extends Lottery3D
{
private int[]userNumber;
    public Group(String win_number) {
        super(win_number);
    }
    public Group(String win_number,String user_number)
    {
        super(win_number,user_number);
        if(isAvailable(user_number))
        userNumber=StringtoIntArray(user_number);
    }

    @Override
    public boolean isAvailable(String s) {

        boolean flag=true;
        int n=s.length();
        if(n!=3)return false;

        for(int i=0;i<3;i++)
        {
            if(s.charAt(i)<'0'||s.charAt(i)>'9')
                flag=false;
        }

        return flag;
    }
    @Override
    public int getWins()
    {
        int count=0;
        for(int i=0;i<3;++i)
        {
            for(int j=0;j<2;++j)
            {
                if(userNumber[i]<=userNumber[j])
                {
                    int temp=userNumber[i];
                    userNumber[i]=userNumber[j];
                    userNumber[j]=temp;
                }
                if(winNumber[i]<=winNumber[j])
                {
                    int temp=winNumber[i];
                    winNumber[i]=winNumber[j];
                    winNumber[j]=temp;
                }
            }
        }
        for(int l=0;l<3;++l)
        {
            if(userNumber[l]==winNumber[l])
            {
                count=count+1;
            }
        }

        if(count==3)
        {
            boolean flag=false;
            for(int i=0;i<2;i=i+1)
            {
                if(winNumber[i]==winNumber[i+1])
                {
                    flag=true;
                }
            }
            if(flag)return 346;
            else return 173;
        }


        return 0;
    }

}

class Towd extends Lottery3D
{

    private char[]userNumber;
    private char[]winNumber;
    public Towd(String win_number) {
        super(win_number);
    }
    public Towd(String win_number,String user_number)
    {
        super(win_number,user_number);
        if(isAvailable(user_number))
        userNumber=StringToCharArray(user_number);
        winNumber=StringToCharArray(win_number);

    }
    public char[] StringToCharArray(String s)
    {
        int n=s.length();
        char []temp=new char[n];
        for(int i=0;i<n;++i)
        {
            temp[i]=s.charAt(i);
        }
        return temp;
    }

    @Override
    public boolean isAvailable(String s) {
        int count1=0;int count2=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)>='0'&&s.charAt(i)<='9')count1++;
            if(s.charAt(i)=='*')count2++;

        }
        if(count1==2&&count2==1&&n==3)return true;
        else return false;

    }

    @Override
    public int getWins() {
        int count=0;
        for(int i=0;i<3;i=i+1)
        {
            if(winNumber[i]>='0'&&winNumber[0]<='9')
            {
                if(winNumber[i]==userNumber[i]){count=count+1;}
            }
        }
        if(count>=2)return 104;



        return 0;
    }
}



class Guess2D extends Lottery3D
{

    private char[]userNumber;
    private char[]winNumber;

    public Guess2D(String win_number) {
        super(win_number);
    }
    public Guess2D(String win_number,String user_number)
    {
        super(win_number,user_number);
        if(isAvailable(user_number))
        userNumber=StringToCharArray(user_number);
        winNumber=StringToCharArray(win_number);
    }
    public char[]StringToCharArray(String s)
    {
        int n=s.length();
        char []temp=new char[n];
        for(int i=0;i<n;++i)
        {
            temp[i]=s.charAt(i);
        }
        return temp;
    }

    @Override
    public boolean isAvailable(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)>='0'&&s.charAt(i)<='9')count++;
        }
        if(count==2&&n==2)return true;
        else return false;
    }

    @Override
    public int getWins() {

        int count=0;boolean the_same=true;
        for(int i=0;i<userNumber.length-1;i=i+1)
        {
            if(userNumber[i]!=userNumber[i+1])the_same=false;
        }
        for(int i=0;i<userNumber.length;i=i+1)
        {
            boolean flag=false;
            for(int j=0;j<3;j=j+1)
            {
                if(userNumber[i]==winNumber[j])flag=true;
            }
            if(flag){count=count+1;}
        }
        if(count>=2)
        {
            if(the_same)return 37;
            else return 19;
        }

        return 0;
    }
}

class General extends Lottery3D //通选
{
    private int[]userNumber;
    private int[]winNumber;

    public General(String win_number) {
        super(win_number);
    }
    public General(String win_number,String user_number)
    {
        super(win_number,user_number);
        if(isAvailable(user_number))
        userNumber=StringtoIntArray(user_number);
        winNumber=StringtoIntArray(win_number);
    }

    @Override
    public boolean isAvailable(String s) {
        boolean flag=true;
        int n=s.length();
        if(n!=3)return false;

        for(int i=0;i<3;i++)
        {
            if(s.charAt(i)<'0'||s.charAt(i)>'9')
                flag=false;
        }

        return flag;
    }

    @Override
    public int getWins() {
       int count=0;
       for(int i=0;i<3;i=i+1)
       {
           if(userNumber[i]==winNumber[i])
           {
               count=count+1;
           }
       }
       if(count==3)return 470;
       if(count==2)return 21;


        return 0;
    }
}

class GuessBigOrSmall extends Lottery3D
{
    String userNumber;
    public GuessBigOrSmall(String win_number) {
        super(win_number);
    }
    public GuessBigOrSmall(String win_number,String user_number)
    {
        super(win_number);
        if(isAvailable(user_number))
        userNumber=user_number;

    }

    @Override
    public boolean isAvailable(String s) {
        boolean flag=false;
        if(s.equals("big")||s.equals("small"))flag=true;
        return flag;
    }

    @Override
    public int getWins() {
        int sum=0;
        for(int i=0;i<3;i=i+1)
        {
            sum=sum+winNumber[i];
        }
        boolean big=false;
        if(sum>=19)big=true;

        boolean small =false;
        if(sum<=8)small=true;

        if(big&&userNumber.equals("big"))return 6;
        if(small&&userNumber.equals("small"))return 6;

        return 0;
    }
}

class GuessTriple extends Lottery3D
{

    public GuessTriple(String win_number) {
        super(win_number);
    }

    @Override
    public boolean isAvailable(String s) {
        return super.isAvailable(s);
    }

    @Override
    public int getWins() {
        boolean all_the_same=true;
        for(int i=0;i<2;i=i+1)
        {
            if(winNumber[i]!=winNumber[i+1])all_the_same=false;
        }
        if(all_the_same)return 104;

        return 0;

    }
}

class GuessDoubleSingle extends Lottery3D
{
    String userNumber;
    public GuessDoubleSingle(String win_number) {
        super(win_number);
    }
    public GuessDoubleSingle(String win_number,String user_number)
    {
        super(win_number);
        if(isAvailable(user_number))
        userNumber=user_number;
    }

    @Override
    public boolean isAvailable(String s) {


        boolean flag=false;
        if(s.equals("single")||s.equals("double"))flag=true;
        return flag;
    }

    @Override
    public int getWins() {
        boolean single=true;boolean dou_ble=true;
        for(int i=0;i<3;i=i+1)
        {
            if(winNumber[i]%2!=0)dou_ble=false;
            if(winNumber[i]%2!=1)single=false;
        }
        if(single&&userNumber.equals("single"))return 8;
        if(dou_ble&&userNumber.equals("double"))return 8;
        return 0;
    }
}

class Trator extends Lottery3D
{
    public Trator(String win_number) {
        super(win_number);
    }

    @Override
    public boolean isAvailable(String s) {
        return super.isAvailable(s);
    }

    @Override
    public int getWins() {
        boolean flag=true;

        if(winNumber[1]-winNumber[0]==1)
        {
            if(winNumber[2]-winNumber[1]!=1)flag=false;
        }
        else if(winNumber[0]-winNumber[1]==1)
        {
            if(winNumber[1]-winNumber[0]!=1)flag=false;
        }

        if(flag)return 65;
        else
            return 0;
    }
}

class SelectAll extends Lottery3D
{
private int[]userNumber;
    public SelectAll(String win_number) {
        super(win_number);
    }
    public SelectAll(String win_number,String user_number)
    {
        super(win_number,user_number);
        userNumber=StringtoIntArray(user_number);
    }

    @Override
    public boolean isAvailable(String s) {
        boolean flag=true;
        int n=s.length();
        if(n!=3)return false;

        for(int i=0;i<3;i++)
        {
            if(s.charAt(i)<'0'||s.charAt(i)>'9')
                flag=false;
        }

        return flag;
    }

    @Override
    public int getWins() {
        boolean all_the_same=true;
        for(int i=0;i<3;i=i+1)
        {
            if(userNumber[i]!=winNumber[i])all_the_same=false;
        }
        boolean same=false;
        for(int i=0;i<3;i=i+1)
        {
            for(int j=i+1;j<3;j=j+1)
            {
                if(winNumber[j]==winNumber[i])same=true;
            }
        }

        if(all_the_same)
        {
            if(same)return 693;
            else return 606;
        }

        for(int i=0;i<3;++i)
        {
            for(int j=0;j<2;++j)
            {
                if(userNumber[i]<=userNumber[j])
                {
                    int temp=userNumber[i];
                    userNumber[i]=userNumber[j];
                    userNumber[j]=temp;
                }
                if(winNumber[i]<=winNumber[j])
                {
                    int temp=winNumber[i];
                    winNumber[i]=winNumber[j];
                    winNumber[j]=temp;
                }
            }
        }
        boolean the_same=true;
        for(int i=0;i<3;i=i+1)
        {
            if(userNumber[i]!=winNumber[i])the_same=false;
        }
        if(the_same)
        {
            if(same)return 173;
            else return 86;
        }

        return 0;
    }
}

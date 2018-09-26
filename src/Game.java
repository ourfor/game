/*
 *author:ourfor
 *date: 20180919
 *description: 骑士飞行棋
 */

import java.util.Scanner;

public class Game {
    //属性：
    static int role1=0;
    static int role2=0;
    static int random1=0;
    static int random2=0;
    static int locationA=0;
    static int locationB=0;
    static boolean Stop_moveA=false;
    static boolean Stop_moveB=false;
    static String name_role1="";
    static String name_role2="";
    static String ori_map = "@@－－－－★¤－－■－－－★－－－★－－〓－－¤－〓－■－－－－－★－－－－★－¤－－－－〓－－－－★－－－－¤－－－－■－－〓★－－－－－－－－－★■－－〓－〓－－－－¤－－★－－－－－－－〓－－¤";

    //入口
    public static void main(String args[]) {
        Welcome(role1,role2);
        SwitchRole();
        StartingGame(name_role1,name_role2);
        System.out.println("");

        //打印地图
        Print ori = new Print();
        ori.HelpinMap();
        for(;locationA+1<ori_map.length()&&locationB+1<ori_map.length();){
            ori.PrintMap(ori_map);
            ori.A_Move();
            ori.PrintMap(ori_map);
            ori.B_Move();
        }
        ori.GameOver();
        if(locationA>locationB) ori.WinInfor(name_role1);
        else ori.WinInfor(name_role2);
    }

    static void SwitchRole(){
        switch (role1){
            case 1: name_role1="戴高乐";
                break;
            case 2: name_role1="艾森豪威尔";
                break;
            case 3: name_role1="麦克阿瑟";
                break;
            case 4: name_role1="巴顿";
                break;
        }
        switch (role2){
            case 1: name_role2="戴高乐";
                break;
            case 2: name_role2="艾森豪威尔";
                break;
            case 3: name_role2="麦克阿瑟";
                break;
            case 4: name_role2="巴顿";
                break;
        }

    }

    static void Welcome(int role1_,int role2_){
        System.out.println("**************************************************************\n" +
                "*                                                            *\n" +
                "*                                                            *\n" +
                "*                         骑士飞行棋                         *\n" +
                "*                                                            *\n" +
                "*                                                            *\n" +
                "**************************************************************\n" +
                "\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~两  人  对  战~~~~~~~~~~~~~~~~~~~~~~~~");
        /*
        System.out.println("*           骑士飞行棋           *");
        System.out.println("********************************\n");
        System.out.println("~~~~~~两人对战~~~~~~~~~~~~~~~~~~~");
        */
        System.out.println("请选择角色:1.戴高乐 2.艾森豪威尔 3.麦克阿瑟 4.巴顿");
        Scanner input = new Scanner(System.in);
        System.out.print("请玩家1选择角色：");

        while(!input.hasNextInt()||(input.nextInt()<0||input.nextInt()>5)) {
            System.out.println("请按要求输入合法的数字:");
            input.next();
        }
        /*
        while(input.nextInt()<0||input.nextInt()>5) {
            System.out.println("请按要求输入合法的数字:");
            input.next();
        }
        */

        role1_ = input.nextInt();
        role1=role1_;
        System.out.print("请玩家2选择角色：");

        while(!input.hasNextInt()) {
            System.out.println("请按要求输入合法的数字:");
            input.next();
        }

        role2_ = input.nextInt();
        for (; role1_ == role2_; ) {
            System.out.print("不能选择" + role1_ + "号角色，因为玩家一已经选择该角色,请从新选择角色:");
            role2_ = input.nextInt();
        }
        role2=role2_;
    }
    static void StartingGame(String name_role1_,String name_role2_){
        System.out.print("**************************************************************\n" +
                "*                        Game Start                          *\n" +
                "**************************************************************\n");
        System.out.println("^_^"+name_role1_+"的士兵：　A");
        System.out.println("^_^"+name_role2_+"的士兵：　B");

    }

    static int ArgsIslegal(boolean t_f,int num_){
        Scanner ReInput = new Scanner(System.in);
        while(!t_f) {
            System.out.println("请按要求输入合法的数字:");
            ReInput.next();
            t_f=ReInput.hasNextInt();
            if(t_f){
                if(num_==2){
                    if(ReInput.nextInt()<0||ReInput.nextInt()>3) t_f=false;
                }
                else{
                    if(ReInput.nextInt()<0||ReInput.nextInt()>5) t_f=false;
                }
            }
        }
        return ReInput.nextInt();
    }
}

class Print{

    String UpdateMap(String ori_map_){
        String now_map="";
        if(Game.locationA==0&&Game.locationB==0) return ori_map_;

        if(Game.locationA>Game.locationB&&Game.locationB!=0){
            for(int i=0;i<Game.locationB-1;i++){
                now_map+=ori_map_.charAt(i);
            }
            now_map+='B';
            for(int i=Game.locationB;i<Game.locationA-1;i++){
                now_map+=ori_map_.charAt(i);
            }
            now_map+='A';
            for(int i=Game.locationA;i<ori_map_.length();i++){
                now_map+=ori_map_.charAt(i);
            }
            return now_map;
        }
        else if(Game.locationA<Game.locationB&&Game.locationA!=0){
            for(int i=0;i<Game.locationA-1;i++){
                now_map+=ori_map_.charAt(i);
            }
            now_map+='A';
            for(int i=Game.locationA;i<Game.locationB-1;i++){
                now_map+=ori_map_.charAt(i);
            }
            now_map+='B';
            for(int i=Game.locationB;i<ori_map_.length();i++) {
                now_map += ori_map_.charAt(i);
            }
            return now_map;
        }
        if(Game.locationA==0){
            now_map+='A';
            for(int i=1;i<ori_map_.length();i++) now_map+=ori_map_.charAt(i);
        }

        if(Game.locationB==0){
            now_map+='B';
            for(int i=1;i<ori_map_.length();i++) now_map+=ori_map_.charAt(i);
        }
        /*
        else if(Game.locationA==Game.locationB){
            for(int i=0;i<Game.locationB-1;i++){
                now_map+=ori_map_.charAt(i);
            }
            now_map+='B';
            for(int i=Game.locationB;i<ori_map_.length();i++){
                now_map+=ori_map_.charAt(i);
            }
            return now_map;
        }
        */
        return ori_map_;
    }

    void PrintMap(String ori_map_){

        ori_map_=UpdateMap(ori_map_);
        for (int i = 0; i < 32; i++) {
            System.out.print("" + ori_map_.charAt(i));
        }
        System.out.println("");
        for (int i = 32; i < 36; i++)
            System.out.println("                                                " + ori_map_.charAt(i));
        for (int i = 66; i >= 36; i--) {
            System.out.print("" + ori_map_.charAt(i));
        }
        System.out.println("");
        for (int i = 67; i < 70; i++) System.out.println("" + ori_map_.charAt(i));
        for (int i = 70; i < ori_map_.length(); i++) {
            System.out.print("" + ori_map_.charAt(i));
        }
        System.out.println("");
    }

    void HelpinMap(){
        System.out.println("图例说明：\n" +
                "@@ 起点; ■ 暂停; ¤ 幸运轮盘; ★ 地雷; 〓 时空隧道; － 普通\n" +
                "\n" +
                "地图如下：");
    }
    void A_Move(){
        //一号玩家移动
        if(!Game.Stop_moveA) {
            System.out.println(Game.name_role1 + ", 请您按任意字母键后回车启动掷骰子：");
            Scanner reader = new Scanner(System.in);
            if (reader.hasNext()) Game.random1 = (int) (Math.random() * 100) % 5 + 1;
            Game.locationA += Game.random1;

            int move = SpecialLocation(Game.locationA, Game.name_role1);
            if(move == 200) Game.Stop_moveA = true;
            else if(move != 188) Game.locationA = move;
            if(Game.locationA==Game.locationB) Game.locationB=0;

            System.out.printf("-----------------\n骰子数： %d\n\n您当前位置：  %d\n对方当前位置：%d\n-----------------\n", Game.random1, Game.locationA, Game.locationB);
        }
        else {
            System.out.println("\n"+"\n"+Game.name_role1+"停掷一次！\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
            Game.Stop_moveA=false;
        }
    }


    void B_Move(){
        //二号玩家移动
        if(!Game.Stop_moveB) {
            System.out.println(Game.name_role2 + ", 请您按任意字母键后回车启动掷骰子：");
            Scanner reader_2 = new Scanner(System.in);
            if (reader_2.hasNext()) Game.random2 = (int) (Math.random() * 100) % 5 + 1;
            Game.locationB += Game.random2;

            int move = SpecialLocation(Game.locationB, Game.name_role2);
            if(move==200) Game.Stop_moveB=true;
            else if(move != 188) Game.locationB = move;
            if(Game.locationB==Game.locationA) Game.locationA=0;

            System.out.printf("-----------------\n骰子数： %d\n\n您当前位置：  %d\n对方当前位置：%d\n-----------------\n", Game.random2, Game.locationB, Game.locationA);
        }
        else {
            System.out.println("\n"+"\n"+Game.name_role2+"停掷一次！\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
            Game.Stop_moveB=false;
        }
    }

    //返回值说明：200表示暂停，188表示遇到时光轮盘
    int SpecialLocation(int Location_,String role_name_){
        switch(Location_){
            case 11:
            case 29:
            case 62:
            case 77: {StopMove(role_name_);return 200;}
            //break;
            case 22:
            case 27:
            case 47:
            case 65:
            case 80:
            case 82:
            case 98: {return TimeTube(Location_);}
            //break;
            case 7:
            case 15:
            case 35:
            case 40:
            case 52:
            case 66:
            case 76:
            case 90: return Boom(Location_);
            //break;
            case 8:
            case 25:
            case 42:
            case 57:
            case 87:
            case 101: {Lucky(Location_);return 188;}
            //break;
        }
        return Location_;
    }

    void Lucky(int Location_){
        System.out.println("◆◇◆◇◆欢迎进入幸运轮盘◆◇◆◇◆\n" +
                "   请选择一种运气：\n" +
                "   1. 交换位置  2. 轰炸\n" +
                "=============================");
        Scanner input=new Scanner(System.in);

        if(input.nextInt()==1) {
            int temp;
            temp=Game.locationB;
            Game.locationB=Game.locationA;
            Game.locationA=temp;
        }
        else {
            if(Location_==Game.locationA&&Game.locationB>6) Game.locationB-=6;
            else Game.locationB=0;

            if(Location_==Game.locationB&&Game.locationA>6) Game.locationA-=6;
            else Game.locationA=0;
        }

    }

    void StopMove(String role_name_){
        System.out.println("~~>_<~~  要停战一局了。");
    }

    int Boom(int location_){
        System.out.println("~:-(  踩到地雷，气死了...");
        return location_-=6;
    }

    int TimeTube(int location_){
        System.out.println("|-P  进入时空隧道， 真爽！");
        return location_+=10;
    }

    void GameOver(){
        System.out.println("****************************************************\n" +
                "                      Game  Over\n" +
                "****************************************************");
    }

    void WinInfor(String Winner_){
        System.out.println("恭喜"+Winner_+"将军! 您获胜了！");
    }

}



import java.util.Scanner;

public class Map {
    public static void main(String args[]) {
        System.out.println("********************************");
        System.out.println("*           骑士飞行棋           *");
        System.out.println("********************************\n");
        System.out.println("~~~~~~两人对战~~~~~~~~~~~~~~~~~~~");
        System.out.println("请选择角色:1.戴高乐 2.艾森豪威尔 3.麦克阿瑟 4.巴顿");
        Scanner input = new Scanner(System.in);
        System.out.print("请玩家1选择角色：");
        int role1 = input.nextInt();
        System.out.print("请玩家2选择角色：");
        int role2 = input.nextInt();
        for (;role1==role2;){
            System.out.print("不能选择"+(int)role1+"号角色，因为玩家一已经选择该角色,请从新选择角色:");
            role2=input.nextInt();
        }

    }
}



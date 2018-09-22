<h1 align=center> Game Java


<p align=center><img src="https://i.imgur.com/yGBukGp.gif"></p>

<p align=center><b><u><i>为电竞而生(- .-)</i></u></b></p>


<p align=center>
  <a href="https://github.com/ourfor/Game_java/issues"><img src="https://img.shields.io/github/issues/ourfor/Game_java.svg"></a>
  <a href="https://github.com/ourfor/Game_java/stargazers"><img src="https://img.shields.io/github/stars/ourfor/Game_java.svg"></a>
  <a href="https://github.com/ourfor/Game_java/blob/master/LICENSE"><img src="https://img.shields.io/github/license/ourfor/Game_java.svg"></a>
  <a href="//ourfor.top"><img src="https://img.shields.io/badge/Blog-ourfor-orange.svg"></a>
</p>

# 骑士飞行棋
java学习小组的作业就是把这个课堂上老师发的骑士飞行棋的程序代码写出来，刚开始运行这个console端的小程序，感觉比较简陋，由于老师给出的是编译好的字节码，直接在 ***命令提示符窗口*** 或者 ***Terminal*** 中执行` java StartGame `,运行游戏主程序，首先进入角色选择的界面，两个玩家，每个玩家都可以选择4个角色，这四个角色除了名字不一样之外似乎没有太大的区别，整个地图共10行，包含特殊符号，其中第` 1 `行和第` 10 `行是顺序的，第` 6 `行是倒序的。

### 图例说明
```bash
@@ 起点; ■ 暂停; ¤ 幸运轮盘; ★ 地雷; 〓 时空隧道; － 普通
```


# 思路、步骤
<img align=left src=https://i.imgur.com/vnFUtwc.jpg>

初步看一下，整个游戏分为3个部分：
- [x] 打印地图，这个肯定是打印出来的，不是图片
- [x] 玩家位置数据的记录
- [x] 掷骰子，以及玩家处于地图上不同位置的特效

---

#### 打印地图
- 在游戏中，每次打印地图​上最多两个点的数据被更新，绝大部分的点数据是不会改变的，这就意味着，每次打印地图的时候，可以从原始的地图中拷贝，然后单独更新其中两个点的数据，实时更新的地图是原来地图的一个副本，用原始地图初始化实时地图后，玩家的位置在实时地图中改变，而且打印地图的规则不变，如果把地图看成一个字符数组的话，用一个整合好的方法，将数组名作为参数。
- 地图的打印规则，数组的前32个元素，33到36个元素在行末打印，接下来的32和元素倒序打印
- java中貌似只有两种传参的方式，值传递和引用传递，而且和C++中的引用传参还不太一样，而函数返回值只有一个，如果返回一个数组的话，就显得有点小题大作了，还是把这几个需要改变的变量定义为类的属性。



# 已知bug或待改进的地方
<img align=right src=https://i.imgur.com/Re1qsAt.jpg>

- 既然可以选择4个角色，那么这四个角色就不应该仅仅是名字不同而已，还应该有各自的技能，比如：` 戴高乐 `可以免疫一次地雷伤害、` 麦克阿瑟 `遇到幸运轮盘可以有两次机会旋转轮盘等等
- 提示` 按任意字母键后回车启动掷骰子 `,实测按下数字键也是没有问题的，这不算bug，不太严谨。
- 人物选择界面和幸运轮盘选择界面如果输入的不是数字或者不符合选项的数字，程序会停止

---
> 地图上的特殊位置：

```bash
@@－－－
－★¤－－
■－－－★
－－－★－
－〓－－¤
－〓－■－
－－－－★
－－－－★
－¤－－－
－〓－－－
－★－－－
－¤－－－
－■－－〓
★－－－－
－－－－－
★■－－〓
－〓－－－
－¤－－★
－－－－－
－－〓－－
¤

暂停 ■：11,29,62,77
时空隧道 〓: 22,27,47,65,80,82,98
地雷 ★ : 7,15,35,40,52,66,76,90
幸运轮盘 ¤ : 8,25,42,57,87,101

11
29
62
77

22
27
47
65
80
82
98

7
15
35
40
52
66
76
90

8
25
42
57
87
101
```

# 收获
- 大概知道了java里面的几种传值的方式
- 改变了以前那种只用` vim+编译器 ` 的学习方法，认识到了一个好的IDE不仅可以挺高效率，还可以收获一些经验，当然作为初学者，秉持熟悉基本的类的原则，尽量少用IDE。
- ` Source code pro `+` IDEA的Vim `+` Material Theme UI `的 ***code Scheme*** 显示效果不错，另外，Windows下面用记事本敲代码的真的是秀啊，感谢[JatBrain](https://www.jetbrains.com)为学生提高免费的UItimate IDEA

<img src=https://i.imgur.com/PF2W6OX.jpg align=center>
